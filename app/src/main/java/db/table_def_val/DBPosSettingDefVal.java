package db.table_def_val;

import java.util.List;

/**
 * Created by lijun on 2017/2/6.
 * 描述：这个类用于对表(DBPosSetting)进行初始化
 * 初始化的时候需要有初始化值，这个初始值是从
 * assets文件夹(DBPosSettingDefVal)中读取Json。
 */

public class DBPosSettingDefVal {

    /**
     * keyIndex : 1
     * parmName : iMKIndex
     * parmValue : 1
     * parmMemo : 主密钥索引
     */

    private List<DBPosSettingDefValListBean> DBPosSettingDefValList;

    public List<DBPosSettingDefValListBean> getDBPosSettingDefValList() {
        return DBPosSettingDefValList;
    }

    public void setDBPosSettingDefValList(List<DBPosSettingDefValListBean> DBPosSettingDefValList) {
        this.DBPosSettingDefValList = DBPosSettingDefValList;
    }

    public static class DBPosSettingDefValListBean {
        private int keyIndex;
        private String parmName;
        private String parmValue;
        private String parmMemo;

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
}
