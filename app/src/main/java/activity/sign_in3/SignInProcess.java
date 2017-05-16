package activity.sign_in3;

import android.app.Activity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import activity.sale2.Process;

/**
 * Created by lenovo on 2017/5/9.
 * 描述：
 */

public class SignInProcess extends Process{
    public SignInProcess(View pView, Activity pContext) {
        super(pView, pContext);
    }

    @Override
    public void packMsg() {
        SignReq3 lSaleReq = new SignReq3();
        lSaleReq.getHexStrMsg();
        EventBus.getDefault().post(lSaleReq);

    }

    @Override
    public boolean onProcessFinish(Object pO) {
        return false;
    }
}
