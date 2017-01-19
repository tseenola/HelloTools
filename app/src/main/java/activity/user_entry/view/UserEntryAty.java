package activity.user_entry.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import activity.main_menu.view.MainMenuAty;
import activity.user_entry.model.UserEntryModel;
import activity.user_entry.presenter.UserEntryPrt;
import base.MyApplication;
import butterknife.Bind;
import butterknife.ButterKnife;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2016/12/31.
 * 描述：
 */

public class UserEntryAty extends BaseActivity implements IUserEntryAty{
    @Bind(R.id.et_UserId)
    EditText mEtUserId;
    @Bind(R.id.et_Pwd)
    EditText mEtPwd;
    @Bind(R.id.bt_Exit)
    Button mBtExit;
    @Bind(R.id.bt_SignIn)
    Button mBtSignIn;
    private UserEntryPrt mPresenter;

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_user_entry);
        ButterKnife.bind(this);
    }

    @Override
    public void initListener() {
        mBtExit.setOnClickListener(this);
        mBtSignIn.setOnClickListener(this);
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new UserEntryPrt(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.bt_Exit:
               MyApplication.getApp().killAppReleaseResource();
           break;
           case R.id.bt_SignIn:
               UserEntryModel user = new UserEntryModel();
               user.setName(mEtUserId.getText().toString().trim());
               user.setPwd(mEtPwd.getText().toString().trim());
               mPresenter.actionEntry(user);
           break;
       }
    }

    @Override
    public void onUserLoginSucc(UserEntryModel pUserEntryModel) {
        Toast.makeText(this,"欢迎"+pUserEntryModel.getName()+"登陆",Toast.LENGTH_LONG).show();
        MainMenuAty.launch(this);
    }

    @Override
    public void onUserLoginFail(String pFailMsg) {
        Toast.makeText(this,pFailMsg,Toast.LENGTH_LONG).show();
    }
}
