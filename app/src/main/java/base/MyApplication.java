package base;

import android.app.Activity;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.hello.readcard.model.CardInfoModel;
import com.urovo.poscommon.models.EmvProvider;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.LinkedList;

import activity.sale2.Process;
import activity.sale2.SaleReq;
import base.eventbus_bean.GetAmtFinishMessage;
import db.bill.DBAppParasBill;
import db.bill.DBCapkBill;
import db.bill.DBPosSettingBill;
import db.bill.DBUserBill;
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
    private GetAmtFinishMessage mGetAmtFinishMessage;
    private CardInfoModel mCardInfoModel;
    private SaleReq mSaleReq;

    public static MyApplication getApp(){
        return mApp;
    }

    @Override
    public void initEnviroment() {
        L.e("initEnviroment started");
        mApp = this;
        mAtyList = new LinkedList<Activity>();
        EventBus.getDefault().register(this);
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
        EventBus.getDefault().unregister(this);
        System.exit(0);
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
        mAtyList.remove(pActivity);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetAmtFinish(GetAmtFinishMessage pGetAmtFinishMessage){
        mGetAmtFinishMessage = pGetAmtFinishMessage;
        Log.i("vbvb","获取到的金额为："+pGetAmtFinishMessage.getAmt());
        Process.isGetAmtFinish = true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReadCardFinish(CardInfoModel pCardInfoModel){
        mCardInfoModel = pCardInfoModel;
        Log.i("vbvb","获取到了刷卡:"+pCardInfoModel.toString());
        Process.isSwipeCardAndGetCardInfoFinish = true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPackageFinish(SaleReq pSaleReq){
        mSaleReq = pSaleReq;
        Log.i("vbvb","发送出去的报文:"+pSaleReq.toString());
        Process.isPackMsg = true;
    }

    public SaleReq getSaleReq() {
        return mSaleReq;
    }

    public void setSaleReq(SaleReq pSaleReq) {
        mSaleReq = pSaleReq;
    }

    public CardInfoModel getCardInfoModel() {
        return mCardInfoModel;
    }

    public void setCardInfoModel(CardInfoModel pCardInfoModel) {
        mCardInfoModel = pCardInfoModel;
    }

    public GetAmtFinishMessage getGetAmtFinishMessage() {
        return mGetAmtFinishMessage;
    }

    public void setGetAmtFinishMessage(GetAmtFinishMessage pGetAmtFinishMessage) {
        mGetAmtFinishMessage = pGetAmtFinishMessage;
    }
}
