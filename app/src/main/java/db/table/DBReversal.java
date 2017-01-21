package db.table;

import org.litepal.crud.DataSupport;

/**
 * 冲正表
 */
public class DBReversal extends DataSupport {
    // 主密钥索引
    private int keyIndex;
    // 凭证号
    private String traceNo;
    // 8583数据
    private String SendDatas;
    // 8583接收数据
    private String receData;
    // 交易类型
    private String transType;
    //主帐号
    private String pan;
    //有效期
    private String expiredDate;
    //CVD2
    private String cvd2;
    //2磁道
    private String track2;
    //3磁道
    private String track3;

    public int getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(int keyIndex) {
        this.keyIndex = keyIndex;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getSendDatas() {
        return SendDatas;
    }

    public void setSendDatas(String sendDatas) {
        SendDatas = sendDatas;
    }

    public String getReceData() {
        return receData;
    }

    public void setReceData(String receData) {
        this.receData = receData;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transtype) {
        this.transType = transtype;
    }

    public String getCvd2() {
        return cvd2;
    }

    public void setCvd2(String cvd2) {
        this.cvd2 = cvd2;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getTrack2() {
        return track2;
    }

    public void setTrack2(String track2) {
        this.track2 = track2;
    }

    public String getTrack3() {
        return track3;
    }

    public void setTrack3(String track3) {
        this.track3 = track3;
    }
}
