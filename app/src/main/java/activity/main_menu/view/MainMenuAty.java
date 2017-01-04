package activity.main_menu.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import activity.sign_in.view.SignInAty;
import butterknife.Bind;
import butterknife.ButterKnife;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/1/3.
 * 描述：
 */

public class MainMenuAty extends BaseActivity{
    @Bind(R.id.bt_MainKeyDown)
    Button mBtMainKeyDown;
    @Bind(R.id.bt_IcParaDown)
    Button mBtIcParaDown;
    @Bind(R.id.bt_SignIn)
    Button mBtSignIn;
    @Bind(R.id.bt_Sale)
    Button mBtSale;
    @Bind(R.id.bt_SaleVoid)
    Button mBtSaleVoid;
    @Bind(R.id.bt_SaleRefund)
    Button mBtSaleRefund;
    @Bind(R.id.bt_Settle)
    Button mBtSettle;
    @Bind(R.id.bt_SignOut)
    Button mBtSignOut;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_MainKeyDown:
            break;
            case R.id.bt_IcParaDown:
            break;
            case R.id.bt_SignIn:
                SignInAty.launch(this);
            break;
            case R.id.bt_Sale:
            break;
            case R.id.bt_SaleVoid:
            break;
            case R.id.bt_SaleRefund:
            break;
            case R.id.bt_Settle:
            break;
            case R.id.bt_SignOut:
            break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_main_menu);
        ButterKnife.bind(this);
    }

    @Override
    public void initListener() {
        mBtSignIn.setOnClickListener(this);
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {

    }


    public static void launch(Context pContext) {
        Intent lIntent = new Intent(pContext, MainMenuAty.class);
        pContext.startActivity(lIntent);
    }

}
