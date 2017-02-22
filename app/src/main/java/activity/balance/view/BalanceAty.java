package activity.balance.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import activity.balance.presenter.BalancePrt;
import butterknife.Bind;
import butterknife.ButterKnife;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lijun on 2017/2/5.
 * 描述：余额查询view层
 */

public class BalanceAty extends BaseActivity implements IBalanceAty {
    @Bind(R.id.tv_Amt)
    TextView mTvAmt;
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
        ButterKnife.bind(this);
    }

    @Override
    public void initListener() {
        //执行刷卡
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
        mTvAmt.setText(pAmt);
    }

    @Override
    public void onQueryBalanceFail(String pErrMsg) {
        mTvAmt.setText(pErrMsg);
    }

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext, BalanceAty.class));
    }

}
