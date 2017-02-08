package activity.balance.presenter;

import android.content.Context;
import android.util.Log;

import activity.balance.view.IBalanceAty;
import base.BaseDealPrt;
import core.CardReader;
import models.CardInfoModel;

/**
 * Created by lenovo on 2017/2/5.
 * 描述：
 */

public class BalancePrt extends BaseDealPrt implements IBalancePrt{

    private final IBalanceAty mView;
    private Context mContext;
    public BalancePrt(IBalanceAty pView) {
        mContext = (Context) pView;
        mView = pView;
    }

    @Override
    public void actionQueryBalance() {

        new CardReader().readCard(new CardReader.OnReadCardFinish() {
            @Override
            public void onSucc(CardInfoModel pPardInfo) {
                CardReader.checkCardThreadIsRun = false;
                Log.i("vbvb","刷卡成功："+pPardInfo.toString());
            }

            @Override
            public void onFail(String pFailMsg) {
                CardReader.checkCardThreadIsRun = false;
                Log.i("vbvb","刷卡失败：" + pFailMsg);
            }
        });



        /*BalanceReq lBalanceReq = new BalanceReq(
                new F02(""),
                new F03(""),
                new F11(""),
                new F14(""),
                new F22(""),
                new F23(""),
                new F25(""),
                new F35(""),
                new F36(""),
                new F41(""),
                new F42(""),
                new F49(""),
                new F52(""),
                new F55(""),
                new F60(""),
                new F62(""),
                new F64("")
        );

        lBalanceReq.actionDeal(mContext, "0800", "02,03,11,14,22,23,25,35,36,41,42,49,52,55,60,62,64", lBalanceReq, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {

            }

            @Override
            public void fail(Body_STD pBody_std) {

            }
        });*/
    }
}
