package tools.com.hellolibrary.hello_spref;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import tools.com.hellolibrary.hello_log.L;

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
    private SPUtils(){}
    /**
     * 如果要使用这个工具类，必须在application的入口中调用这个方法,传入第一个参数即可。
     * @param ctx
     * @param SPConfig
     * @return
     */
    public static boolean initSp(@NonNull Application ctx, String... SPConfig) {
        if (mEditor == null) {//如果sp没有初始化，进行初始化
            mSp = ctx.getSharedPreferences(
                    SPConfig.length >= 1 ? SPConfig[0] : ctx.getPackageName(),//如果SP长度大于1，否则sp文件名称默认为包名
                    SPConfig.length >= 2 ? Integer.valueOf(SPConfig[1]) : 0);//如果sp长度大于2，否则sp文件的权限为私有
            mEditor = mSp.edit();
            return true;
        }
        L.e("SPUtils initSp null");
        return false;
    }

    /**
     * 向SP中写入数据
     * @param key
     * @param value
     * @return 是否写入成功
     */
    public static boolean putString(@NonNull String key, @NonNull String value) {
        if (!TextUtils.isEmpty(key)) {
            mEditor.putString(key, value);
            mEditor.apply();
            return true;
        }
        L.e("SPUtils putString null");
        return false;
    }

    /**
     * 从SP获得数据
     *
     * @param key
     * @return
     */
    @Nullable
    public static String getString(@NonNull String key, @NonNull String defValue) {
        if (!TextUtils.isEmpty(key)) {
            return mSp.getString(key, defValue);
        }
        L.e("SPUtils getString null");
        return defValue;
    }

    /**
     *
     * @param key
     * @param value
     * @return 是否写入成功
     */
    public static boolean putBoolean(@NonNull String key,boolean value) {
        if (!TextUtils.isEmpty(key)) {
            mEditor.putBoolean(key, value);
            mEditor.apply();
            return true;
        }
        L.e("SPUtils putBoolean null");
        return false;
    }

    /**
     *
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBoolean(@NonNull String key,boolean defValue) {
        if(!TextUtils.isEmpty(key)){
            return mSp.getBoolean(key, defValue);
        }
        L.e("SPUtils getBoolean null");
        return defValue;
    }

    /**
     *
     * @param key
     * @param value
     * @return 是否写入成功
     */
    public static boolean putInt(@NonNull String key,int value) {
        if (!TextUtils.isEmpty(key)) {
            mEditor.putInt(key, value);
            mEditor.apply();
            return true;
        }
        L.e("SPUtils putInt null");
        return false;
    }

    /**
     *
     * @param key
     * @param defValue
     * @return
     */
    public static int getInt(@NonNull String key,int defValue) {
        if (!TextUtils.isEmpty(key)) {
            return mSp.getInt(key, defValue);
        }
        L.e("SPUtils getInt null");
        return defValue;
    }


    /**
     *
     * @param key
     * @param value
     * @return 是否写入成功
     */
    public static boolean putFloat(@NonNull String key,float value) {
        if (!TextUtils.isEmpty(key)) {
            mEditor.putFloat(key, value);
            mEditor.apply();
            return true;
        }
        L.e("SPUtils putFloat null");
        return false;
    }


    /**
     *
     * @param key
     * @param defValue
     * @return
     */
    public static float getFloat(@NonNull String key,float defValue) {
        if (!TextUtils.isEmpty(key)) {
            return mSp.getFloat(key, defValue);
        }
        L.e("SPUtils getFloat null");
        return defValue;
    }


//====================================================
    /**
     *
     * @param ctx
     * @param key
     * @param value
     * @param SPName
     * @param author
     * @return 是否写入成功
     */
    public static boolean putString(@NonNull Context ctx, @NonNull String key, @NonNull String value, @NonNull String SPName,int author) {
        if (!TextUtils.isEmpty(key) &&!TextUtils.isEmpty(SPName)) {
            SharedPreferences sp = ctx.getSharedPreferences(SPName, author);
            sp.edit().putString(key, value).apply();
            return true;
        }
        L.e("SPUtils putString null");
        return false;
    }

    /**
     * 从SP中获取String值
     * @param ctx
     * @param key
     * @param defValue
     * @param SPName
     * @param author
     * @return String值
     */
    @Nullable
    public static String getString(@NonNull Context ctx, @NonNull String key, @NonNull String defValue, @NonNull String SPName,int author) {
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(SPName)) {
            SharedPreferences sp = ctx.getSharedPreferences(SPName, author);
            return sp.getString(key, defValue);
        }
        L.e("SPUtils getString null");
        return defValue;
    }
}
