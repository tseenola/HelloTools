package models;

import java.io.Serializable;

public class PosInputDatas implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 交易金额
     */
    public String sAmt = "";
    /**
     * 持卡人密码
     */
    public String sPINData = "";
    /**
     * 是否重输PIN
     */
    public Boolean bReTryPwd = false;
    /**
     * 帐号
     */
    public String sPan = "";
    /**
     * 二磁
     */
    public String sTrack2 = "";
    /**
     * 三磁
     */
    public String sTrack3 = "";
    /**
     * 卡有效期
     */
    public String sExpDate = "";
    /**
     * 订单号码
     */
    public String sOrderNo = "";
    /**
     * 原交易凭证号
     */
    public String sOldTrace = "";
    /**
     * 表明是插卡还是刷卡或是挥卡
     */
    public byte bSwipedMode = 0;
    /**
     * 当前的交易类型
     */
    public int iTransType = 0;
    /**
     * 交易记录状态
     */
    public String sTransStatus = "";
    /**
     * 是否已经上送
     */
    public String sUpToUNP = "";
    /**
     * 处理类型
     */
    public int type;
    /**
     * IC卡参数
     */
    public String sICCData;
    /**
     * 交易时间
     */
    public String sTradeDate;
    /**
     * 卡种
     */
    public String sCardType;
    /**
     * 是否存在于卡表中
     */
    public String existsCardBin;
    /**
     * 卡序号
     */
    public String sPanSeqNo;
    /**
     * 持卡人验证
     */
    public int cvmStartRet;

    public PosInputDatas() {
        sAmt = "";
        sPINData = "";
        sPan = "";
        sTrack2 = "";
        sTrack3 = "";
        sExpDate = "";
        sOrderNo = "";
        sOldTrace = "";
        bSwipedMode = 0;
        iTransType = 0;
        sTransStatus = "";
        sUpToUNP = "";
        sICCData = "";
        sTradeDate = "";
        sCardType = "";
        existsCardBin = "N";
        sPanSeqNo = "";
        cvmStartRet = 0;
    }
}
