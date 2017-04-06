package com.hello.readcard.read_card_service;
import android.os.SystemClock;
import android.util.Log;
import com.hello.readcard.enumm.SwipedMode;
import com.hello.readcard.model.CardInfoModel;
import com.jniexport.UROPElibJni;
import tools.com.hellolibrary.hello_thread.ThreadUtil;


/**
 * Created by 李君 on 2017/2/7.
 * 描述：当涉及消费等需要刷卡时候，调用CardReader（卡片读取者）来进行读卡，读卡结果通过接口回调方式输出到Main线程（主线程）
 * 调用示例：eg:new CardReader().readCard(OnReadCardFinish pOnReadCardFinish);
 * tips:不需要在子线程运行以上示例（读卡函数本身会开启线程池运行），
 */

public class CardReader {
    // 磁条卡
    protected boolean EnableMagChkCard = false;
    // IC卡
    protected boolean EnableICChkCard = false;
    // 非接卡
    protected boolean EnablePICCChkCard = false;
    MagReadService mMagReadService;
    ICReadService mIcReadService;
    PICCReadService mPiccReadService;
    public static boolean mCheckCardThreadIsRun = true;

    public static final int INTERVAL_TIME = 250;

    private int mBigestTimes;


    /**
     * 执行读卡
     * @param pTimeOutSecs 读卡超时时间（单位：秒）
     * @param pOnReadCardFinish 读卡结果回调
     */
    public void readCard(final int pTimeOutSecs, final OnReadCardFinish pOnReadCardFinish) {
        mBigestTimes = 1000/INTERVAL_TIME * pTimeOutSecs;
        mCheckCardThreadIsRun = true;
        ThreadUtil.runFixedService(new Runnable() {
            @Override
            public void run() {
                int time = 0;
                Log.i("vbvb","open");
                UROPElibJni.GMax3250Open();
                UROPElibJni.ICCOpen();
                UROPElibJni.PIccOpen();
                UROPElibJni.MagCardOpen();
                UROPElibJni.PEDatasInit();
                UROPElibJni.SleepEnableSuspend(0);

                mMagReadService = new MagReadService(pOnReadCardFinish);
                mIcReadService = new ICReadService(pOnReadCardFinish);
                mPiccReadService = new PICCReadService(pOnReadCardFinish);
                // 定义检卡类型
                int sCarmode = SwipedMode.CARD_SWIPED.getMode() | SwipedMode.CARD_INSERTED.getMode() | SwipedMode.CLCARD_SWIPED.getMode();

                initCard2(sCarmode);
                while(mCheckCardThreadIsRun) {
                    time++;
                    if(time>=mBigestTimes){
                        mCheckCardThreadIsRun =false;
                        Log.i("vbvb","刷卡超时");
                        ThreadUtil.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pOnReadCardFinish.onReadCardFail("刷卡超时");
                            }
                        });
                    }
                    Log.i("vbvb","循环中");
                    if (EnableMagChkCard) {
                        mMagReadService.ReadMagCard();
                    }
                    if (EnableICChkCard) {
                        mIcReadService.ReadICCard();
                    }
                    if (EnablePICCChkCard) {
                        mPiccReadService.ReadPICCard();
                    }
                    SystemClock.sleep(INTERVAL_TIME);
                    Log.i("vbvb","mCheckCardThreadIsRun:"+ mCheckCardThreadIsRun);
                    if(!mCheckCardThreadIsRun){
                        Log.i("vbvb","close");
                        UROPElibJni.ICCClose();
                        UROPElibJni.PIccClose();
                        UROPElibJni.MagCardClose();
                        UROPElibJni.GMax3250Close();
                        UROPElibJni.SleepEnableSuspend(1);
                    }
                }
                Log.i("vbvb","跳出循环");
            }
        },1);
    }

    /**
     * 读卡完成后回调接口
     */
    public interface OnReadCardFinish {
        void onReadCardSucc(CardInfoModel pPardInfo);
        void onReadCardFail(String pFailMsg);
    }

    /**
     * 初始化读卡类型
     */
    private void initCard2(int cardMode) {
        if ((cardMode & SwipedMode.CARD_SWIPED.getMode()) == SwipedMode.CARD_SWIPED.getMode()) {
            // 磁条卡
            EnableMagChkCard = true;
        }
        if ((cardMode & SwipedMode.CARD_INSERTED.getMode()) == SwipedMode.CARD_INSERTED.getMode()) {
            // IC卡
            EnableICChkCard = true;
        }
        if ((cardMode & SwipedMode.CLCARD_SWIPED.getMode()) == SwipedMode.CLCARD_SWIPED.getMode()) {
            // 挥卡
            EnablePICCChkCard = true;
        }
    }

}
