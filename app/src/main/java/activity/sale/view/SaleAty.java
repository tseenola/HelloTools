package activity.sale.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.buildpackage.model.Body_STD;
import com.urovo.poscommon.models.MsgType;

import activity.sale.presenter.SalePrt;
import base.BaseSwipeCardAty;
import butterknife.Bind;
import butterknife.ButterKnife;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/2/24.
 * 描述：
 */

public class SaleAty extends BaseSwipeCardAty{
    public static final int READ_CARD = 1;
    @Bind(R.id.bt_Sale)
    Button mBtSale;
    @Bind(R.id.et_Amt)
    EditText mEtAmt;
    private SalePrt mPresenter;

    @Override
    public void onClick(View v) {
        readCard(mPresenter, MsgType.Sale,"0.01");
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
    public void initPresenter() {
        mPresenter = new SalePrt(this);
    }

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext, SaleAty.class));
    }

    @Override
    public void onDealSucc(String pMsg,Body_STD pBody_std) {
        mEtAmt.setText("消费结果："+pMsg);
    }

    @Override
    public void onDealFail(String pErrorMsg,Body_STD pBody_std) {
        mEtAmt.setText("消费结果："+pErrorMsg);
    }

}
