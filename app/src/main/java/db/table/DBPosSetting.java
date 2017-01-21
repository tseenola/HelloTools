package db.table;

import org.litepal.crud.DataSupport;

/**
 * POS参数设置表
 * Created by LiuY on 2016/2/15.
 */
public class DBPosSetting extends DataSupport {
    // 密钥索引
    private int keyIndex;
    // 参数名
    private String parmName;
    // 参数值
    private String parmValue;
    // 参数备注
    private String parmMemo;

    public DBPosSetting(int keyIndex, String parmName, String parmValue, String parmMemo) {
        super();
        this.keyIndex = keyIndex;
        this.parmName = parmName;
        this.parmValue = parmValue;
        this.parmMemo = parmMemo;
    }

    public DBPosSetting() {
        super();
    }

    public int getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(int keyIndex) {
        this.keyIndex = keyIndex;
    }

    public String getParmName() {
        return parmName;
    }

    public void setParmName(String parmName) {
        this.parmName = parmName;
    }

    public String getParmValue() {
        return parmValue;
    }

    public void setParmValue(String parmValue) {
        this.parmValue = parmValue;
    }

    public String getParmMemo() {
        return parmMemo;
    }

    public void setParmMemo(String parmMemo) {
        this.parmMemo = parmMemo;
    }
}
