package tools.com.hellolibrary.hello_spref;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by jun on 2016/5/19.
 * 描述：对SharedPre的进一步封装
 * 1.作用：Sp工具
 * 2.使用：如果要使用这个工具类，必须在application的入口中调用这个方法,传入第一个参数即可。
 * 在Application中进行初始化SPUtils.initSp(this);//初始化我的SharedPre.....工具
 * 3.依赖：无依赖


 */
public class SPUtils {
    private static final String SP_FILE_NAME = "SystemConfig";
    private static SharedPreferences mSp;
    private static SharedPreferences.Editor mEditor;

    /*
    * @des:如果要使用这个工具类，必须在application的入口中调用这个方法,传入第一个参数即可。
    */
    public static boolean initSp(Application ctx, String... SPConfig) {
        if (mEditor == null) {//如果sp没有初始化，进行初始化
            mSp = ctx.getSharedPreferences(
                    SPConfig.length >= 1 ? SPConfig[0] : ctx.getPackageName(),//如果SP长度大于1，否则sp文件名称默认为包名
                    SPConfig.length >= 2 ? Integer.valueOf(SPConfig[1]) : 0);//如果sp长度大于2，否则sp文件的权限为私有
            mEditor = mSp.edit();
            return true;
        }
        return false;
    }

    public static void putString(String key, String value) {
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
            mEditor.putString(key, value);
            mEditor.apply();
        }
    }

    public static String getString(String key) {
        if (!TextUtils.isEmpty(key)) {
            return mSp.getString(key, "");
        }
        return "";
    }

    public static void putBoolean(String key,boolean value){
        if (!TextUtils.isEmpty(key)) {
            mEditor.putBoolean(key, value);
            mEditor.apply();
        }
    }

    public static boolean getBoolean(String key){
        return !TextUtils.isEmpty(key) && mSp.getBoolean(key,false);
    }
    /*====================================================================================================================================*/
    public static void putString (Context ctx, String key, String value, String SPName, int author){
        SharedPreferences sp = ctx.getSharedPreferences(SPName, author);
        sp.edit().putString(key,value).apply();
    }

    public static String getString(Context ctx, String key, String defValue, String SPName, int author){
        SharedPreferences sp = ctx.getSharedPreferences(SPName, author);
        return sp.getString(key,defValue);
    }
}
