package activity.main_menu.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import activity.GetAmt;
import activity.balance.view.BalanceQueryAty;
import activity.init_para.view.InitParamAty;
import activity.key_download.view.KeyDownLoadAty;
import activity.sale2.Sale2;
import activity.setting.SettingAty;
import activity.sign_in.view.SignInAty;
import butterknife.Bind;
import butterknife.ButterKnife;
import db.bill.DBPosSettingBill;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/1/3.
 * 描述：
 */

public class MainMenuAty extends BaseActivity {
    @Bind(R.id.bt_MainKeyDown)
    Button mBtMainKeyDown;
    @Bind(R.id.bt_InitParaDown)
    Button mBtInitParaDown;
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
    @Bind(R.id.bt_QueryBalance)
    Button mBtQueryBalance;
    @Bind(R.id.et_TranceN)
    EditText mEtTranceN;
    @Bind(R.id.bt_GetTranceN)
    Button mBtGetTranceN;
    @Bind(R.id.bt_SetTranceN)
    Button mBtSetTranceN;
    @Bind(R.id.bt_GetAmt)
    Button mBtGetAmt;
    @Bind(R.id.bt_Test)
    Button mBtTest;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_MainKeyDown:
                KeyDownLoadAty.launch(this);
                break;
            case R.id.bt_InitParaDown:
                InitParamAty.launch(this);
                break;
            case R.id.bt_SignIn:
                SignInAty.launch(this);
                //SignInAty2.launch(this);
                break;
            case R.id.bt_QueryBalance:
                //BalanceAty.launch(this);
                BalanceQueryAty.launch(this);
                break;
            case R.id.bt_Sale:
                //SaleAty.launch(this);
                Sale2.launch(this);
                break;
            case R.id.bt_SaleVoid:
                //Test.launch(this);
                break;
            case R.id.bt_SaleRefund:
                break;
            case R.id.bt_Settle:
                break;
            case R.id.bt_SignOut:
                break;
            case R.id.bt_GetAmt:
                GetAmt.launch(this);
                break;
            case R.id.bt_GetTranceN://获取流水
                mEtTranceN.setText(DBPosSettingBill.getTraceNo());
                break;
            case R.id.bt_SetTranceN://设置流水
                DBPosSettingBill.setTraceNo(mEtTranceN.getText().toString());
                break;
            case R.id.bt_Test:
                //TestAmt.launch(this);

                //new GetAmtPop().showPopwindow(v,MainMenuAty.this,0xFF8A2BE2);
                //Test.launch(this);
                SettingAty.launch(this);
                break;
            default:
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
        mEtTranceN.setText(DBPosSettingBill.getTraceNo());
    }

    @Override
    public void initListener() {
        mBtMainKeyDown.setOnClickListener(this);
        mBtInitParaDown.setOnClickListener(this);
        mBtSignIn.setOnClickListener(this);
        mBtQueryBalance.setOnClickListener(this);
        mBtGetTranceN.setOnClickListener(this);
        mBtSetTranceN.setOnClickListener(this);
        mBtSale.setOnClickListener(this);
        mBtSaleVoid.setOnClickListener(this);
        mBtGetAmt.setOnClickListener(this);
        mBtTest.setOnClickListener(this);
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
