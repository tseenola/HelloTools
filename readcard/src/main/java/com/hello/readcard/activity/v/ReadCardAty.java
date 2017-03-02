package com.hello.readcard.activity.v;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.hello.readcard.R;
import com.hello.readcard.model.CardInfoModel;
import com.hello.readcard.read_card_service.CardReader;
import com.hello.readcard.read_pwd.PwdReader;


/**
 * Created by lenovo on 2017/2/24.
 * 描述：主要作用是调用 1.刷卡2.pin机密模块
 */

public class ReadCardAty extends Activity implements IReadCardAty {
    public static final String READ_CARD_RESULT = "READ_CARD_RESULT";
    private int mPinKeyIndex;
    private String mAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_read_card);
        Intent lIntent = getIntent();
        mPinKeyIndex = lIntent.getIntExtra("pPinKeyIndex",2);
        int lTimeOutSecs = lIntent.getIntExtra("pTimeOutSecs",15);
        mAmt = lIntent.getStringExtra("pAmt");
        new CardReader().readCard(lTimeOutSecs,this);
    }

    @Override
    public void onReadCardSucc(CardInfoModel pPardInfo) {
        Log.i("vbvb","读卡成功："+pPardInfo.toString());
        new PwdReader().getEncryptedPwd(pPardInfo,mPinKeyIndex,mAmt,this);
    }

    @Override
    public void onReadCardFail(String pFailMsg) {
        Log.i("vbvb","读卡失败："+pFailMsg);
        if(TextUtils.equals("刷卡超时",pFailMsg)){
            Intent lResult = new Intent();
            lResult.putExtra(READ_CARD_RESULT,"读卡失败："+pFailMsg);
            setResult(RESULT_CANCELED,lResult);
            this.finish();
        }
    }

    @Override
    public void onEncryPwdSucc(CardInfoModel pCardInfoModel, String pPinEncryStr) {
        pCardInfoModel.setEncrypedPwd(pPinEncryStr);
        Log.i("vbvb","读卡且获取密码成功："+pCardInfoModel.toString()+" 密码为："+pPinEncryStr);
        Bundle lBundle = new Bundle();
        lBundle.putSerializable("a",pCardInfoModel);
        Intent lResult = new Intent();
        lResult.putExtra(READ_CARD_RESULT,lBundle);
        setResult(RESULT_OK,lResult);
        this.finish();
        //checkICCard(pCardInfoModel,pPinEncryStr, MsgType.BalanceQuery);
    }

    @Override
    public void onEncryPwdFail(String pErroMsg) {
        Log.i("vbvb","读卡且获取密码失败："+pErroMsg);
        Intent lResult = new Intent();
        lResult.putExtra(READ_CARD_RESULT,"读卡且获取密码失败："+pErroMsg);
        setResult(RESULT_CANCELED,lResult);
        this.finish();
    }

}
