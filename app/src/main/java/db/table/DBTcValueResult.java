package db.table;

import org.litepal.crud.DataSupport;

/**TC值的Model
 * Created by KuCoffee on 2016/12/29.
 */

public class DBTcValueResult extends DataSupport {
    protected int keyIndex;
    protected String TraceNo;
    protected String S8583Send;
    protected String S8583Receive;
    protected String tcValue;
    //主帐号
    protected String pan;
    //有效期
    protected String expiredDate;
    //CVD2
    protected String cvd2;
    //2磁道
    protected String track2;
    //3磁道
    protected String track3;

    public int getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(int keyIndex) {
        this.keyIndex = keyIndex;
    }

    public String getS8583Receive() {
        return S8583Receive;
    }

    public void setS8583Receive(String s8583Receive) {
        S8583Receive = s8583Receive;
    }

    public String getS8583Send() {
        return S8583Send;
    }

    public void setS8583Send(String s8583Send) {
        S8583Send = s8583Send;
    }

    public String getTcValue() {
        return tcValue;
    }

    public void setTcValue(String tcValue) {
        this.tcValue = tcValue;
    }

    public String getTraceNo() {
        return TraceNo;
    }

    public void setTraceNo(String traceNo) {
        TraceNo = traceNo;
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
