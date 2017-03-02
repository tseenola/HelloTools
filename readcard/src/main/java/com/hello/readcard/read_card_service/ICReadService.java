package com.hello.readcard.read_card_service;

import com.hello.readcard.enumm.SwipedMode;
import com.hello.readcard.model.CardInfoModel;
import com.jniexport.UROPElibJni;

import tools.com.hellolibrary.hello_string.StringUtils;


public class ICReadService extends BaseReadService{
    private boolean ICCardReadSuccess = false;
    public ICReadService(CardReader.OnReadCardFinish pOnReadCardFinish) {
        mOnReadCardFinish = pOnReadCardFinish;
        this.ICCardReadSuccess = false;
    }

    /**
     * 检查是否已插卡
     */
    private boolean IsICCardInserted() {
        byte[] rsp = new byte[4];
        int ret = UROPElibJni.ICCCheck(rsp);
        if (ret == 0) {
            // 检查是否插入真正的卡
            if (rsp[0] == 1) {
                sendFailMsgToUiThread("检查是否插入真正的卡");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean PbocICCardInit(byte cardMode, byte flow, byte ectsi, byte cardisSM, byte T9C, byte bForceOnline, Long AuthAmt) {
        int initTransRet = UROPElibJni.initTrans((byte) cardMode, (byte) flow, (byte) ectsi, (byte) cardisSM, (byte) 0x00, (byte) bForceOnline, (long) AuthAmt);
        int createAppRet = UROPElibJni.CreateAppLists();
        if (initTransRet != 0 || createAppRet != 0) {
            // 选择应用时错误
            sendFailMsgToUiThread("选择应用时错误");
            return false;
        }

        int appIndex = 0;
        int appSelRet = UROPElibJni.AppSel(appIndex);
        if (appSelRet != 0) {
            // 选择应用时错误
            sendFailMsgToUiThread("选择应用时错误");
            return false;
        }
        return true;
    }

    /**
     * 读取IC卡
     */
    public void ReadICCard() {
        CardInfoModel cardInfo = new CardInfoModel();
        if (!ICCardReadSuccess) {
            if (IsICCardInserted()) {
                boolean isTrue = PbocICCardInit((byte) 0, (byte) 1, (byte) 0, (byte) 1, (byte) 0x00, (byte) 1, (long) 1);
                if (isTrue) {
                    int readPPRet = UROPElibJni.ReadApp();
                    int cardAuthRet = UROPElibJni.CardAuth();
                    if (readPPRet != 0 || cardAuthRet != 0) {
                        // 脱机数据认证错误
                        sendFailMsgToUiThread("脱机数据认证错误");
                        return;
                    }

                    UROPElibJni.ProcRestric();
                    try {
                        String track2 = GetTlv(0x57);
                        track2 = track2.replace("D", "=");
                        track2 = track2.replace("F", "");

                        if (track2.equals("")) {
                            byte[] arg0 = new byte[4];
                            int ret = UROPElibJni.ICCCheck(arg0);
                            if (ret != 0) {
                                // 中途拔卡
                                sendFailMsgToUiThread("中途拔卡");
                            } else {
                                sendFailMsgToUiThread("读取应用时错误");
                            }
                            return;
                        }
                        int index = track2.indexOf("=");
                        if (index != -1) {
                            // 获得卡号
                            String pan = track2.substring(0, index);
                            cardInfo.setCardNo(pan);
                            cardInfo.setTrack2(track2);
                            cardInfo.setTrack3("");
                            // 有效期
                            String dateEx = track2.substring(index + 1, index + 5);
                            cardInfo.setValidTime(dateEx);
                            // 卡序号
                            String cardSeqNo = GetTlv(0x5F34);
                            cardSeqNo = StringUtils.fillContentBy(StringUtils.Dir.left,"0",cardSeqNo,4);
                            cardInfo.setCardSeqNo(cardSeqNo);
                        }
                    } catch (Exception e) {
                        sendFailMsgToUiThread("读卡错误");
                        return;
                    }
                    // 持卡人验证
                    int cvmStartRet = UROPElibJni.CVMStart();
                    switch (cvmStartRet) {
                        case 0:     // 无需cvm
                        case 49:    // 需要出示证件
                        case 50:    // 需要输入联机密文
                        case 51:    // 需要输入脱机明文
                        case 52:    // 需要输入脱机密文
                            cardInfo.setCvmStartRet(cvmStartRet);
                            break;
                        default:
                            // 持卡人认证错误
                            sendFailMsgToUiThread("持卡人认证错误");
                            return;
                    }
                    if(!cardInfo.getCardNo().isEmpty()) {
                        ICCardReadSuccess = true;
                        //cardInfo.setSwipedMode(Constants.SWIPE_MODE.CARD_INSERTED);
                        cardInfo.setSwipedMode(SwipedMode.CARD_INSERTED);
                        sendSuccMsgToUiThread(cardInfo);
                    }
                }
            }
        }
    }
}
