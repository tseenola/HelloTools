package tools.com.hellolibrary.hello_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by jun lee on 2016/5/19. 描述：对progressBar得封装
 */
public class DialogUtil {

    public static final int STYLE_CIRCAL = 0;
    public static final int STYLE_HORIZONTAL = 1;
    private static ProgressDialog mDialog;
    private static Handler mHandler;

    /**
     * 在安全线程显示Dialog(线程安全的)
     *
     * @param ctx
     * @param canCancle 是否可以点击取消
     * @param style     样式
     * @param message   显示的消息 这里初始化ProgressBar不能使用单例，必须重新new一个ProgressBar,
     *                  因为每个ProgressBar都对应指定的一个Activity，如果使用单例，
     *                  ProgressBar中的context一直都是第一个Activity的context，会出现 （Unable to add
     *                  window ..........is your activity running）
     * @param textSize  字体大小（20-40）
     */
    public static void showProgressDialog(@NonNull final Activity ctx, final Boolean canCancle, final int style, final String message, final int textSize) {
        ctx.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mDialog = new ProgressDialog(ctx);
                mDialog.setCancelable(canCancle);
                mDialog.setProgressStyle(style);
                mDialog.setMessage(message);
                mDialog.show();
                View dialogView = mDialog.getWindow().getDecorView();
                setDialogTextSize(dialogView, textSize);
            }
        });
    }

    public static void setCancelable(boolean pCancelable) {
        if (mDialog != null) {
            mDialog.setCancelable(pCancelable);
        }
    }

    /**
     * 设置当前Progress进度
     *
     * @param pProgress
     */
    public static void setProgress(int pProgress) {
        if (mDialog != null) {
            mDialog.setProgress(pProgress);
        }
    }

    /**
     * 隐藏progressBar
     */
    public static void hideProgressDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    /**
     * 在安全线程显示一个可以自动隐藏的ProgressBar（线程安全的）
     *
     * @param aty
     * @param msg      消息
     * @param showTime 显示时间
     */
    public static void showAutoHideProgress(@NonNull Activity aty, String msg,
                                            final int showTime, int textSize) {
        if (mHandler == null) {
            mHandler = new Handler(aty.getMainLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    hideProgressDialog();
                }
            };
        }
        showProgressDialog(aty, false, STYLE_CIRCAL, msg, textSize);
        new Thread() {
            @Override
            public void run() {
                super.run();
                SystemClock.sleep(showTime);
                mHandler.sendEmptyMessage(0);
            }
        }.start();
    }

    /**
     * 设置dailog的字体大小,size(20-40);
     *
     * @param v
     * @param size
     */
    private static void setDialogTextSize(@Nullable View v, int size) {
        if (v == null || size <= 19 || size >= 41) {
            return;
        }
        if (v instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) v;
            int count = parent.getChildCount();
            for (int i = 0; i < count; i++) {
                View child = parent.getChildAt(i);
                setDialogTextSize(child, size);
            }
        } else if (v instanceof TextView) {
            ((TextView) v).setTextSize(size); // 是textview，设置字号
        }
    }

    /**
     * 显示土司的工具类,安全的工具类可以在任意线程里面显示（线程安全的）
     *
     * @param activity
     * @param text     显示的文本
     */
    public static void showSafeToast(@NonNull final Activity activity, final String text, final int showTime) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, text, showTime).show();
            }
        });
    }

    public static AlertDialog.Builder mBuilder;

    /**
     * 构建只有一个按钮的对话框（线程不安全）
     *
     * @param ctx
     * @param title
     * @param msg
     * @param positiveMsg
     * @param listener
     */

    private static void build1ChooseDialog(final Activity ctx, final String title, final String msg, final String positiveMsg, @NonNull final On1DialogChoseListener listener) {

        mBuilder = new AlertDialog.Builder(ctx);
        if (!TextUtils.isEmpty(title)) {
            mBuilder.setTitle(title);
        }
        if (!TextUtils.isEmpty(msg)) {
            mBuilder.setMessage(msg);
        }
        if (!TextUtils.isEmpty(positiveMsg)) {
            mBuilder.setPositiveButton(positiveMsg, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    listener.onPositiveChose();
                }
            });
        }
    }

    /**
     * 构建只有两个按钮的对话框（线程不安全）
     *
     * @param ctx
     * @param title
     * @param msg
     * @param positiveMsg
     * @param negativeMsg
     * @param listener
     */
    private static void build2ChooseDialog(final Activity ctx, final String title, final String msg, final String positiveMsg, final String negativeMsg, @NonNull final On2DialogChoseListener listener) {

        build1ChooseDialog(ctx, title, msg, positiveMsg, listener);
        if (!TextUtils.isEmpty(negativeMsg)) {
            mBuilder.setNegativeButton(negativeMsg, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    listener.onNegativeChose();
                }
            });
        }

    }

    /**
     * 显示只有一个按钮的对话框（线程非安全）；
     *
     * @param ctx
     * @param title
     * @param msg
     * @param positiveMsg
     * @param listener
     */
    public static void show1ChooseDialog(final Activity ctx, final String title, final String msg, final String positiveMsg, @NonNull final On1DialogChoseListener listener) {
        build1ChooseDialog(ctx, title, msg, positiveMsg, listener);
        mBuilder.show();
    }

    /**
     * 显示只有两个按钮的对话框（线程非安全）；
     *
     * @param ctx
     * @param title
     * @param msg
     * @param positiveMsg
     * @param negativeMsg
     * @param listener
     */
    public static void show2ChooseDialog(final Activity ctx, final String title, final String msg, final String positiveMsg, final String negativeMsg, @NonNull final On2DialogChoseListener listener) {
        build1ChooseDialog(ctx, title, msg, positiveMsg, listener);
        build2ChooseDialog(ctx, title, msg, positiveMsg, negativeMsg, listener);
        mBuilder.show();
    }


    /**
     * 显示只有三个按钮的对话框（线程非安全）；
     *
     * @param ctx
     * @param title
     * @param msg
     * @param positiveMsg
     * @param negativeMsg
     * @param neutralMsg
     * @param listener
     */
    public static void show3ChooseDialog(final Activity ctx, final String title, final String msg, final String positiveMsg, final String negativeMsg, final String neutralMsg, @NonNull final On3DialogChoseListener listener) {

        build1ChooseDialog(ctx, title, msg, positiveMsg, listener);
        build2ChooseDialog(ctx, title, msg, positiveMsg, negativeMsg, listener);
        if (!TextUtils.isEmpty(neutralMsg)) {
            mBuilder.setNeutralButton(neutralMsg, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    listener.onNeutralChose();
                }
            });
        }
        mBuilder.show();
    }


    /**
     * 显示一个带单选框的对话框（非现场安全）
     *
     * @param ctx
     * @param title
     * @param items
     * @return
     */
    public static void showSingleChooseDialog(final Activity ctx, String title, final String[] items, String positiveMsg, @NonNull final OnSingleDailogChooice chooice) {

        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setTitle(title);
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chooice.onChooice(dialog, which);
            }
        });
        builder.show();
    }


    public static void showHave1EditDailog(final Activity ctx, final String title, final String msg, final String positiveMsg, String hint, boolean singleLine, int maxLength, @NonNull final On1EditDailogPositiveListner listener) {

        final EditText et = new EditText(ctx);
        build1EditDialog(ctx, title, msg, positiveMsg, et, listener);
        et.setGravity(Gravity.CENTER);
        et.setHint(hint);
        et.setSingleLine(singleLine);
        et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
        mBuilder.setView(et);
        mBuilder.show();
    }

    private static void build1EditDialog(final Activity ctx, final String title, final String msg,
                                         final String positiveMsg,
                                         @NonNull final EditText et,
                                         @NonNull final On1EditDailogPositiveListner listener) {

        mBuilder = new AlertDialog.Builder(ctx);
        if (!TextUtils.isEmpty(title)) {
            mBuilder.setTitle(title);
        }
        if (!TextUtils.isEmpty(msg)) {
            mBuilder.setMessage(msg);
        }
        if (!TextUtils.isEmpty(positiveMsg)) {
            mBuilder.setPositiveButton(positiveMsg, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(@NonNull DialogInterface dialog, int which) {
                    try {
                        Field field = dialog
                                .getClass()
                                .getSuperclass()
                                .getDeclaredField("mShowing");
                        field.setAccessible(true);
                        field.set(dialog, false);
                        listener.onPositiveChose(dialog, et, et.getText().toString().trim());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 当显示1个按钮执行的回调
     */
    public interface On1DialogChoseListener {
        void onPositiveChose();
    }

    /**
     * 当显示两个按钮的对话框的回调
     */
    public interface On2DialogChoseListener extends On1DialogChoseListener {
        void onNegativeChose();
    }

    /**
     * 当显示三个按钮的对话框执行的回调
     */
    public interface On3DialogChoseListener extends On2DialogChoseListener {
        void onNeutralChose();
    }

    public interface On1EditDailogPositiveListner {
        void onPositiveChose(DialogInterface pDialog, EditText et, String etString);
    }

    /**
     * 当带有单选框的对话框某个条目被选中的时候回调
     */
    public interface OnSingleDailogChooice {
        void onChooice(DialogInterface dialog, int which);
    }

    /*public static void showOneButtonToast(Activity pContext, String msg, final OnToastClickListner pOnToastClickListner) {
        new SnackBar(pContext,
                msg,
                "YES", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pOnToastClickListner.onToastClick();
            }
        }).show();

    }

    public interface OnToastClickListner{
        void onToastClick();
    }

    public static void showSnackToast(Activity pContext, String msg) {
        new SnackBar(pContext,msg).show();
    }

    public static void showHelloSnackBar(Activity pContext, String msg, final OnToastClickListner pOnToastClickListner){
        new HelloSnackBar(pContext,
                msg,
                "YES", new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pOnToastClickListner.onToastClick();
            }
        }).show();
    }*/
}



