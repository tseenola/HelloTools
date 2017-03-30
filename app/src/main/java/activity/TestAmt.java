package activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/3/30.
 * 描述：
 */

public class TestAmt extends BaseActivity {


    @Bind(R.id.et_Amt)
    EditText mEtAmt;
    @Bind(R.id.bt_1)
    Button mBt1;
    @Bind(R.id.bt_2)
    Button mBt2;
    @Bind(R.id.bt_3)
    Button mBt3;
    @Bind(R.id.bt_4)
    Button mBt4;
    @Bind(R.id.bt_5)
    Button mBt5;
    @Bind(R.id.bt_6)
    Button mBt6;
    @Bind(R.id.bt_7)
    Button mBt7;
    @Bind(R.id.bt_8)
    Button mBt8;
    @Bind(R.id.bt_9)
    Button mBt9;
    @Bind(R.id.bt_Dot)
    Button mBtDot;
    @Bind(R.id.bt_0)
    Button mBt0;
    @Bind(R.id.bt_Del)
    Button mBtDel;
    @Bind(R.id.bt_Confirm)
    Button mBtConfirm;
    private StringBuilder mAmt;
    private PopupWindow mPopWindow;


    @Override
    public void initData() {
        mAmt = new StringBuilder();
    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_get_amt2);
        ButterKnife.bind(this);
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

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext, TestAmt.class));
    }


    @OnClick({R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_4, R.id.bt_5, R.id.bt_6, R.id.bt_7, R.id.bt_8, R.id.bt_9, R.id.bt_Dot, R.id.bt_0, R.id.bt_Del, R.id.bt_Confirm})
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
                Toast.makeText(this, mAmt, Toast.LENGTH_SHORT).show();
                showPopwindow(view);
                break;
        }
        mEtAmt.setText(mAmt);
    }

    private void showPopwindow(View pParentView) {
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.aty_get_amt2, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

        PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);


        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        window.setBackgroundDrawable(dw);
        window.showAsDropDown(pParentView);

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

}
