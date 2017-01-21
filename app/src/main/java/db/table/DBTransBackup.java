package db.table;



import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class DBTransBackup extends DataSupport implements Serializable {
    private static final long serialVersionUID = 3L;

    private int id;
    private String TransType;
    private String TransStatus;
    private String UpToUMP;//是否已经上送
    private String TraceNo;
    private String S8583Send;
    private String S8583Receive;
    private String orderNo;
    private String cardMode;
    private int printTimes;     // 打印次数
    private double TransAmount;
    private String iccData;
    private int keyIndex;

    public int getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(int keyIndex) {
        this.keyIndex = keyIndex;
    }

    public double getTransAmount() {
        return TransAmount;
    }

    public void setTransAmount(double transAmount) {
        TransAmount = transAmount;
    }

    public String getIccData() {
        return iccData;
    }

    public void setIccData(String iccData) {
        this.iccData = iccData;
    }

    public int getPrintTimes() {
        return printTimes;
    }

    public void setPrintTimes(int printTimes) {
        this.printTimes = printTimes;
    }

    public String getCardMode() {
        return cardMode;
    }

    public void setCardMode(String cardMode) {
        this.cardMode = cardMode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTransType() {
        return TransType;
    }

    public void setTransType(String transType) {
        TransType = transType;
    }

    public String getTransStatus() {
        return TransStatus;
    }

    public void setTransStatus(String transStatus) {
        TransStatus = transStatus;
    }

    public String getUpToUMP() {
        return UpToUMP;
    }

    public void setUpToUMP(String upToUMP) {
        UpToUMP = upToUMP;
    }

    public String getTraceNo() {
        return TraceNo;
    }

    public void setTraceNo(String traceNo) {
        TraceNo = traceNo;
    }

    public String getS8583Send() {
        return S8583Send;
    }

    public void setS8583Send(String s8583Send) {
        S8583Send = s8583Send;
    }

    public String getS8583Receive() {
        return S8583Receive;
    }

    public void setS8583Receive(String s8583Receive) {
        S8583Receive = s8583Receive;
    }

}
