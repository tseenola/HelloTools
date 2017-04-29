package activity.get_amt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this, tools.com.hellolibrary.R.layout.pop_get_amt, null);
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
        if(mAmt.length()<=0&&(view.getId()== tools.com.hellolibrary.R.id.bt_Dot||view.getId()== tools.com.hellolibrary.R.id.bt_Del)){
            return;
        }
        int z= mAmt.length()-mAmt.indexOf(".");
        if(z>=3&&mAmt.indexOf(".")>=1&&view.getId()!= tools.com.hellolibrary.R.id.bt_Del){
            return;
        }
        if(mEtAmt.getText().toString().trim().startsWith("0")&&view.getId()== tools.com.hellolibrary.R.id.bt_0){
            return;
        }
        if (mEtAmt.getText().toString().endsWith(".")&&view.getId()== tools.com.hellolibrary.R.id.bt_Dot){
            return;
        }
        int i = view.getId();
        if (i == tools.com.hellolibrary.R.id.bt_1) {
            mAmt.append("1");

        } else if (i == tools.com.hellolibrary.R.id.bt_2) {
            mAmt.append("2");

        } else if (i == tools.com.hellolibrary.R.id.bt_3) {
            mAmt.append("3");

        } else if (i == tools.com.hellolibrary.R.id.bt_4) {
            mAmt.append("4");

        } else if (i == tools.com.hellolibrary.R.id.bt_5) {
            mAmt.append("5");

        } else if (i == tools.com.hellolibrary.R.id.bt_6) {
            mAmt.append("6");

        } else if (i == tools.com.hellolibrary.R.id.bt_7) {
            mAmt.append("7");

        } else if (i == tools.com.hellolibrary.R.id.bt_8) {
            mAmt.append("8");

        } else if (i == tools.com.hellolibrary.R.id.bt_9) {
            mAmt.append("9");

        } else if (i == tools.com.hellolibrary.R.id.bt_Dot) {
            mAmt.append(".");

        } else if (i == tools.com.hellolibrary.R.id.bt_0) {
            mAmt.append("0");

        } else if (i == tools.com.hellolibrary.R.id.bt_Del) {
            mAmt.deleteCharAt(mAmt.length() - 1);

        } else if (i == tools.com.hellolibrary.R.id.bt_Confirm) {
            Intent lIntent = new Intent();
            lIntent.putExtra("amt",mEtAmt.getText().toString().trim());
            setResult(0,lIntent);
            this.finish();
        }
        mEtAmt.setText(mAmt);
    }
}
