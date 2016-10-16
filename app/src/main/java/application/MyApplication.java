package application;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;

import tools.com.hellolibrary.hello_base.BaseApplication;
import tools.com.hellolibrary.hello_log.SysLog;

/**
 * Created by lenovo on 2016/10/15.
 * 描述：
 */

public class MyApplication extends BaseApplication{
    private static Application mApp;
    private LinkedList<Activity> mAtyList;
    public static Application getApp(){
        return mApp;
    }
    @Override
    public void initEnviroment() {
        SysLog.i("initEnviroment started");
        mApp = this;
        mAtyList = new LinkedList<Activity>();
    }

    /**
     * 初始化日志记录
     */
    @Override
    public void initLogRecUtil() {
        SysLog.i("initLogRecUtil started");
    }

    /**
     * 初始化异常捕获
     */
    @Override
    public void initUncaughtException() {
        SysLog.i("initUncaughtException started");
    }

    /**
     * 初始化线程池
     */
    @Override
    public void initThreadUtil() {
        SysLog.i("initThreadUtil started");
    }

    /**
     * 初始化SharedPreference
     */
    @Override
    public void initSharedSpUtil() {
        SysLog.i("initSharedSpUtil started");
    }

    /**
     * 初始化数据库
     */
    @Override
    public void initDbUtil() {
        SysLog.i("initDbUtil started");
    }

    /**
     * 当系统内存不足时候执行的回调
     * 请在这里进行资源的回收
     */
    @Override
    public void CallSystemGc() {
        SysLog.i("CallSystemGc started");
    }

    /**
     * 当App退出时候执行的回调
     * 请在这里进行资源释放
     */
    @Override
    public void killAppReleaseResource() {
        SysLog.i("killAppReleaseResource started");
        exitAllActivity(mAtyList);
    }

    /**
     * 当activity被创建的时候执行的回调
     * @param pActivity
     */
    @Override
    public void onActivityCreate(Activity pActivity) {
        SysLog.i("onActivityCreate started");
        mAtyList.add(pActivity);
    }

    /**
     * 当Activity被销毁的时候执行回调
     * @param pActivity
     */
    @Override
    public void onActivityDestory(Activity pActivity) {
        SysLog.i("onActivityDestory started");
    }

}
