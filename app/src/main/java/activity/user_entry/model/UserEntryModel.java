package activity.user_entry.model;

/**
 * Created by lenovo on 2017/1/3.
 * 描述：
 */

public class UserEntryModel {
    private String mPwd;//密码
    private String mName;//用户名

    public String getPwd() {
        return mPwd;
    }

    public void setPwd(String pPwd) {
        mPwd = pPwd;
    }

    public String getName() {
        return mName;
    }

    public void setName(String pName) {
        mName = pName;
    }
}
