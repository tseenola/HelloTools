package activity.sign_in.presenter;

import android.content.Context;
import android.widget.Toast;

import activity.sign_in.model.SignInReq;
import activity.sign_in.view.ISignInAty;
import base.BaseDealPrt;
import base.BaseReq;
import db.bill.DBPosSettingBill;
import pos2.fields.F03;
import pos2.fields.F25;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F60;
import pos2.model.Body_STD;

/**
 * Created by lijun on 2017/1/5.
 * 描述：
 */

public class SignInPrt extends BaseDealPrt implements ISignInPrt {

    private final ISignInAty mView;
    private Context mContext;
    public SignInPrt(ISignInAty pView) {
        mContext = (Context) pView;
        mView = pView;
    }

    @Override
    public void actionSign() {
        //封装对象
        SignInReq signReq = new SignInReq(
                new F03("940000"),
                new F25("14"),
                new F41("1201QZ8Q"),//ANS
                new F42("103100048141347"),//ANS
                new F60("A00199"));//N
        //交易并接受结果
        signReq.actionDeal(mContext, "49.4.175.10", 5005, 100, "6000080000", "0800", "03,25,41,42,60", signReq, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                Toast.makeText(mContext,"succ"+pBody_std.getmF44().getValue(),Toast.LENGTH_LONG).show();
                syncParaWithService(pBody_std);
            }

            @Override
            public void fail(Body_STD pBody_std) {
                Toast.makeText(mContext,"fail"+pBody_std.getmF44().getValue(),Toast.LENGTH_LONG).show();
            }
        });
    }


    /**
     * 1.同步批次号
     * 2.同步流水号
     * 3.写入工作密钥
     */
    @Override
    public void syncParaWithService(Body_STD pBody_std) {
        String f63 = pBody_std.getmF62().getValue().split("-->")[1];
        String lBatch = f63.substring(6,12);
        String lTrace = f63.substring(0,6);
        DBPosSettingBill.syncBatchAndTrace(lBatch,lTrace);
        //写入工作密钥
        mView.onSignInSucc("签到成功");
    }
}
