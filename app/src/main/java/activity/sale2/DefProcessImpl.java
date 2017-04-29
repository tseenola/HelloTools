package activity.sale2;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import tools.com.hellolibrary.hello_dialog.GetAmtPop;

/**
 * Created by lenovo on 2017/4/24.
 * 描述：
 */

public abstract class DefProcessImpl extends Process{


    public DefProcessImpl(View pView, Activity pContext) {
        super(pView, pContext);
    }

    @Override
    public void getAmt(View pView, Activity pContext) {
        new GetAmtPop().showPopwindow(pView,pContext, Color.parseColor("#D2A2CC"));
    }
}
