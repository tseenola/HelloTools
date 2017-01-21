package db.table;

import org.litepal.crud.DataSupport;

/**
 * 交易参数管理
 */
public class DBDealManager extends DataSupport {
    // 密钥索引
    private int keyIndex;
    // 参数编号
    private int dealCode;
    // 参数描述
    private String dealDesc;
    // 参数值
    private String dealValue;
    // 参数备注
    private String dealMemo;

    public DBDealManager(int keyIndex, int dealCode, String dealDesc, String dealValue, String dealMemo) {
        super();
        this.keyIndex = keyIndex;
        this.dealCode = dealCode;
        this.dealDesc = dealDesc;
        this.dealValue = dealValue;
        this.dealMemo = dealMemo;
    }

    public DBDealManager() {
        super();
    }

    public int getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(int keyIndex) {
        this.keyIndex = keyIndex;
    }

    public int getDealCode() {
        return dealCode;
    }

    public void setDealCode(int dealCode) {
        this.dealCode = dealCode;
    }

    public String getDealDesc() {
        return dealDesc;
    }

    public void setDealDesc(String dealDesc) {
        this.dealDesc = dealDesc;
    }

    public String getDealValue() {
        return dealValue;
    }

    public void setDealValue(String dealValue) {
        this.dealValue = dealValue;
    }

    public String getDealMemo() {
        return dealMemo;
    }

    public void setDealMemo(String dealMemo) {
        this.dealMemo = dealMemo;
    }
}
