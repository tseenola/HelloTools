package tools.com.hellolibrary.hello_log;

import android.util.Log;

import tools.com.hellolibrary.hello_enviroment.Constant;

/**
 * Created by lenovo on 2016/10/15.
 * 描述：
 */

public class SysLog {
    public static void i(String pMsg){
        if(Constant.Log.IS_LOG_ON){
            Log.i(Constant.Log.TAG,pMsg);
        }
    }
}
