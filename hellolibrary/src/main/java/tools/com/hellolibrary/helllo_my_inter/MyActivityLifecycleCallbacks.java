package tools.com.hellolibrary.helllo_my_inter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by lenovo on 2016/9/12.
 * 描述：管理Activity生命周期
 */
public abstract class MyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }
 
}
