package activity.balance.presenter;

import android.content.Context;

import activity.balance.view.IBalanceAty;
import base.ReadCardTemp;

/**
 * Created by lenovo on 2017/2/5.
 * 描述：
 */
//public class BalancePrt extends BaseDealPrt implements IBalancePrt{
public class BalancePrt extends ReadCardTemp implements IBalancePrt{

    private final IBalanceAty mView;
    private Context mContext;
    public BalancePrt(IBalanceAty pView) {
        mContext = (Context) pView;
        mView = pView;
    }


    /*@Override
    public void actionReadCard() {
        new CardReader().readCard(new CardReader.OnReadCardFinish() {
            @Override
            public void onReadCardSucc(final CardInfoModel pPardInfo) {
                CardReader.checkCardThreadIsRun = false;
                ThreadUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mView.onReadCardSucc(pPardInfo);
                    }
                });
            }

            @Override
            public void onReadCardFail(final String pFailMsg) {
                ThreadUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mView.onReadCardFail(pFailMsg);
                    }
                });
            }
        });
    }*/

    @Override
    public void actionQueryBalance() {
        actionReadCardProcess();


         /*BalanceReq lBalanceReq = new BalanceReq(
                new F02(SensitiveDataUtil.hideSensitiveData(2,)),
                new F03("310000"),
                new F11(DBPosSettingBill.getTraceNo()+""),
                new F14(SensitiveDataUtil.hideSensitiveData(14,)),
                new F22(""),
                new F23(""),
                new F25("14"),
                new F35(""),
                new F36(""),
                new F41(DBPosSettingBill.getTerminalNo()),
                new F42(DBPosSettingBill.getMerchantNo()),
                new F49("156"),
                new F52(""),
                new F55(""),
                new F60(""),
                new F62(""),
                new F64("")
        );

        lBalanceReq.actionDeal(mContext, "0200", "02,03,11,14,22,23,25,35,36,41,42,49,52,55,60,62,64", lBalanceReq, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {

            }

            @Override
            public void fail(Body_STD pBody_std) {

            }
        });*/
    }
}
