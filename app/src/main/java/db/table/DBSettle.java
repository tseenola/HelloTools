package db.table;

import org.litepal.crud.DataSupport;

public class DBSettle extends DataSupport {
    // 主密钥索引
    private int keyIndex;
    // 内卡借记总金额
    private String SDebitAMT;
    // 内卡借机总笔数
    private String SDebitS;
    // 内卡贷记总金额
    private String SCreditAMT;
    // 内卡贷记总笔数
    private String SCreditS;
    // 外卡借记总金额
    private String SFrnDebitAMT;
    // 外卡借记总笔数
    private String SFrnDebitS;
    // 外卡贷记总金额
    private String SFrnCreditAMT;
    // 外卡贷记总笔数
    private String SFrnCreditS;

    public DBSettle(int keyIndex, String sDebitAMT, String sCreditAMT, String sDebitS, String sCreditS,
                    String sFrnDebitAMT, String sFrnDebitS, String sFrnCreditS, String sFrnCreditAMT) {
        super();
        this.keyIndex = keyIndex;
        this.SDebitAMT = sDebitAMT;
        this.SCreditAMT = sCreditAMT;
        this.SDebitS = sDebitS;
        this.SCreditS = sCreditS;
        this.SFrnDebitAMT = sFrnDebitAMT;
        this.SFrnDebitS = sFrnDebitS;
        this.SFrnCreditS = sFrnCreditS;
        this.SFrnCreditAMT = sFrnCreditAMT;
    }

    public DBSettle() {
        super();
    }

    public int getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(int keyIndex) {
        this.keyIndex = keyIndex;
    }

    public String getSDebitAMT() {
        return SDebitAMT;
    }

    public void setSDebitAMT(String SDebitAMT) {
        this.SDebitAMT = SDebitAMT;
    }

    public String getSCreditAMT() {
        return SCreditAMT;
    }

    public void setSCreditAMT(String SCreditAMT) {
        this.SCreditAMT = SCreditAMT;
    }

    public String getSDebitS() {
        return SDebitS;
    }

    public void setSDebitS(String SDebitS) {
        this.SDebitS = SDebitS;
    }

    public String getSCreditS() {
        return SCreditS;
    }

    public void setSCreditS(String SCreditS) {
        this.SCreditS = SCreditS;
    }

    public String getSFrnDebitAMT() {
        return SFrnDebitAMT;
    }

    public void setSFrnDebitAMT(String SFrnDebitAMT) {
        this.SFrnDebitAMT = SFrnDebitAMT;
    }

    public String getSFrnDebitS() {
        return SFrnDebitS;
    }

    public void setSFrnDebitS(String SFrnDebitS) {
        this.SFrnDebitS = SFrnDebitS;
    }

    public String getSFrnCreditS() {
        return SFrnCreditS;
    }

    public void setSFrnCreditS(String SFrnCreditS) {
        this.SFrnCreditS = SFrnCreditS;
    }

    public String getSFrnCreditAMT() {
        return SFrnCreditAMT;
    }

    public void setSFrnCreditAMT(String SFrnCreditAMT) {
        this.SFrnCreditAMT = SFrnCreditAMT;
    }
}
