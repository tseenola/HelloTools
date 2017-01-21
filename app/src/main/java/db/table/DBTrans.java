package db.table;



import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class DBTrans extends DataSupport implements Serializable {
    private static final long serialVersionUID = 3L;

    private int id;
    // 交易类型
    private String TransType;
    // 交易状态(是否已撤销)
    private String TransStatus;
    // 是否已上送
    private String UpToUMP;
    // 流水号
    private String TraceNo;
    // 交易金额
    private double TransAmount;
    // 发送报文
    private String S8583Send;
    // 接收报文
    private String S8583Receive;
    // 订单编号
    private String orderNo;
    // 刷卡模式
    private String cardMode;
    // 打印次数
    private int printTimes;
    // IC卡数据
    private String iccData;
    // 主密钥索引
    private int keyIndex;
    // 卡种
    private String cardType;
    // 是否存在于卡表
    private String existsCardBin;

    public int getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(int keyIndex) {
        this.keyIndex = keyIndex;
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

    public double getTransAmount() {
        return TransAmount;
    }

    public void setTransAmount(double transAmount) {
        TransAmount = transAmount;
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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExistsCardBin() {
        return existsCardBin;
    }

    public void setExistsCardBin(String existsCardBin) {
        this.existsCardBin = existsCardBin;
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
