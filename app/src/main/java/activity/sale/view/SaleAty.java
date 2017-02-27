package activity.sale.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import activity.read_card.view.ReadCardAty;
import activity.sale.presenter.SalePrt;
import butterknife.Bind;
import butterknife.ButterKnife;
import models.CardInfoModel;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellolibrary.hello_dialog.DialogUtil;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/2/24.
 * 描述：
 */

public class SaleAty extends BaseActivity implements ISaleAty {
    public static final int READ_CARD = 1;
    @Bind(R.id.bt_Sale)
    Button mBtSale;
    @Bind(R.id.et_Amt)
    EditText mEtAmt;
    private SalePrt mPresenter;

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(this, ReadCardAty.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, READ_CARD);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_sale);
        ButterKnife.bind(this);
    }


    @Override
    public void initListener() {
        mBtSale.setOnClickListener(this);
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new SalePrt(this);
    }

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext, SaleAty.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case READ_CARD:
                if (resultCode == RESULT_OK) {
                    Bundle lBundle = data.getBundleExtra(ReadCardAty.READ_CARD_RESULT);
                    CardInfoModel lCardInfoModel = (CardInfoModel) lBundle.getSerializable("a");
                    mEtAmt.setText(lCardInfoModel.toString());
                    Log.i("vbvb", "xixixixsucc:" + lCardInfoModel.toString());
                    DialogUtil.showProgressDialog(this,false,DialogUtil.STYLE_CIRCAL,"消费交易中",25);
                    mPresenter.actionSale(lCardInfoModel);
                } else {
                    String result = data.getStringExtra(ReadCardAty.READ_CARD_RESULT);
                    mEtAmt.setText(result);
                    Log.i("vbvb", "xixixixfale:" + result);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onSaleSucc(String pMsg) {
        DialogUtil.hideProgressDialog();
        mEtAmt.setText("消费结果："+pMsg);
    }

    @Override
    public void onSaleFail(String pErrorMsg) {
        DialogUtil.hideProgressDialog();
        mEtAmt.setText("消费结果："+pErrorMsg);
    }

}
