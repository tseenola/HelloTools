package db.table;

import org.litepal.crud.DataSupport;

public class DBCardBin extends DataSupport {
    // 发卡行名称及机构代码
    private String issueBankName;
    // 卡名
    private String cardName;
    // 主帐号长度
    private int cardNumLen;
    // 主帐号
    private String cardNum;
    // 发卡行标识(卡Bin起始字节)
    private String cardBinOffset;
    // 发卡行标识(卡Bin长度)
    private int cardBinLen;
    // 发卡行标识(卡Bin)
    private String cardBin;
    // 发卡行标识(卡Bin读取磁道)
    private String cardBinReadTrack;
    // 卡种
    private String cardType;

    public DBCardBin() {
        super();
    }

    public DBCardBin(String issueBankName, String cardName, int cardNumLen, String cardNum, String cardBinOffset, int cardBinLen, String cardBin, String cardBinReadTrack, String cardType) {
        super();
        this.issueBankName = issueBankName;
        this.cardName = cardName;
        this.cardNumLen = cardNumLen;
        this.cardNum = cardNum;
        this.cardBinOffset = cardBinOffset;
        this.cardBinLen = cardBinLen;
        this.cardBin = cardBin;
        this.cardBinReadTrack = cardBinReadTrack;
        this.cardType = cardType;
    }

    public String getIssueBankName() {
        return issueBankName;
    }

    public void setIssueBankName(String m_issueBankName) {
        this.issueBankName = m_issueBankName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String m_cardName) {
        this.cardName = m_cardName;
    }

    public int getCardNumLen() {
        return cardNumLen;
    }

    public void setCardNumLen(int m_cardNumLen) {
        this.cardNumLen = m_cardNumLen;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String m_cardNum) {
        this.cardNum = m_cardNum;
    }

    public String getCardBinOffset() {
        return cardBinOffset;
    }

    public void setCardBinOffset(String m_cardBinOffset) {
        this.cardBinOffset = m_cardBinOffset;
    }

    public int getCardBinLen() {
        return cardBinLen;
    }

    public void setCardBinLen(int m_cardBinLen) {
        this.cardBinLen = m_cardBinLen;
    }

    public String getCardBin() {
        return cardBin;
    }

    public void setCardBin(String m_cardBin) {
        this.cardBin = m_cardBin;
    }

    public String getCardBinReadTrack() {
        return cardBinReadTrack;
    }

    public void setCardBinReadTrack(String m_cardBinReadTrack) {
        this.cardBinReadTrack = m_cardBinReadTrack;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String m_cardType) {
        this.cardType = m_cardType;
    }


}
