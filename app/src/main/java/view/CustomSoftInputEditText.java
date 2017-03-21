package view;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;


public class CustomSoftInputEditText extends EditText {
    private boolean toShielded = false;

    public CustomSoftInputEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CustomSoftInputEditText(Context context) {
        super(context);
    }

    public CustomSoftInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void initEditText(final SoftInputPop pop) {
        this.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    int inType = CustomSoftInputEditText.this.getInputType();
                    CustomSoftInputEditText.this.setInputType(InputType.TYPE_NULL);
                    CustomSoftInputEditText.this.onTouchEvent(event);
                    CustomSoftInputEditText.this.setInputType(inType);
                    CustomSoftInputEditText.this.setSelection(CustomSoftInputEditText.this.getText().length());

                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        if (pop.isShow() && pop.isShowEditTextEqual(CustomSoftInputEditText.this)) {// 如果是本输入框弹出的键盘，则去掉键盘
                            if (toShielded) {
                                pop.dismissPop();
                            }
                        } else {
                            pop.showWindow(CustomSoftInputEditText.this);
                        }
                        return true;
                    } else {
                        return true;
                    }
                } catch (Exception ex) {
                    return true;
                }
            }
        });

        this.setOnFocusChangeListener(new OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    CustomSoftInputEditText.this.setSelection(CustomSoftInputEditText.this.getText().length());
                }
            }
        });
    }
}
