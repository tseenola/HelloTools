package activity.read_card.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import activity.read_card.presenter.ReadCardPrt;
import core.CardReader;
import models.CardInfoModel;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/2/24.
 * 描述：
 */

public class ReadCardAty extends BaseActivity implements IReadCardAty {
    private ReadCardPrt mPresenter;
    public static final String READ_CARD_RESULT = "READ_CARD_RESULT";
    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_read_card);
    }

    @Override
    public void initListener() {
        mPresenter.actionReadCardProcess();
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new ReadCardPrt(this);

    }


    @Override
    public void onReadCardSucc(CardInfoModel pPardInfo) {
        CardReader.checkCardThreadIsRun = false;
        Log.i("vbvb","读卡成功："+pPardInfo.toString());
        mPresenter.actionReadPwd(pPardInfo);
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
