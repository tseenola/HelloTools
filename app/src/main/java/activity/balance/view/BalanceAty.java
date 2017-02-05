package activity.balance.view;

import android.view.View;

import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lijun on 2017/2/5.
 * 描述：
 */

public class BalanceAty extends BaseActivity implements IBalanceAty{
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

    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onQueryBalanceSucc(String pAmt) {

    }

    @Override
    public void onQueryBalanceFail(String pErrMsg) {

    }
}
