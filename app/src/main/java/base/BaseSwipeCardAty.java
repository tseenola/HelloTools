package base;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import activity.read_card.view.ReadCardAty;
import models.CardInfoModel;
import models.MsgType;
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
    public void readCard(IBaseSwipeCardPrt pIBaseSwipeCardPrt,MsgType pMsgType){
        mIBaseSwipeCardPrt = pIBaseSwipeCardPrt;
        mMsgType = pMsgType;
        Intent intent = new Intent();
        intent.setClass(this, ReadCardAty.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, READ_CARD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case READ_CARD:
                if (resultCode == RESULT_OK) {
                    Bundle lBundle = data.getBundleExtra(ReadCardAty.READ_CARD_RESULT);
                    CardInfoModel lCardInfoModel = (CardInfoModel) lBundle.getSerializable("a");
                    //mEtAmt.setText(lCardInfoModel.toString());
                    Log.i("vbvb", "xixixixsucc:" + lCardInfoModel.toString());
                    DialogUtil.showProgressDialog(this,false,DialogUtil.STYLE_CIRCAL,"消费交易中",25);
                    //mPresenter.actionSale(lCardInfoModel);
                    //mPresenter.actionCardDeal(lCardInfoModel, MsgType.Sale);
                    mIBaseSwipeCardPrt.actionCardDeal(this,lCardInfoModel,mMsgType,this);
                } else {
                    String result = data.getStringExtra(ReadCardAty.READ_CARD_RESULT);
                    //mEtAmt.setText(result);
                    Log.i("vbvb", "xixixixfale:" + result);
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
