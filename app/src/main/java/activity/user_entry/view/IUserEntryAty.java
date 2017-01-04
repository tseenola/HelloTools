package activity.user_entry.view;

import activity.user_entry.model.UserEntryModel;

/**
 * Created by lenovo on 2017/1/3.
 * 描述：
 */

public interface IUserEntryAty{
    void onUserLoginSucc(UserEntryModel pUserEntryModel);
    void onUserLoginFail(String pFailMsg);
}
