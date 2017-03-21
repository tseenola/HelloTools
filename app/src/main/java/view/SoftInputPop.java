package view;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import tools.com.hellotools.R;


public class SoftInputPop {
    private PopupWindow popupWindow;
    private EditText showDataEd;
    private Activity context;
    private View parentView;
    private int sizeType = 0;// 0为正常，1为大号
    private onEnterKeyPressListener listener;

    public SoftInputPop(Activity context, View parentView, onEnterKeyPressListener listener) {
        this.context = context;
        this.parentView = parentView;
        this.listener = listener;
        initSoftinpup(context);
    }

    public SoftInputPop(Activity context, View parentView, int sizeType, onEnterKeyPressListener listener) {
        this.context = context;
        this.parentView = parentView;
        this.sizeType = sizeType;
        this.listener = listener;
        initSoftinpup(context);
    }

    public void initSoftinpup(Activity context) {
        View view = LayoutInflater.from(context).inflate(R.layout.softinput_popu, null);
        GridView gridview = (GridView) view.findViewById(R.id.gridview);
        GridViewAdapter adapter = new GridViewAdapter(context);
        gridview.setAdapter(adapter);
        view.findViewById(R.id.key_back).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (listener != null && listener.onBackspace()) {
                            return;
                        }

                        if (showDataEd != null && showDataEd.length() > 0) {
                            showDataEd.setText(showDataEd.getText().subSequence(0, showDataEd.length() - 1));
                            showDataEd.setSelection(showDataEd.getText().length());
                        }
                    }
                });
        view.findViewById(R.id.key_enter).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onPress();
                        }
                    }
                });

        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);
        popupWindow.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                if (listener != null) {
                    listener.onDismiss();
                }
            }
        });
    }

    public void showWindow(EditText showDataEd) {
        setShowEditText(showDataEd);// set the EditText to be put data
        if (popupWindow == null) {
            initSoftinpup(context);
        } else if (popupWindow.isShowing()) {
            return;
        }
        if (context.getCurrentFocus() != null) {
            ((InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        popupWindow.showAtLocation(parentView, Gravity.BOTTOM, 0, 0);
    }

    public void setShowEditText(EditText showDataEd) {
        this.showDataEd = showDataEd;
    }

    public boolean isShow() {
        return popupWindow != null && popupWindow.isShowing();
    }

    public void dismissPop() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            popupWindow = null;
        }
    }

    /**
     * 判断弹出的键盘是不是该输入框弹出的
     */
    public boolean isShowEditTextEqual(EditText ed) {
        return ed != null && ed == showDataEd;
    }

    public interface onEnterKeyPressListener {
        /**
         * 自定义确认事件
         */
        void onPress();
        /**
         * @return true:自定义了取消事件，原事件不会继续执行。false：原事件继续执行
         */
        boolean onBackspace();

        /**
         * @return true:自定义了取消事件，原事件不会继续执行。false：原事件继续执行
         */
        boolean onDismiss();
    }

    private class GridViewAdapter extends BaseAdapter {
        Activity context;

        public GridViewAdapter(Activity context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 12;
        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup arg2) {
            final ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                if (sizeType == 0)
                    convertView = LayoutInflater.from(context).inflate(R.layout.softinput_gridview, null);
                else if (sizeType == 1)
                    convertView = LayoutInflater.from(context).inflate(R.layout.softinput_gridview_big, null);

                holder.content = (TextView) convertView.findViewById(R.id.content);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (position == 9) {
                convertView.setEnabled(false);
                convertView.setClickable(false);
            } else if (position == 10) {
                holder.content.setText("0");
            } else if (position == 11) {
                holder.content.setText("00");
            } else {
                holder.content.setText("" + (position + 1));
            }

            convertView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position == 9) {
                    } else if (position == 10) {
                        showDataEd.append("0");
                    } else if (position == 11) {
                        showDataEd.append("00");
                    } else {
                        showDataEd.append("" + (position + 1));
                    }
                }
            });
            return convertView;
        }

        @Override
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }

        class ViewHolder {
            TextView content;
        }
    }
}
