package activity.balance.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.urovo.poscommon.models.MsgType;

import activity.balance.presenter.BalanceQueryPrt;
import base.BaseSwipeCardAty;
import base.IBaseSwipeCardPrt;
import butterknife.Bind;
import butterknife.ButterKnife;
import pos2.model.Body_STD;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/2/28.
 * 描述：
 */

public class BalanceQueryAty extends BaseSwipeCardAty {
    @Bind(R.id.tv_Amt)
    TextView mTvAmt;
    @Bind(R.id.bt_QueryBalance)
    Button mBtQueryBalance;
    private IBaseSwipeCardPrt mPresenter;

    @Override
    public void onClick(View v) {
        readCard(mPresenter, MsgType.BalanceQuery,null);//执行读卡
    }

    /**
     * 余额查询成功
     * @param pMsg 成功信息
     * @param pBody_std
     */
    @Override
    public void onDealSucc(String pMsg,Body_STD pBody_std) {
        if(!TextUtils.equals("余额",pBody_std.getmF54().DES)){
            throw new IllegalStateException("获取余额时发生错误，当前域DES不是余额！请重新确认余额所在域！");
        }
        mTvAmt.setText(pBody_std.getmF54().getValue().split("-->")[1].substring(17,29));
    }

    /**
     * 余额查询失败
     * @param pErrorMsg 失败信息
     * @param pBody_std 接收到的报文对象
     */
    @Override
    public void onDealFail(String pErrorMsg,Body_STD pBody_std) {
        mTvAmt.setText(pErrorMsg);
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
        mBtQueryBalance.setOnClickListener(this);
    }

    @Override
    public void initPresenter() {
        mPresenter = new BalanceQueryPrt();
    }

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext, BalanceQueryAty.class));
    }

}
