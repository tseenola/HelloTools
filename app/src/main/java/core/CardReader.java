package core;

import android.os.SystemClock;
import android.util.Log;

import com.jniexport.UROPElibJni;

import models.CardInfoModel;
import models.SwipedMode;
import service.ICReadService;
import service.MagReadService;
import service.PICCReadService;
import tools.com.hellolibrary.hello_thread.ThreadUtil;

/**
 * Created by lenovo on 2017/2/7.
 * 描述：
 */

public class CardReader {
    // 磁条卡
    protected boolean EnableMagChkCard = false;
    // IC卡
    protected boolean EnableICChkCard = false;
    // 非接卡
    protected boolean EnablePICCChkCard = false;
    MagReadService magReadService;
    ICReadService icReadService;
    PICCReadService piccReadService;
    public static boolean checkCardThreadIsRun = true;
    public void readCard(final OnReadCardFinish pOnReadCardFinish) {
        checkCardThreadIsRun = true;
        ThreadUtil.runCachedService(new Runnable() {
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

                magReadService = new MagReadService(pOnReadCardFinish);
                icReadService = new ICReadService(pOnReadCardFinish);
                piccReadService = new PICCReadService(pOnReadCardFinish);
                // 定义检卡类型
                //byte sCarmode = Constants.SWIPE_MODE.CARD_SWIPED | Constants.SWIPE_MODE.CARD_INSERTED | Constants.SWIPE_MODE.CLCARD_SWIPED;
                int sCarmode = SwipedMode.CARD_SWIPED.getMode() | SwipedMode.CARD_INSERTED.getMode() | SwipedMode.CLCARD_SWIPED.getMode();

                //initCard(sCarmode);
                initCard2(sCarmode);
                while(checkCardThreadIsRun) {
                    time++;
                    if(time>=10){
                        checkCardThreadIsRun=false;
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
                        magReadService.ReadMagCard();
                    }
                    if (EnableICChkCard) {
                        icReadService.ReadICCard();
                    }
                    if (EnablePICCChkCard) {
                        piccReadService.ReadPICCard();
                    }
                    SystemClock.sleep(500);
                    Log.i("vbvb","checkCardThreadIsRun:"+checkCardThreadIsRun);
                    if(!checkCardThreadIsRun){
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
        });
    }

    /**
     * 读卡回调接口
     */
    public interface OnReadCardFinish {
        void onReadCardSucc(CardInfoModel pPardInfo);
        void onReadCardFail(String pFailMsg);
    }

    public interface OnEncryPwdFinish{
        void onEncryPwdSucc(CardInfoModel pCardInfoModel,String pPinEncryStr);
        void onEncryPwdFail(String pErroMsg);
    }

    /**
     * 初始化读卡类型
     */
    private void initCard(byte cardMode) {
        /*if ((cardMode & Constants.SWIPE_MODE.CARD_SWIPED) == Constants.SWIPE_MODE.CARD_SWIPED) {
            // 磁条卡
            EnableMagChkCard = true;
        }
        if ((cardMode & Constants.SWIPE_MODE.CARD_INSERTED) == Constants.SWIPE_MODE.CARD_INSERTED) {
            // IC卡
            EnableICChkCard = true;
        }
        if ((cardMode & Constants.SWIPE_MODE.CLCARD_SWIPED) == Constants.SWIPE_MODE.CLCARD_SWIPED) {
            // 挥卡
            EnablePICCChkCard = true;
        }*/
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
