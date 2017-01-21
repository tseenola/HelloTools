package tools.com.hellolibrary.helllo_my_inter;

import android.app.Activity;

import java.util.List;

/**
 * Created by lenovo on 2016/6/4.
 * 描述：
 */
public interface ApplicationTemplate {

    void initEnviroment();

    void initLogRecUtil();//初始化日志

    void initUncaughtException();//初始化异常捕获

    void initThreadUtil();//初始化线程池

    void initSharedSpUtil();//初始化SharedPreference

    void initDbUtil();//初始化数据库

    void initStetho();//初始化facebook调试工具

    void CallSystemGc();//gc

    void killAppReleaseResource();//关闭程序

    void monitorAcitivtyLife();

    void onActivityCreate(Activity pActivity);

    void onActivityDestory(Activity pActivity);

    void exitAllActivity(List<Activity> pActivityList);
}
