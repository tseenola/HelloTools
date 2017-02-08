package core;

import android.os.SystemClock;
import android.util.Log;

import com.jniexport.UROPElibJni;

import base.Constants;
import models.CardInfoModel;
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

        ThreadUtil.runCachedService(new Runnable() {
            @Override
            public void run() {
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
                byte sCarmode = Constants.SWIPE_MODE.CARD_SWIPED | Constants.SWIPE_MODE.CARD_INSERTED | Constants.SWIPE_MODE.CLCARD_SWIPED;

                initCard(sCarmode);

                do {
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
                    SystemClock.sleep(1000);
                    if(!checkCardThreadIsRun){
                        Log.i("vbvb","close");
                        UROPElibJni.ICCClose();
                        UROPElibJni.PIccClose();
                        UROPElibJni.MagCardClose();
                        UROPElibJni.GMax3250Close();
                        UROPElibJni.SleepEnableSuspend(1);
                    }
                }while (checkCardThreadIsRun);
                Log.i("vbvb","跳出循环");
            }
        });
    }

    public interface OnReadCardFinish {
        void onSucc(CardInfoModel pPardInfo);
        void onFail(String pFailMsg);
    }

    /**
     * 初始化读卡类型
     */
    private void initCard(byte cardMode) {
        if ((cardMode & Constants.SWIPE_MODE.CARD_SWIPED) == Constants.SWIPE_MODE.CARD_SWIPED) {
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
        }
    }
}
