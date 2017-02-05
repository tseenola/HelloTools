package activity.balance.presenter;

import android.content.Context;

import activity.balance.model.BalanceReq;
import activity.balance.view.IBalanceAty;
import base.BaseDealPrt;
import base.BaseReq;
import pos2.fields.F02;
import pos2.fields.F03;
import pos2.fields.F11;
import pos2.fields.F14;
import pos2.fields.F22;
import pos2.fields.F23;
import pos2.fields.F25;
import pos2.fields.F35;
import pos2.fields.F36;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F49;
import pos2.fields.F52;
import pos2.fields.F55;
import pos2.fields.F60;
import pos2.fields.F62;
import pos2.fields.F64;
import pos2.model.Body_STD;

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
        BalanceReq lBalanceReq = new BalanceReq(
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
        });
    }
}
