package activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;
import view.AmountEditChangeListener;
import view.CustomSoftInputEditText;
import view.SoftInputPop;


/**
 * Created by lenovo on 2017/3/21.
 * 描述：
 */

public class GetAmt extends BaseActivity{
    private View mView;
    private SoftInputPop mSoftInputPanelPopup;
    private CustomSoftInputEditText mCustomSoftInputEditText;
    public static final int SHOW_POP = 0;
    public static final int FINISH_ACTIVITY = 1;
    protected Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case SHOW_POP:
                    mCustomSoftInputEditText.dispatchTouchEvent(MotionEvent.obtain(
                            SystemClock.uptimeMillis(),
                            SystemClock.uptimeMillis(),
                            MotionEvent.ACTION_DOWN, mCustomSoftInputEditText.getLeft() + 5, mCustomSoftInputEditText.getTop() + 5, 0));
                    break;
                case FINISH_ACTIVITY:
                    GetAmt.this.finish();
                    break;
            }

        }
    };
    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        mView = View.inflate(this,R.layout.aty_get_amt,null);
        setContentView(mView);
        // 初始化控件
        mCustomSoftInputEditText = (CustomSoftInputEditText) mView.findViewById(R.id.edit_text_amount);
        initSoftInputPanelPopup();
        mCustomSoftInputEditText.initEditText(mSoftInputPanelPopup);
        mCustomSoftInputEditText.addTextChangedListener(new AmountEditChangeListener(mCustomSoftInputEditText));
        showSoftInput(mCustomSoftInputEditText);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void releaseResource() {
        if (mSoftInputPanelPopup.isShow()) {
            mSoftInputPanelPopup.dismissPop();
        }

    }

    @Override
    public void initPresenter() {

    }

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext,GetAmt.class));
    }

    private void initSoftInputPanelPopup() {
        mSoftInputPanelPopup = new SoftInputPop(this, mView, 1,
                new SoftInputPop.onEnterKeyPressListener() {
                    @Override
                    public void onPress() {
                        OnKeyEnterPressed(mCustomSoftInputEditText.getText().toString().trim());
                    }

                    @Override
                    public boolean onBackspace() {
                        return false;
                    }

                    @Override
                    public boolean onDismiss() {
                        return false;
                    }
                });
    }

    private void OnKeyEnterPressed(String pTrim) {

    }

    /**
     * 进页面弹出输入框
     */
    public void showSoftInput(final EditText ed) {
        new Thread() {
            public void run() {
                synchronized(this)
                {
                    SystemClock.sleep(200);
                    mHandler.sendEmptyMessage(SHOW_POP);
                    SystemClock.sleep(5000);
                    mHandler.sendEmptyMessage(FINISH_ACTIVITY);
                }
            }
        }.start();
    }
}
