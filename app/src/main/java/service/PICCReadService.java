package service;

import android.util.Log;

import com.jniexport.UROPElibJni;

import core.CardReader;
import models.CardInfoModel;
import models.SwipedMode;
import tools.com.hellolibrary.hello_string.StringUtils;


/**
 * 非接卡读卡服务
 */
public class PICCReadService extends BaseReadService{
    private boolean PICCardReadSuccess = false;
    public PICCReadService(CardReader.OnReadCardFinish pOnReadCardFinish) {
        mOnReadCardFinish = pOnReadCardFinish;
        this.PICCardReadSuccess = false;
    }

    private boolean PbocICCardInit(byte cardMode, byte flow, byte ectsi, byte cardisSM, byte T9C, byte bForceOnline, Long AuthAmt) {
        int initTransRet = UROPElibJni.initTrans((byte) cardMode, (byte) flow, (byte) ectsi, (byte) cardisSM, (byte) 0x00, (byte) bForceOnline, (long) AuthAmt);
        int createAppRet = -1;
        for (int i = 0; i < 3; i++) {
            createAppRet = UROPElibJni.CreateAppLists();
            if (createAppRet == 0) {
                break;
            } else {
                Log.i("vbvb","非接读卡 CreateAppLists Result:" + createAppRet);
            }
        }

        if (initTransRet != 0 || createAppRet != 0) {
            // 选择应用时错误
            sendFailMsgToUiThread("选择应用时错误");
            return false;
        }

        int appIndex = 0;
        int appSelRet = -1;
        for (int i = 0; i < 3; i++) {
            appSelRet = UROPElibJni.AppSel(appIndex);
            if (appSelRet == 0) {
                break;
            } else {
                Log.i("vbvb","非接读卡 AppSel Result" + appSelRet);
            }
        }
        if (appSelRet != 0) {
            sendFailMsgToUiThread("选择应用时错误");
            // 选择应用时错误
            return false;
        }
        return true;
    }

    /**
     * 读取非接卡信息
     */
    public void ReadPICCard() {
        if (!PICCardReadSuccess) {
            int retValue = UROPElibJni.PIccCheck();
            if (retValue == 0) {
                boolean mIsTrue = PbocICCardInit((byte) 1, (byte) 3, (byte) 0, (byte) 1, (byte) 0x31, (byte) 1, (long) 1);
                if (mIsTrue) {
                    int readPPRet = UROPElibJni.ReadApp();
                    if (readPPRet != 0) {
                        // 脱机数据认证错误
                        Log.i("vbvb","非接读卡 ReadApp Result:" + readPPRet);
                        sendFailMsgToUiThread("脱机数据认证错误");
                        return;
                    }
                    int fddaRet = UROPElibJni.QPbocFDDA();
                    switch (fddaRet) {
                        case 50:    // 联机需要输入pin
                        case 223:   // 联机无需输入pin
                        case 203:   // 电子现金消费成功
                        case 204:   // 电子现金消费成功
                            CardInfoModel cardInfo = new CardInfoModel();
                            // 二磁道
                            String track2 = GetTlv(0x57);
                            track2 = track2.replace("D", "=");
                            track2 = track2.replace("F", "");
                            // 卡号
                            String cardNo = track2.split("=")[0];
                            // 有效期
                            String validTime = "";
                            if (track2 != null) {
                                int index = track2.indexOf("=");
                                if (index != -1) {
                                    validTime = track2.substring(index + 1, index + 5);
                                }
                            }
                            // 卡序号
                            String cardSeqNo = GetTlv(0x5F34);
                            cardSeqNo = StringUtils.fillContentBy(StringUtils.Dir.left,"0",cardSeqNo,4);
                            cardInfo.setTrack1("");
                            cardInfo.setTrack2(track2);
                            cardInfo.setTrack3("");
                            cardInfo.setCardNo(cardNo);
                            cardInfo.setValidTime(validTime);
                            cardInfo.setCardSeqNo(cardSeqNo);
                            cardInfo.setCvmStartRet(fddaRet);

                            if(!cardInfo.getCardNo().isEmpty()) {
                                PICCardReadSuccess = true;
                                //cardInfo.setSwipedMode(Constants.SWIPE_MODE.CLCARD_SWIPED);
                                cardInfo.setSwipedMode(SwipedMode.CLCARD_SWIPED);
                                sendSuccMsgToUiThread(cardInfo);
                            }
                            break;
                        default:
                            Log.i("vbvb","非接读卡 QPbocFDDA Result:" + fddaRet);
                            sendFailMsgToUiThread("非接读卡 错误");
                            break;
                    }
                }
            }
        }
    }
}
