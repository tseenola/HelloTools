package base;

import android.app.Activity;

import com.facebook.stetho.Stetho;

import java.util.LinkedList;

import db.bill.DBAppParasBill;
import db.bill.DBCapkBill;
import db.bill.DBPosSettingBill;
import db.bill.DBUserBill;
import models.EmvProvider;
import myutils.LogRecUtil;
import tools.com.hellolibrary.hello_base.BaseApplication;
import tools.com.hellolibrary.hello_log.L;
import tools.com.hellolibrary.hello_spref.SPUtils;
import tools.com.hellolibrary.hello_thread.ThreadUtil;

/**
 * Created by lenovo on 2016/10/15.
 * 描述：
 */

public class MyApplication extends BaseApplication{
    private static MyApplication mApp;
    private LinkedList<Activity> mAtyList;
    private Activity mCurActivity;
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
        //这个日志为app日志，日志会上传到ustore
        LogRecUtil.init(this,"HelloTools");
    }

    /**
     * 初始化异常捕获
     */
    @Override
    public void initUncaughtException() {

        L.e("initUncaughtException");
    }

    /**
     * 初始化线程池
     */
    @Override
    public void initThreadUtil() {
        ThreadUtil.initRunOnUiThreadHandler();
        L.e("initThreadUtil  ");
    }

    /**
     * 初始化SharedPreference
     */
    @Override
    public void initSharedSpUtil() {
        SPUtils.initSp(this);
        L.e("initSharedSpUtil  ");
    }

    /**
     * 初始化数据库
     */
    @Override
    public void initDbUtil() {
        if(SPUtils.getBoolean("isFirstInstall",true)){
            DBUserBill.initDBUserTable(this);
            DBPosSettingBill.initPosSettingTable(this);
            new EmvProvider().initAID(EmvProvider.AIDList);
            new EmvProvider().initCAPK(EmvProvider.CapkList);
            SPUtils.putBoolean("isFirstInstall",false);
        }
        new EmvProvider().initTremConfig();
        DBAppParasBill.initEmvAID();
        DBCapkBill.initEmvCapk();
        L.e("initDbUtil");
    }

    /**
     * facebook调试工具
     */
    @Override
    public void initStetho() {
        Stetho.initializeWithDefaults(this);
    }

    /**
     * 当系统内存不足时候执行的回调
     * 请在这里进行资源的回收
     */
    @Override
    public void CallSystemGc() {
        L.e("CallSystemGc  ");
    }

    /**
     * 当App退出时候执行的回调
     * 请在这里进行资源释放
     */
    @Override
    public void killAppReleaseResource() {
        L.e("killAppReleaseResource  ");
        exitAllActivity(mAtyList);
    }

    /**
     * 当activity被创建的时候执行的回调
     * @param pActivity
     */
    @Override
    public void onActivityCreate(Activity pActivity) {
        mCurActivity = pActivity;
        L.e("onActivityCreate  ");
        mAtyList.add(pActivity);
    }

    /**
     * 当Activity被销毁的时候执行回调
     * @param pActivity
     */
    @Override
    public void onActivityDestory(Activity pActivity) {
        L.e("onActivityDestory  ");
        pActivity.finish();
    }

}
