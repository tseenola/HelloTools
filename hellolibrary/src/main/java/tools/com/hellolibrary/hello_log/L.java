package tools.com.hellolibrary.hello_log;

import android.util.Log;

/**
 * Created by lenovo on 2016/10/15.
 * 描述：
 */

public class L {
    public static final boolean IS_LOG_ON = true;
    public static final String TAG = "happy";
    public static void e(String pMsg) {
        if (IS_LOG_ON) {
            Log.i(TAG, pMsg);
        }
    }
}
