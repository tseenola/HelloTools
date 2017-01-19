package activity.key_download.present;

import android.content.Context;
import android.widget.Toast;

import activity.key_download.model.KeyDownReq;
import activity.key_download.view.IKeyDownLoadAty;
import base.BaseDealPrt;
import base.BaseReq;
import pos2.fields.F03;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F60;
import pos2.model.Body_STD;

/**
 * Created by lenovo on 2017/1/5.
 * 描述：
 */

public class KeyDownLoadPrt extends BaseDealPrt implements IKeyDownLoadPrt {

    private final IKeyDownLoadAty mView;
    private Context mContext;
    public KeyDownLoadPrt(IKeyDownLoadAty pView) {
        mContext = (Context) pView;
        mView = pView;
    }

    @Override
    public void actionKeyDown() {
        KeyDownReq lKeyDownReq = new KeyDownReq(
                new F03("900000"),
                new F41("1201QZ8Q"),//ANS
                new F42("103100048141347"),//ANS
                new F60("A00199")//N
        );

        lKeyDownReq.actionDeal(mContext, "49.4.175.10", 5005, 100, "6000080000", "0800", "03,41,42,60", lKeyDownReq, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                Toast.makeText(mContext,"succ"+pBody_std.getmF44().getValue(),Toast.LENGTH_LONG).show();
                pBody_std.show();
            }

            @Override
            public void fail(Body_STD pBody_std) {
                Toast.makeText(mContext,"fail"+pBody_std.getmF44().getValue(),Toast.LENGTH_LONG).show();
                pBody_std.show();
            }
        });
    }


    /*@Override
    public void actionKeyDown() {
        try {
            Field lField = FieldFactory.getField(mContext, FieldFactory.DearType.keyDownload);
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
