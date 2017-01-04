package activity.user_entry.presenter;

import android.text.TextUtils;

import activity.user_entry.model.UserEntryModel;
import activity.user_entry.view.IUserEntryAty;

/**
 * Created by lenovo on 2017/1/3.
 * 描述：
 */

public class UserEntryPrt implements IUserEntryPrt {

    private final IUserEntryAty mView;

    public UserEntryPrt(IUserEntryAty pView) {
        mView = pView;
    }

    @Override
    public void actionEntry(UserEntryModel pUserEntryModel) {
        if(TextUtils.equals(pUserEntryModel.getName(),"01")&&TextUtils.equals(pUserEntryModel.getPwd(),"0000")){
            mView.onUserLoginSucc(pUserEntryModel);
        }else{
            mView.onUserLoginFail("密码或者账户错误");
        }
    }
}
