package activity.user_entry.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import application.MyApplication;
import butterknife.Bind;
import butterknife.ButterKnife;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2016/12/31.
 * 描述：
 */

public class UserEntryAty extends BaseActivity {
    @Bind(R.id.et_UserId)
    EditText mEtUserId;
    @Bind(R.id.et_Pwd)
    EditText mEtPwd;
    @Bind(R.id.bt_Exit)
    Button mBtExit;
    @Bind(R.id.bt_SignIn)
    Button mBtSignIn;

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
        mBtExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication.getApp().killAppReleaseResource();
            }
        });

        mBtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {

    }
}
