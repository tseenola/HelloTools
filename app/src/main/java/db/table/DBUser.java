package db.table;

import org.litepal.crud.DataSupport;

public class DBUser extends DataSupport {
    private String userId;
    private String passwd;
    private String level;

    public DBUser(String userId, String passwd, String level) {
        super();
        this.userId = userId;
        this.passwd = passwd;
        this.level = level;
    }

    public DBUser() {
        super();
    }

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
