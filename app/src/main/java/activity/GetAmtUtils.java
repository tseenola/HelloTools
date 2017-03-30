package activity;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TableLayout;

import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/3/31.
 * 描述：
 */

public class GetAmtUtils implements View.OnClickListener {
    EditText mEtAmt;
    Button   mBt1;
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
    private PopupWindow mWindow;

    public void showPopwindow(View pParentView, Context pContext) {
        mAmt = new StringBuilder();
        // 利用layoutInflater获得View
        View view = View.inflate(pContext, R.layout.aty_get_amt2, null);
        TableLayout lTableLayout  = (TableLayout) view.findViewById(R.id.tl_Container);
        mEtAmt = (EditText)view.findViewById(R.id.et_Amt);
        mBt0 = (Button)view.findViewById(R.id.bt_0);
        mBt1 = (Button)view.findViewById(R.id.bt_1);
        mBt2 = (Button)view.findViewById(R.id.bt_2);
        mBt3 = (Button)view.findViewById(R.id.bt_3);
        mBt4 = (Button)view.findViewById(R.id.bt_4);
        mBt5 = (Button)view.findViewById(R.id.bt_5);
        mBt6 = (Button)view.findViewById(R.id.bt_6);
        mBt7 = (Button)view.findViewById(R.id.bt_7);
        mBt8 = (Button)view.findViewById(R.id.bt_8);
        mBt9 = (Button)view.findViewById(R.id.bt_9);
        mBtDot = (Button)view.findViewById(R.id.bt_Dot);
        mBtDel = (Button)view.findViewById(R.id.bt_Del);
        mBtConfirm = (Button)view.findViewById(R.id.bt_Confirm);
        setConlick();
        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

        mWindow = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        mWindow.setFocusable(true);


        // 设置背景

        mWindow.showAtLocation(pParentView, Gravity.TOP, 0, 0);

        // 设置popWindow的显示和消失动画
        //window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 在底部显示
        //window.showAtLocation(TestAmt.this.findViewById(R.id.start),
        //      Gravity.BOTTOM, 0, 0);

        // 这里检验popWindow里的button是否可以点击
        /*Button first = (Button) view.findViewById(R.id.first);
        first.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                System.out.println("第一个按钮被点击了");
            }
        });*/

        //popWindow消失监听方法
        /*window.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                System.out.println("popWindow消失");
            }
        });*/

    }

    private void setConlick() {
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
        if(mAmt.length()<=0&&(view.getId()==R.id.bt_Dot||view.getId()==R.id.bt_Del)){
            return;
        }
        int z= mAmt.length()-mAmt.indexOf(".");
        if(z>=3&&mAmt.indexOf(".")>=1&&view.getId()!=R.id.bt_Del){
            return;
        }
        if(mEtAmt.getText().toString().trim().startsWith("0")&&view.getId()==R.id.bt_0){
            return;
        }
        if (mEtAmt.getText().toString().endsWith(".")&&view.getId()==R.id.bt_Dot){
            return;
        }
        switch (view.getId()) {
            case R.id.bt_1:
                mAmt.append("1");
                break;
            case R.id.bt_2:
                mAmt.append("2");
                break;
            case R.id.bt_3:
                mAmt.append("3");
                break;
            case R.id.bt_4:
                mAmt.append("4");
                break;
            case R.id.bt_5:
                mAmt.append("5");
                break;
            case R.id.bt_6:
                mAmt.append("6");
                break;
            case R.id.bt_7:
                mAmt.append("7");
                break;
            case R.id.bt_8:
                mAmt.append("8");
                break;
            case R.id.bt_9:
                mAmt.append("9");
                break;
            case R.id.bt_Dot:
                mAmt.append(".");
                break;
            case R.id.bt_0:
                mAmt.append("0");
                break;
            case R.id.bt_Del:
                mAmt.deleteCharAt(mAmt.length()-1);
                break;
            case R.id.bt_Confirm:
                mWindow.dismiss();
                break;
        }
        mEtAmt.setText(mAmt);
    }
}
