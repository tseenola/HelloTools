package activity.sign_in.presenter;

import android.content.Context;

import activity.sign_in.view.ISignInAty;
import pos.BaseDealPrt;
import pos2.biz.SignInReq;
import pos2.fields.F03;
import pos2.fields.F25;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F60;

/**
 * Created by lenovo on 2017/1/5.
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
        SignInReq signReq = new SignInReq(
                new F03("940000"),
                new F25("14"),
                new F41("1201QZ8Q"),//ANS
                new F42("103100048141347"),//ANS
                new F60("A00199"));//N
        signReq.actionDeal(mContext,"49.4.175.10",5005,100,"6000080000","0800","03,25,41,42,60",signReq);
    }

    /*@Override
    public void actionSign() {
        try {
            Field lField = FieldFactory.getField(mContext, FieldFactory.DearType.signIn);
            lField.getF41().setValue("1201QZ8Q");
            lField.getF42().setValue("103100048141347");
            byte lSendMsg[] = lField.pack();
            sendAndRcvMsg(mContext,lSendMsg, "49.4.175.10", 5005, 50, new OnSendAndRcvFinish() {
                @Override
                public void onSendAndRcvSucc(String pRcvMsg) {
                    mView.onSignInSucc(pRcvMsg);
                }

                @Override
                public void onSendAndRcvFail(String pMsg) {
                    mView.onSignInFail(pMsg);
                }
            });
        } catch (IOException pE) {
            pE.printStackTrace();
            mView.onSignInFail(pE.getMessage());
        }
    }*/

}
