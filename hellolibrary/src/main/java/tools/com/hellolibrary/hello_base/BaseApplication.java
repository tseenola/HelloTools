package tools.com.hellolibrary.hello_base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.List;

import tools.com.hellolibrary.helllo_my_inter.ApplicationTemplate;
import tools.com.hellolibrary.helllo_my_inter.MyActivityLifecycleCallbacks;


/**
 * Created by lenovo on 2016/6/4.
 * 描述：
 */
public  abstract class BaseApplication extends Application implements ApplicationTemplate {

    private MyActivityLifecycleCallbacks mAtyLifeListner;

    @Override
    public void onCreate() {
        super.onCreate();
        initEnviroment();
        initLogRecUtil();
        initUncaughtException();//初始化异常捕获
        initThreadUtil();//初始化线程池工具
        initSharedSpUtil();//初始化SharedPre......
        initDbUtil();//初始化数据库工具
        monitorAcitivtyLife();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        CallSystemGc();//通知Gc
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        CallSystemGc();//通知Gc
    }

    @Override
    public void onTerminate() {

        this.unregisterActivityLifecycleCallbacks(mAtyLifeListner);
        killAppReleaseResource();//退出程序，释放资源
        super.onTerminate();
    }

    public void monitorAcitivtyLife(){
        mAtyLifeListner = new MyActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                onActivityCreate(activity);
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                onActivityDestory(activity);
            }
        };
        this.registerActivityLifecycleCallbacks(mAtyLifeListner);
    }

    @Override
    public void exitAllActivity(List<Activity> pActivityList) {
        for (int i = 0;i<pActivityList.size();i++){
            if(!pActivityList.get(i).isFinishing()){
                pActivityList.get(i).finish();
            }
        }
    }
}
