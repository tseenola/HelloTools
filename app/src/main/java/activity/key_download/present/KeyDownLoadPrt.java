package activity.key_download.present;

import android.content.Context;

import java.io.IOException;

import activity.key_download.view.IKeyDownLoadAty;
import factory.FieldFactory;
import pos.BaseDealPrt;
import pos.Field;

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
        try {
            Field lField = FieldFactory.getField(mContext, FieldFactory.DearType.keyDownload);
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
