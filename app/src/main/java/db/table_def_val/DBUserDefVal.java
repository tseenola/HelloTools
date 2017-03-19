package db.table_def_val;

import java.util.List;

/**
 * Created by lijun on 2017/2/6.
 * 描述：这个类用于对表(DBuser)进行初始化
 * 初始化时候需要有初始化值，这个初始值是从
 * assets文件夹(DBuserDefVal)中读取Json。
 */

public class DBUserDefVal {

    /**
     * userId : 99
     * passwd : 12345678
     * level : 1
     */

    private List<DBUserDefValListBean> DBUserDefValList;

    public List<DBUserDefValListBean> getDBUserDefValList() {
        return DBUserDefValList;
    }

    public void setDBUserDefValList(List<DBUserDefValListBean> DBUserDefValList) {
        this.DBUserDefValList = DBUserDefValList;
    }

    public static class DBUserDefValListBean {
        private String userId;
        private String passwd;
        private String level;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }
}
