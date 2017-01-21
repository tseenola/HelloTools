package db.table;

import org.litepal.crud.DataSupport;

public class DBScriptResult extends DataSupport {
    private int keyIndex;
    private String TraceNo;
    private String S8583Send;
    private String S8583Receive;
    private String ICScript;
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

    public String getICScript() {
        return ICScript;
    }

    public void setICScript(String ICScript) {
        this.ICScript = ICScript;
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
