package db.table;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 银行卡参数
 */
public class DBAppParas extends DataSupport {
    private String IndexID;
    private String AID;
    private String AID_Length;
    private String bAppSelIndicator;
    private String bTerminalPriority;
    private String bMaxTargetDomestic;
    private String bTargetPercentageDomestic;
    private String abTFL_Domestic;
    private String abThresholdValueDomestic;
    private String bMaxTargetPercentageInt;
    private String bTargetPercentageInt;
    private String abTFL_International;
    private String abThresholdValueInt;
    private String abTerminalApplVersion;
    private String abMerchantCategoryCode;
    private String bTransactionCategoryCode;
    private String abTrnCurrencyCode;
    private String abTerminalCountryCode;
    private String TAC_Default;
    private String TAC_Denial;
    private String TAC_Online;
    private String abDDOL;
    private String DDOL_Length;
    private String abTDOL;
    private String TDOL_Length;
    private String abTrnCurrencyExp;
    private String abEC_TFL;
    private String TerminalType;
    private String TerminalCap;
    private String AddTerminalCap;
    private String abRFOfflineLimit;
    private String abRFTransLimit;
    private String abRFCVMLimit;
    private String abTransProp;
    private String bStatusCheck;
    private String abAcquirerID;



    public DBAppParas() {
        super();
    }

    public DBAppParas(String indexID, String aID, String aID_Length, String bAppSelIndicator,
                      String bTerminalPriority, String bMaxTargetDomestic, String bTargetPercentageDomestic,
                      String abTFL_Domestic, String abThresholdValueDomestic, String bMaxTargetPercentageInt,
                      String bTargetPercentageInt, String abTFL_International, String abThresholdValueInt,
                      String abTerminalApplVersion, String abMerchantCategoryCode,
                      String bTransactionCategoryCode, String abTrnCurrencyCode,
                      String abTerminalCountryCode, String tAC_Default, String tAC_Denial, String tAC_Online,
                      String abDDOL, String dDOL_Length, String abTDOL, String tDOL_Length,
                      String abTrnCurrencyExp, String abEC_TFL, String terminalType, String terminalCap,
                      String addTerminalCap, String abRFOfflineLimit, String abRFTransLimit,
                      String abRFCVMLimit, String abTransProp, String bStatusCheck, String abAcquirerID) {
        super();
        IndexID = indexID;
        AID = aID;
        AID_Length = aID_Length;
        this.bAppSelIndicator = bAppSelIndicator;
        this.bTerminalPriority = bTerminalPriority;
        this.bMaxTargetDomestic = bMaxTargetDomestic;
        this.bTargetPercentageDomestic = bTargetPercentageDomestic;
        this.abTFL_Domestic = abTFL_Domestic;
        this.abThresholdValueDomestic = abThresholdValueDomestic;
        this.bMaxTargetPercentageInt = bMaxTargetPercentageInt;
        this.bTargetPercentageInt = bTargetPercentageInt;
        this.abTFL_International = abTFL_International;
        this.abThresholdValueInt = abThresholdValueInt;
        this.abTerminalApplVersion = abTerminalApplVersion;
        this.abMerchantCategoryCode = abMerchantCategoryCode;
        this.bTransactionCategoryCode = bTransactionCategoryCode;
        this.abTrnCurrencyCode = abTrnCurrencyCode;
        this.abTerminalCountryCode = abTerminalCountryCode;
        TAC_Default = tAC_Default;
        TAC_Denial = tAC_Denial;
        TAC_Online = tAC_Online;
        this.abDDOL = abDDOL;
        DDOL_Length = dDOL_Length;
        this.abTDOL = abTDOL;
        TDOL_Length = tDOL_Length;
        this.abTrnCurrencyExp = abTrnCurrencyExp;
        this.abEC_TFL = abEC_TFL;
        TerminalType = terminalType;
        TerminalCap = terminalCap;
        AddTerminalCap = addTerminalCap;
        this.abRFOfflineLimit = abRFOfflineLimit;
        this.abRFTransLimit = abRFTransLimit;
        this.abRFCVMLimit = abRFCVMLimit;
        this.abTransProp = abTransProp;
        this.bStatusCheck = bStatusCheck;
        this.abAcquirerID = abAcquirerID;
    }

    public boolean insertAidList(List<String> aidList) {
        for (String aid : aidList) {
            new DBAppParas("", aid, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "").save();
        }
        return true;
    }

    public boolean insert(String aid) {
        new DBAppParas("", aid, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "").save();
        return true;
    }


    /**
     * @return the indexID
     */
    public String getIndexID() {
        return IndexID;
    }

    /**
     * @param indexID the indexID to set
     */
    public void setIndexID(String indexID) {
        IndexID = indexID;
    }

    /**
     * @return the aID
     */
    public String getAID() {
        return AID;
    }

    /**
     * @param aID the aID to set
     */
    public void setAID(String aID) {
        AID = aID;
    }

    /**
     * @return the aID_Length
     */
    public String getAID_Length() {
        return AID_Length;
    }

    /**
     * @param aID_Length the aID_Length to set
     */
    public void setAID_Length(String aID_Length) {
        AID_Length = aID_Length;
    }

    /**
     * @return the bAppSelIndicator
     */
    public String getbAppSelIndicator() {
        return bAppSelIndicator;
    }

    /**
     * @param bAppSelIndicator the bAppSelIndicator to set
     */
    public void setbAppSelIndicator(String bAppSelIndicator) {
        this.bAppSelIndicator = bAppSelIndicator;
    }

    /**
     * @return the bTerminalPriority
     */
    public String getbTerminalPriority() {
        return bTerminalPriority;
    }

    /**
     * @param bTerminalPriority the bTerminalPriority to set
     */
    public void setbTerminalPriority(String bTerminalPriority) {
        this.bTerminalPriority = bTerminalPriority;
    }

    /**
     * @return the bMaxTargetDomestic
     */
    public String getbMaxTargetDomestic() {
        return bMaxTargetDomestic;
    }

    /**
     * @param bMaxTargetDomestic the bMaxTargetDomestic to set
     */
    public void setbMaxTargetDomestic(String bMaxTargetDomestic) {
        this.bMaxTargetDomestic = bMaxTargetDomestic;
    }

    /**
     * @return the bTargetPercentageDomestic
     */
    public String getbTargetPercentageDomestic() {
        return bTargetPercentageDomestic;
    }

    /**
     * @param bTargetPercentageDomestic the bTargetPercentageDomestic to set
     */
    public void setbTargetPercentageDomestic(String bTargetPercentageDomestic) {
        this.bTargetPercentageDomestic = bTargetPercentageDomestic;
    }

    /**
     * @return the abTFL_Domestic
     */
    public String getAbTFL_Domestic() {
        return abTFL_Domestic;
    }

    /**
     * @param abTFL_Domestic the abTFL_Domestic to set
     */
    public void setAbTFL_Domestic(String abTFL_Domestic) {
        this.abTFL_Domestic = abTFL_Domestic;
    }

    /**
     * @return the abThresholdValueDomestic
     */
    public String getAbThresholdValueDomestic() {
        return abThresholdValueDomestic;
    }

    /**
     * @param abThresholdValueDomestic the abThresholdValueDomestic to set
     */
    public void setAbThresholdValueDomestic(String abThresholdValueDomestic) {
        this.abThresholdValueDomestic = abThresholdValueDomestic;
    }

    /**
     * @return the bMaxTargetPercentageInt
     */
    public String getbMaxTargetPercentageInt() {
        return bMaxTargetPercentageInt;
    }

    /**
     * @param bMaxTargetPercentageInt the bMaxTargetPercentageInt to set
     */
    public void setbMaxTargetPercentageInt(String bMaxTargetPercentageInt) {
        this.bMaxTargetPercentageInt = bMaxTargetPercentageInt;
    }

    /**
     * @return the bTargetPercentageInt
     */
    public String getbTargetPercentageInt() {
        return bTargetPercentageInt;
    }

    /**
     * @param bTargetPercentageInt the bTargetPercentageInt to set
     */
    public void setbTargetPercentageInt(String bTargetPercentageInt) {
        this.bTargetPercentageInt = bTargetPercentageInt;
    }

    /**
     * @return the abTFL_International
     */
    public String getAbTFL_International() {
        return abTFL_International;
    }

    /**
     * @param abTFL_International the abTFL_International to set
     */
    public void setAbTFL_International(String abTFL_International) {
        this.abTFL_International = abTFL_International;
    }

    /**
     * @return the abThresholdValueInt
     */
    public String getAbThresholdValueInt() {
        return abThresholdValueInt;
    }

    /**
     * @param abThresholdValueInt the abThresholdValueInt to set
     */
    public void setAbThresholdValueInt(String abThresholdValueInt) {
        this.abThresholdValueInt = abThresholdValueInt;
    }

    /**
     * @return the abTerminalApplVersion
     */
    public String getAbTerminalApplVersion() {
        return abTerminalApplVersion;
    }

    /**
     * @param abTerminalApplVersion the abTerminalApplVersion to set
     */
    public void setAbTerminalApplVersion(String abTerminalApplVersion) {
        this.abTerminalApplVersion = abTerminalApplVersion;
    }

    /**
     * @return the abMerchantCategoryCode
     */
    public String getAbMerchantCategoryCode() {
        return abMerchantCategoryCode;
    }

    /**
     * @param abMerchantCategoryCode the abMerchantCategoryCode to set
     */
    public void setAbMerchantCategoryCode(String abMerchantCategoryCode) {
        this.abMerchantCategoryCode = abMerchantCategoryCode;
    }

    /**
     * @return the bTransactionCategoryCode
     */
    public String getbTransactionCategoryCode() {
        return bTransactionCategoryCode;
    }

    /**
     * @param bTransactionCategoryCode the bTransactionCategoryCode to set
     */
    public void setbTransactionCategoryCode(String bTransactionCategoryCode) {
        this.bTransactionCategoryCode = bTransactionCategoryCode;
    }

    /**
     * @return the abTrnCurrencyCode
     */
    public String getAbTrnCurrencyCode() {
        return abTrnCurrencyCode;
    }

    /**
     * @param abTrnCurrencyCode the abTrnCurrencyCode to set
     */
    public void setAbTrnCurrencyCode(String abTrnCurrencyCode) {
        this.abTrnCurrencyCode = abTrnCurrencyCode;
    }

    /**
     * @return the abTerminalCountryCode
     */
    public String getAbTerminalCountryCode() {
        return abTerminalCountryCode;
    }

    /**
     * @param abTerminalCountryCode the abTerminalCountryCode to set
     */
    public void setAbTerminalCountryCode(String abTerminalCountryCode) {
        this.abTerminalCountryCode = abTerminalCountryCode;
    }

    /**
     * @return the tAC_Default
     */
    public String getTAC_Default() {
        return TAC_Default;
    }

    /**
     * @param tAC_Default the tAC_Default to set
     */
    public void setTAC_Default(String tAC_Default) {
        TAC_Default = tAC_Default;
    }

    /**
     * @return the tAC_Denial
     */
    public String getTAC_Denial() {
        return TAC_Denial;
    }

    /**
     * @param tAC_Denial the tAC_Denial to set
     */
    public void setTAC_Denial(String tAC_Denial) {
        TAC_Denial = tAC_Denial;
    }

    /**
     * @return the tAC_Online
     */
    public String getTAC_Online() {
        return TAC_Online;
    }

    /**
     * @param tAC_Online the tAC_Online to set
     */
    public void setTAC_Online(String tAC_Online) {
        TAC_Online = tAC_Online;
    }

    /**
     * @return the abDDOL
     */
    public String getAbDDOL() {
        return abDDOL;
    }

    /**
     * @param abDDOL the abDDOL to set
     */
    public void setAbDDOL(String abDDOL) {
        this.abDDOL = abDDOL;
    }

    /**
     * @return the dDOL_Length
     */
    public String getDDOL_Length() {
        return DDOL_Length;
    }

    /**
     * @param dDOL_Length the dDOL_Length to set
     */
    public void setDDOL_Length(String dDOL_Length) {
        DDOL_Length = dDOL_Length;
    }

    /**
     * @return the abTDOL
     */
    public String getAbTDOL() {
        return abTDOL;
    }

    /**
     * @param abTDOL the abTDOL to set
     */
    public void setAbTDOL(String abTDOL) {
        this.abTDOL = abTDOL;
    }

    /**
     * @return the tDOL_Length
     */
    public String getTDOL_Length() {
        return TDOL_Length;
    }

    /**
     * @param tDOL_Length the tDOL_Length to set
     */
    public void setTDOL_Length(String tDOL_Length) {
        TDOL_Length = tDOL_Length;
    }

    /**
     * @return the abTrnCurrencyExp
     */
    public String getAbTrnCurrencyExp() {
        return abTrnCurrencyExp;
    }

    /**
     * @param abTrnCurrencyExp the abTrnCurrencyExp to set
     */
    public void setAbTrnCurrencyExp(String abTrnCurrencyExp) {
        this.abTrnCurrencyExp = abTrnCurrencyExp;
    }

    /**
     * @return the abEC_TFL
     */
    public String getAbEC_TFL() {
        return abEC_TFL;
    }

    /**
     * @param abEC_TFL the abEC_TFL to set
     */
    public void setAbEC_TFL(String abEC_TFL) {
        this.abEC_TFL = abEC_TFL;
    }

    /**
     * @return the terminalType
     */
    public String getTerminalType() {
        return TerminalType;
    }

    /**
     * @param terminalType the terminalType to set
     */
    public void setTerminalType(String terminalType) {
        TerminalType = terminalType;
    }

    /**
     * @return the terminalCap
     */
    public String getTerminalCap() {
        return TerminalCap;
    }

    /**
     * @param terminalCap the terminalCap to set
     */
    public void setTerminalCap(String terminalCap) {
        TerminalCap = terminalCap;
    }

    /**
     * @return the addTerminalCap
     */
    public String getAddTerminalCap() {
        return AddTerminalCap;
    }

    /**
     * @param addTerminalCap the addTerminalCap to set
     */
    public void setAddTerminalCap(String addTerminalCap) {
        AddTerminalCap = addTerminalCap;
    }

    /**
     * @return the abRFOfflineLimit
     */
    public String getAbRFOfflineLimit() {
        return abRFOfflineLimit;
    }

    /**
     * @param abRFOfflineLimit the abRFOfflineLimit to set
     */
    public void setAbRFOfflineLimit(String abRFOfflineLimit) {
        this.abRFOfflineLimit = abRFOfflineLimit;
    }

    /**
     * @return the abRFTransLimit
     */
    public String getAbRFTransLimit() {
        return abRFTransLimit;
    }

    /**
     * @param abRFTransLimit the abRFTransLimit to set
     */
    public void setAbRFTransLimit(String abRFTransLimit) {
        this.abRFTransLimit = abRFTransLimit;
    }

    /**
     * @return the abRFCVMLimit
     */
    public String getAbRFCVMLimit() {
        return abRFCVMLimit;
    }

    /**
     * @param abRFCVMLimit the abRFCVMLimit to set
     */
    public void setAbRFCVMLimit(String abRFCVMLimit) {
        this.abRFCVMLimit = abRFCVMLimit;
    }

    /**
     * @return the abTransProp
     */
    public String getAbTransProp() {
        return abTransProp;
    }

    /**
     * @param abTransProp the abTransProp to set
     */
    public void setAbTransProp(String abTransProp) {
        this.abTransProp = abTransProp;
    }

    /**
     * @return the bStatusCheck
     */
    public String getbStatusCheck() {
        return bStatusCheck;
    }

    /**
     * @param bStatusCheck the bStatusCheck to set
     */
    public void setbStatusCheck(String bStatusCheck) {
        this.bStatusCheck = bStatusCheck;
    }

    /**
     * @return the abAcquirerID
     */
    public String getAbAcquirerID() {
        return abAcquirerID;
    }

    /**
     * @param abAcquirerID the abAcquirerID to set
     */
    public void setAbAcquirerID(String abAcquirerID) {
        this.abAcquirerID = abAcquirerID;
    }

}
