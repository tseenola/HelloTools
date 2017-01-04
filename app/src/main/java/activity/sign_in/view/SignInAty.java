package activity.sign_in.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/1/4.
 * 描述：
 */

public class SignInAty extends BaseActivity implements ISignInAty{
    @Override
    public void onSignInSucc(String pMsg) {

    }

    @Override
    public void onSignInFail(String pMsg) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_sign_in);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {

    }

    public static void launch(Context pContext){
        pContext.startActivity(new Intent(pContext,SignInAty.class));
    }
}
