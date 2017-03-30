package base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.hello.readcard.activity.v.ReadCardAty;
import com.hello.readcard.model.CardInfoModel;
import com.hello.readcard.read_card_service.CardReader;
import com.urovo.poscommon.models.MsgType;

import db.bill.DBPosSettingBill;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellolibrary.hello_dialog.DialogUtil;

import static activity.sale.view.SaleAty.READ_CARD;

/**
 * Created by lenovo on 2017/2/28.
 * 描述：
 */

public abstract class BaseSwipeCardAty extends BaseActivity implements IBaseSwipeCardAty{
    IBaseSwipeCardPrt mIBaseSwipeCardPrt;
    MsgType mMsgType;

    /**
     *
     * @param pIBaseSwipeCardPrt
     * @param pMsgType 交易类型
     * @param pAmt 交易金额,不涉及金额交易时候可以为空
     */
    public void readCard(IBaseSwipeCardPrt pIBaseSwipeCardPrt,MsgType pMsgType,@Nullable String pAmt){
        mIBaseSwipeCardPrt = pIBaseSwipeCardPrt;
        mMsgType = pMsgType;
        Intent intent = new Intent();
        intent.putExtra("pTimeOutSecs",25);//刷卡超时时间
        intent.putExtra("pAmt",pAmt);//交易金额
        intent.putExtra("pPinKeyIndex", DBPosSettingBill.getPinKeyIndex());
        intent.setClass(this, com.hello.readcard.activity.v.ReadCardAty.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, READ_CARD);
    }

    /**
     * 读卡超时
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case READ_CARD:
                if (resultCode == RESULT_OK) {
                    Bundle lBundle = data.getBundleExtra(ReadCardAty.READ_CARD_RESULT);
                    CardInfoModel lCardInfoModel = (CardInfoModel) lBundle.getSerializable("a");
                    Log.i("vbvb", "xixixixsucc:" + lCardInfoModel.toString());
                    DialogUtil.showProgressDialog(this,false,DialogUtil.STYLE_CIRCAL,"消费交易中",25);
                    mIBaseSwipeCardPrt.actionCardDeal(this,lCardInfoModel,mMsgType,this);
                    CardReader.checkCardThreadIsRun = false;
                } else {
                    String result = data.getStringExtra(ReadCardAty.READ_CARD_RESULT);
                    Log.i("vbvb", "xixixixfale:" + result);
                    onDealFail(result,null);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void releaseResource() {

    }

}
