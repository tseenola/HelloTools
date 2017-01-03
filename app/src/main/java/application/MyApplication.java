package application;

import android.app.Activity;

import java.util.LinkedList;

import tools.com.hellolibrary.hello_base.BaseApplication;
import tools.com.hellolibrary.hello_log.L;

/**
 * Created by lenovo on 2016/10/15.
 * 描述：
 */

public class MyApplication extends BaseApplication{
    private static MyApplication mApp;
    private LinkedList<Activity> mAtyList;
    public static MyApplication getApp(){
        return mApp;
    }
    @Override
    public void initEnviroment() {
        L.e("initEnviroment started");
        mApp = this;
        mAtyList = new LinkedList<Activity>();
    }

    /**
     * 初始化日志记录
     */
    @Override
    public void initLogRecUtil() {
        L.e("initLogRecUtil started");
    }

    /**
     * 初始化异常捕获
     */
    @Override
    public void initUncaughtException() {
        L.e("initUncaughtException started");
    }

    /**
     * 初始化线程池
     */
    @Override
    public void initThreadUtil() {
        L.e("initThreadUtil started");
    }

    /**
     * 初始化SharedPreference
     */
    @Override
    public void initSharedSpUtil() {
        L.e("initSharedSpUtil started");
    }

    /**
     * 初始化数据库
     */
    @Override
    public void initDbUtil() {
        L.e("initDbUtil started");
    }

    /**
     * 当系统内存不足时候执行的回调
     * 请在这里进行资源的回收
     */
    @Override
    public void CallSystemGc() {
        L.e("CallSystemGc started");
    }

    /**
     * 当App退出时候执行的回调
     * 请在这里进行资源释放
     */
    @Override
    public void killAppReleaseResource() {
        L.e("killAppReleaseResource started");
        exitAllActivity(mAtyList);
    }

    /**
     * 当activity被创建的时候执行的回调
     * @param pActivity
     */
    @Override
    public void onActivityCreate(Activity pActivity) {
        L.e("onActivityCreate started");
        mAtyList.add(pActivity);
    }

    /**
     * 当Activity被销毁的时候执行回调
     * @param pActivity
     */
    @Override
    public void onActivityDestory(Activity pActivity) {
        L.e("onActivityDestory started");
    }

}
