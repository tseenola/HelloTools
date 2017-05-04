package activity.sale2;

import android.app.Activity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by lenovo on 2017/4/24.
 * 描述：
 */

public class SaleProcess extends DefProcessImpl{


    public SaleProcess(View pView, Activity pContext) {
        super(pView, pContext);
    }





    @Override
    public boolean getPwd(OnProcessListener pOnProcessListener) {
        return false;
    }

    @Override
    public void packMsg() {
        SaleReq lSaleReq = new SaleReq(mContext);
        lSaleReq.getHexStrMsg();
        EventBus.getDefault().post(lSaleReq);
    }


    @Override
    public boolean onProcessFinish(Object pO) {
        return false;
    }
}
