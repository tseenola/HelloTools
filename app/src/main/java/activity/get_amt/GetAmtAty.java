package activity.get_amt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import java.util.regex.Pattern;

import base.eventbus_bean.GetAmtFinishMessage;

/**
 * Created by lenovo on 2017/4/24.
 * 描述：
 */

public class GetAmtAty extends Activity implements View.OnClickListener {
    EditText mEtAmt;
    Button mBt1;
    Button   mBt2;
    Button   mBt3;
    Button   mBt4;
    Button   mBt5;
    Button   mBt6;
    Button   mBt7;
    Button   mBt8;
    Button   mBt9;
    Button   mBtDot;
    Button   mBt0;
    Button   mBtDel;
    Button   mBtConfirm;
    private StringBuilder mAmt;
    private StringBuilder mAmtFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAmt = new StringBuilder("");
        mAmtFinal = new StringBuilder("");
        View view = View.inflate(this, tools.com.hellolibrary.R.layout.pop_get_amt, null);
        setContentView(view);
        mEtAmt = (EditText)view.findViewById(tools.com.hellolibrary.R.id.et_Amt);
        mBt0 = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_0);
        mBt1 = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_1);
        mBt2 = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_2);
        mBt3 = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_3);
        mBt4 = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_4);
        mBt5 = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_5);
        mBt6 = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_6);
        mBt7 = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_7);
        mBt8 = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_8);
        mBt9 = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_9);
        mBtDot = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_Dot);
        mBtDel = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_Del);
        mBtConfirm = (Button)view.findViewById(tools.com.hellolibrary.R.id.bt_Confirm);
        mEtAmt.setOnClickListener(this);
        mBt1.setOnClickListener(this);
        mBt2.setOnClickListener(this);
        mBt3.setOnClickListener(this);
        mBt4.setOnClickListener(this);
        mBt5.setOnClickListener(this);
        mBt6.setOnClickListener(this);
        mBt7.setOnClickListener(this);
        mBt8.setOnClickListener(this);
        mBt9.setOnClickListener(this);
        mBtDot.setOnClickListener(this);
        mBt0.setOnClickListener(this);
        mBtDel.setOnClickListener(this);
        mBtConfirm.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == tools.com.hellolibrary.R.id.bt_1) {
            mAmt.append("1");
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_2) {
            mAmt.append("2");
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_3) {
            mAmt.append("3");
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_4) {
            mAmt.append("4");
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_5) {
            mAmt.append("5");
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_6) {
            mAmt.append("6");
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_7) {
            mAmt.append("7");
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_8) {
            mAmt.append("8");
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_9) {
            mAmt.append("9");
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_Dot) {
            mAmt.append(".");
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_0) {
            mAmt.append("0");
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_Del) {
            mAmt.deleteCharAt(mAmt.length() - 1);
            checkAmt();
        } else if (i == tools.com.hellolibrary.R.id.bt_Confirm) {
            GetAmtFinishMessage lMessageEvent = new GetAmtFinishMessage();
            lMessageEvent.setAmt(String.valueOf(mAmt));
            lMessageEvent.setGetAmtSucc(true);
            EventBus.getDefault().post(lMessageEvent);
            this.finish();
        }

    }

    public void checkAmt(){
        if (Pattern.matches("[0-9]+\\.?[0-9]{0,2}",mAmt)){
            mAmtFinal = mAmt;
        }else if (mAmt.length()>1){
            mAmtFinal = mAmt.deleteCharAt(mAmt.length()-1);
        }else {
            mAmtFinal = new StringBuilder("");
        }
        mEtAmt.setText(mAmtFinal);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext, GetAmtAty.class));
    }


}
