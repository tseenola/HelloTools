package activity.balance.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import activity.balance.presenter.BalancePrt;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lijun on 2017/2/5.
 * 描述：
 */

public class BalanceAty extends BaseActivity implements IBalanceAty{
    private BalancePrt mPresenter;

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_balance);
    }

    @Override
    public void initListener() {
        //执行刷卡
        //DialogUtil.showProgressDialog(this,false,DialogUtil.STYLE_CIRCAL,"刷卡中",25);
        mPresenter.actionQueryBalance();
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new BalancePrt(this);
    }

    @Override
    public void onQueryBalanceSucc(String pAmt) {

    }

    @Override
    public void onQueryBalanceFail(String pErrMsg) {

    }

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext,BalanceAty.class));
    }

}
