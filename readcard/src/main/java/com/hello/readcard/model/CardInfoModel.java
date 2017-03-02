package com.hello.readcard.model;

import com.hello.readcard.enumm.SwipedMode;

import java.io.Serializable;

/**
 * 卡片信息实体类
 */
public class CardInfoModel implements Serializable{
    private static final long serialVersionUID = -7060210544600464481L;
    private String track1 = "";
    private String track2 = "";
    private String track3 = "";
    private String cardNo = "";
    private String validTime = "";
    private String cardSeqNo = "";
    private int cvmStartRet = 0;
    private String encrypedPwd = "";//加密后的密码
    private SwipedMode mSwipedMode;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTrack1() {
        return track1;
    }

    public void setTrack1(String pTrack1) {
        track1 = pTrack1;
    }

    public String getTrack2() {
        return track2;
    }

    public void setTrack2(String pTrack2) {
        track2 = pTrack2;
    }

    public String getTrack3() {
        return track3;
    }

    public void setTrack3(String pTrack3) {
        track3 = pTrack3;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String pCardNo) {
        cardNo = pCardNo;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String pValidTime) {
        validTime = pValidTime;
    }

    public String getCardSeqNo() {
        return cardSeqNo;
    }

    public void setCardSeqNo(String pCardSeqNo) {
        cardSeqNo = pCardSeqNo;
    }

    public int getCvmStartRet() {
        return cvmStartRet;
    }

    public void setCvmStartRet(int pCvmStartRet) {
        cvmStartRet = pCvmStartRet;
    }

    public String getEncrypedPwd() {
        return encrypedPwd;
    }

    public void setEncrypedPwd(String pEncrypedPwd) {
        encrypedPwd = pEncrypedPwd;
    }

    public SwipedMode getSwipedMode() {
        return mSwipedMode;
    }

    public void setSwipedMode(SwipedMode pSwipedMode) {
        mSwipedMode = pSwipedMode;
    }

    @Override
    public String toString() {
        return "CardInfoModel{" +
                "track1='" + track1 + '\'' +
                ", track2='" + track2 + '\'' +
                ", track3='" + track3 + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", validTime='" + validTime + '\'' +
                ", cardSeqNo='" + cardSeqNo + '\'' +
                ", cvmStartRet=" + cvmStartRet +
                ", encrypedPwd='" + encrypedPwd + '\'' +
                ", mSwipedMode=" + mSwipedMode +
                '}';
    }
}
