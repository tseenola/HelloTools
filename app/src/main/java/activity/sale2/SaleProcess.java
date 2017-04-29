package activity.sale2;

import android.app.Activity;
import android.view.View;

/**
 * Created by lenovo on 2017/4/24.
 * 描述：
 */

public class SaleProcess extends DefProcessImpl{


    public SaleProcess(View pView, Activity pContext) {
        super(pView, pContext);
    }



    @Override
    public boolean getCardInfo(OnProcessListener pOnProcessListener) {
        return false;
    }

    @Override
    public boolean getPwd(OnProcessListener pOnProcessListener) {
        return false;
    }

    @Override
    public boolean packMsg(OnProcessListener pOnProcessListener) {
        return false;
    }

    @Override
    public boolean onProcessFinish(Object pO) {
        return false;
    }
}
