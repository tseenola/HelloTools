package db.table;

import org.litepal.crud.DataSupport;

import java.util.List;

public class DBCapk extends DataSupport {
    private String IndexID;
    private String RID;
    private String CA_PKIndex;
    private String CA_HashAlgoIndicator;
    private String CA_PKAlgoIndicator;
    private String LengthOfCAPKModulus;
    private String CAPKModulus;
    private String LengthOfCAPKExponent;
    private String CAPKExponent;
    private String ChecksumHash;
    private String CAPKExpDate;


    public DBCapk() {
        super();
    }

    public DBCapk(String indexID, String rID, String cA_PKIndex, String cA_HashAlgoIndicator,
                  String cA_PKAlgoIndicator, String lengthOfCAPKModulus, String cAPKModulus,
                  String lengthOfCAPKExponent, String cAPKExponent, String checksumHash, String cAPKExpDate) {
        super();
        IndexID = indexID;
        RID = rID;
        CA_PKIndex = cA_PKIndex;
        CA_HashAlgoIndicator = cA_HashAlgoIndicator;
        CA_PKAlgoIndicator = cA_PKAlgoIndicator;
        LengthOfCAPKModulus = lengthOfCAPKModulus;
        CAPKModulus = cAPKModulus;
        LengthOfCAPKExponent = lengthOfCAPKExponent;
        CAPKExponent = cAPKExponent;
        ChecksumHash = checksumHash;
        CAPKExpDate = cAPKExpDate;
    }

    public boolean insert(List<String> capkList) {
        for (String capk : capkList) {
            new DBCapk("", capk, "", "", "", "", "", "", "", "", "").save();
        }
        return true;
    }



    public String getIndexID() {
        return IndexID;
    }

    public void setIndexID(String indexID) {
        IndexID = indexID;
    }

    public String getRID() {
        return RID;
    }

    public void setRID(String rID) {
        RID = rID;
    }

    public String getCA_PKIndex() {
        return CA_PKIndex;
    }

    public void setCA_PKIndex(String cA_PKIndex) {
        CA_PKIndex = cA_PKIndex;
    }

    public String getCA_HashAlgoIndicator() {
        return CA_HashAlgoIndicator;
    }

    public void setCA_HashAlgoIndicator(String cA_HashAlgoIndicator) {
        CA_HashAlgoIndicator = cA_HashAlgoIndicator;
    }

    public String getCA_PKAlgoIndicator() {
        return CA_PKAlgoIndicator;
    }

    public void setCA_PKAlgoIndicator(String cA_PKAlgoIndicator) {
        CA_PKAlgoIndicator = cA_PKAlgoIndicator;
    }

    public String getLengthOfCAPKModulus() {
        return LengthOfCAPKModulus;
    }

    public void setLengthOfCAPKModulus(String lengthOfCAPKModulus) {
        LengthOfCAPKModulus = lengthOfCAPKModulus;
    }

    public String getCAPKModulus() {
        return CAPKModulus;
    }

    public void setCAPKModulus(String cAPKModulus) {
        CAPKModulus = cAPKModulus;
    }

    public String getLengthOfCAPKExponent() {
        return LengthOfCAPKExponent;
    }

    public void setLengthOfCAPKExponent(String lengthOfCAPKExponent) {
        LengthOfCAPKExponent = lengthOfCAPKExponent;
    }

    public String getCAPKExponent() {
        return CAPKExponent;
    }

    public void setCAPKExponent(String cAPKExponent) {
        CAPKExponent = cAPKExponent;
    }

    public String getChecksumHash() {
        return ChecksumHash;
    }

    public void setChecksumHash(String checksumHash) {
        ChecksumHash = checksumHash;
    }

    public String getCAPKExpDate() {
        return CAPKExpDate;
    }

    public void setCAPKExpDate(String cAPKExpDate) {
        CAPKExpDate = cAPKExpDate;
    }
}
