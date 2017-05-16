package activity.sale2;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import activity.get_amt.GetAmtAty;
import base.MyApplication;
import db.bill.DBPosSettingBill;
import tools.com.hellolibrary.hello_thread.ThreadUtil;

import static activity.sale.view.SaleAty.READ_CARD;
import static com.hello.readcard.activity.v.ReadCardAty.PINKEY_INDEX;
import static com.hello.readcard.activity.v.ReadCardAty.SWIPE_CARD_AMT;
import static com.hello.readcard.activity.v.ReadCardAty.SWIPE_CARD_TIME_OUT;

/**
 * Created by lenovo on 2017/4/24.
 * 描述：
 */

public abstract class Process implements OnProcessListener {
    public static boolean isGetAmtFinish = false;
    public static boolean isSwipeCardAndGetCardInfoFinish = false;
    public static boolean isPackMsg = false;

    protected View mView;
    protected Activity mContext;

    public Process(View pView,Activity pContext){
        mView = pView;
        mContext = pContext;
    }

    public void wait(boolean pTag){
        while (!pTag){
            SystemClock.sleep(1000);
        }
    }

    /**
     * 签到的流程
     * 1.组包
     * 2.发包
     * 3.组包
     * 4.发包
     * 5.收包
     * 6.解包
     * 7.检查包
     *
     */
    public void actionSignIn(){
        ThreadUtil.runFixedService(new Runnable() {
            @Override
            public void run() {
                Log.i("vbvb","开始组包");
                packMsg();
            }
        },1);
    }

    /**
     * 消费的流程
     * 1.获取金额
     * 2.弹出读卡界面等待用于插卡或者挥卡
     * 3.弹出密码输入框等待输入密码
     * 4.组包
     * 5.发包
     * 6.收包
     * 7.解包
     * 8.检查包
     * 9.打印
     * @param
     */
    public void actionSale(){
        ThreadUtil.runFixedService(new Runnable() {
            @Override
            public void run() {
                getAmt();

                while (!isGetAmtFinish){
                    Log.i("vbvb","还在执行获取金额");
                    SystemClock.sleep(1000);
                }

                Log.i("vbvb","开始刷卡");
                swipeCardAndGetCardInfo();

                while (!isSwipeCardAndGetCardInfoFinish){
                    Log.i("vbvb","还在执行刷卡");
                    SystemClock.sleep(1000);
                }

                Log.i("vbvb","开始组包");
                packMsg();
            }
        },2);
    }

    /**
     * 1.获取金额
     * @return
     */
    public void getAmt(){
        ThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Process.isGetAmtFinish = false;
                GetAmtAty.launch(mContext);
            }
        });
    }


    /**
     * 2.弹出读卡界面等待用于插卡或者挥卡
     * @return
     */
    public void swipeCardAndGetCardInfo(){
        ThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.putExtra(SWIPE_CARD_TIME_OUT,250);
                intent.putExtra(SWIPE_CARD_AMT, MyApplication.getApp().getGetAmtFinishMessage().getAmt());
                intent.putExtra(PINKEY_INDEX, DBPosSettingBill.getPinKeyIndex());
                intent.setClass(mContext, com.hello.readcard.activity.v.ReadCardAty.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivityForResult(intent, READ_CARD);
            }
        });
    }

    /**
     * 3.弹出密码输入框等待输入密码
     * @return
     */



    /**
     * 4.组包
     * @return
     */
    public abstract void packMsg();



}
