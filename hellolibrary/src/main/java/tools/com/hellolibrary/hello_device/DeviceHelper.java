package tools.com.hellolibrary.hello_device;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

/**
 * 设备助手
 * Created by LiuYi on 2016/7/5.
 */
public class DeviceHelper{

    /**
     * 判断网络是否链接。
     *
     * @return
     */
    public static boolean isNetworkConnected(Context pContext) {
        ConnectivityManager cm = (ConnectivityManager) pContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnected();
    }

    /**
     * 设置wifi是否可用
     * @param wifiManager
     * @param isEnable
     */
    public static void setWIFIEnable(WifiManager wifiManager, boolean isEnable) {
        wifiManager.setWifiEnabled(isEnable);
    }

    /**
     * wifi是否连接
     *
     * @return
     */
    public static boolean isWifiConnected(Context pContext) {
        ConnectivityManager cm = (ConnectivityManager) pContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return ni != null && ni.isConnected();
    }

    /**
     * 设置
     * @param connectivityManager
     * @param isEnable
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void setGPRSEnable(ConnectivityManager connectivityManager, boolean isEnable) {
        Class cmClass = connectivityManager.getClass();
        Class[] argClasses = new Class[1];
        argClasses[0] = boolean.class;

        try {
            Method method = cmClass.getMethod("setMobileDataEnabled", argClasses);
            method.invoke(connectivityManager, isEnable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 检测GPRS是否打开
     * @param connectivityManager
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean isGPRSOpened(ConnectivityManager connectivityManager) {
        Class cmClass = connectivityManager.getClass();
        Class[] argClasses = null;
        Object[] argObject = null;

        Boolean isOpen = false;
        try {
            Method method = cmClass.getMethod("getMobileDataEnabled", argClasses);
            isOpen = (Boolean) method.invoke(connectivityManager, argObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isOpen;
    }

    /**
     * 判断app是否安装
     * @param context
     * @param packageName
     * @return
     */
    public static boolean isAppInstall(Context context, String packageName) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        if (packageInfo == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 获得版本号，版本名称
     * @param context
     * @param pPackageName
     * @return
     */
    public static String[] getPosAppInfo(Context context,String pPackageName) {
        int versionCode = 0;
        String versionName = "";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(pPackageName, 0);
            versionCode = pi.versionCode;
            versionName = pi.versionName;
            return new String[]{versionCode + "", versionName};
        } catch (Exception e) {
           e.printStackTrace();
            return new String[]{"0", ""};
        }
    }

    /**
     * 安装应用程序
     *
     * @param context
     * @param apkFile
     */
    public static void installApp(Context context, File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }


    /**
     * 复制Asset的pos文件到终端
     */
    public static void copyPosAppToSdAndInstall(Context pContext,String apkName) {
        try{
            if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                Toast.makeText(pContext, "SD卡未挂载，无法安装！", Toast.LENGTH_SHORT).show();
                return;
            }

            File file = new File(Environment.getExternalStorageDirectory(),apkName);
            if(file.exists()&&file.length()>0){
                file.delete();
            }
            InputStream in = pContext.getAssets().open(apkName);
            OutputStream out = new FileOutputStream(file);

            int len=0;
            byte[] buf = new byte[1024];
            while((len=in.read(buf))>0){
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            //进行安装
            File posFile = new File(Environment.getExternalStorageDirectory()+"/"+apkName);
            if(posFile.exists()){
                DeviceHelper.installApp(pContext,posFile);
            }else {
                Toast.makeText(pContext,"安装文件不存在",Toast.LENGTH_LONG).show();
            }

        }catch (Exception e){
            Toast.makeText(pContext,"安装程序失败！",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
