package activity.sign_in.presenter;

import android.content.Context;

import java.io.IOException;

import activity.sign_in.view.ISignInAty;
import factory.FieldFactory;
import pos.BaseDealPrt;
import pos.Field;

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
        try {
            Field lField = FieldFactory.getField(mContext, FieldFactory.DearType.signIn);
            lField.getF41().setValue("1201QZ8Q");
            lField.getF42().setValue("103100048141347");
            byte lSendMsg[] = lField.pack();
            sendAndRcvMsg(lSendMsg, "49.4.175.10", 5005, 50, new OnSendAndRcvFinish() {
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
    }
}
