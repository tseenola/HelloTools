package models;

/**
 * 卡片信息实体类
 */
public class CardInfoModel {
    private String m_track1 = "";
    private String m_track2 = "";
    private String m_track3 = "";
    private String m_cardNo = "";
    private String m_validTime = "";
    private String m_cardSeqNo = "";
    private int m_cvmStartRet = 0;

    public String getTrack1() {
        return m_track1;
    }

    public void setTrack1(String m_track1) {
        this.m_track1 = m_track1;
    }

    public String getTrack2() {
        return m_track2;
    }

    public void setTrack2(String m_track2) {
        this.m_track2 = m_track2;
    }

    public String getTrack3() {
        return m_track3;
    }

    public void setTrack3(String m_track3) {
        this.m_track3 = m_track3;
    }

    public String getCardNo() {
        return m_cardNo;
    }

    public void setCardNo(String m_cardNo) {
        this.m_cardNo = m_cardNo;
    }

    public String getValidTime() {
        return m_validTime;
    }

    public void setValidTime(String m_validTime) {
        this.m_validTime = m_validTime;
    }

    public String getCardSeqNo() {
        return m_cardSeqNo;
    }

    public void setCardSeqNo(String m_cardSeqNo) {
        this.m_cardSeqNo = m_cardSeqNo;
    }

    public int getCvmStartRet() {
        return m_cvmStartRet;
    }

    public void setCvmStartRet(int m_cvmStartRet) {
        this.m_cvmStartRet = m_cvmStartRet;
    }

    @Override
    public String toString() {
        return "CardInfoModel{" +
                "m_track1='" + m_track1 + '\'' +
                ", m_track2='" + m_track2 + '\'' +
                ", m_track3='" + m_track3 + '\'' +
                ", m_cardNo='" + m_cardNo + '\'' +
                ", m_validTime='" + m_validTime + '\'' +
                ", m_cardSeqNo='" + m_cardSeqNo + '\'' +
                ", m_cvmStartRet=" + m_cvmStartRet +
                '}';
    }
}
