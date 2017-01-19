package activity.init_para.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import activity.init_para.presenter.InitParamPrt;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/1/19.
 * 描述：初始化pos参数
 */

public class InitParamAty extends BaseActivity implements IInitParamAty {

    private InitParamPrt mPresenter;

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_init_para_down);
    }

    @Override
    public void initListener() {
        mPresenter.actionInitParaDown();
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new InitParamPrt(this);
    }

    @Override
    public void onParaDownSucc(String pMsg) {

    }

    @Override
    public void onParaDownInFail(String pMsg) {

    }

    public static void launch(Context pContext){
        pContext.startActivity(new Intent(pContext,InitParamAty.class));
    }
}
