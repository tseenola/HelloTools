package tools.com.hellolibrary.hello_crash_handler;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 系统崩溃的时候需要处理下面的动作
 * 1.收集并且记录崩溃错误日志
 * 2.上传崩溃错误日志
 * 3.重启应用程序
 * 4.崩溃的时候给予用户适当的提示
 */
interface CrashListner {

    void onSystemCrash();


}

public class MyCrashHandlerUtil implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    @NonNull
    private static MyCrashHandlerUtil INSTANCE = new MyCrashHandlerUtil();
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private Context mContext;
    private CrashListner mCallback;
    @NonNull
    private Map<String, String> infos = new HashMap();
    @NonNull
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private Class mCls;

    private MyCrashHandlerUtil() {
    }

    @NonNull
    public static MyCrashHandlerUtil getInstance() {
        return INSTANCE;
    }

    public void init(Context pContext, CrashListner pCrashListner, Class pCls) {
        mContext = pContext;
        mCallback = pCrashListner;
        mCls = pCls;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable ex) {
        if (!this.handleException(ex) && this.mDefaultHandler != null) {
            this.mDefaultHandler.uncaughtException(thread, ex);
        } else {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException var4) {
                var4.printStackTrace();
                Log.e("CrashHandler", "error : ", var4);
            }
            //退出程序
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        this.mCallback.onSystemCrash();
    }

    private boolean handleException(@Nullable Throwable ex) {
        if (ex == null) {
            return false;
        } else {
            (new Thread() {
                public void run() {
                    Looper.prepare();
                    Toast.makeText(mContext, "很抱歉,程序出现异常,即将重新启动", Toast.LENGTH_LONG).show();
                    Looper.loop();
                }
            }).start();
            this.collectDeviceInfo(this.mContext);
            this.saveCrashInfo2File(ex);
            mContext.startActivity(new Intent(mContext, mCls));
            return true;
        }
    }

    public void collectDeviceInfo(@NonNull Context ctx) {
        try {
            PackageManager fields = ctx.getPackageManager();
            PackageInfo pi = fields.getPackageInfo(ctx.getPackageName(), PackageManager.GET_PERMISSIONS);
            if (pi != null) {
                String versionName = pi.versionName == null ? "null" : pi.versionName;
                String versionCode = pi.versionCode + "";
                this.infos.put("versionName", versionName);
                this.infos.put("versionCode", versionCode);
            }
        } catch (PackageManager.NameNotFoundException var9) {
            Log.e("CrashHandler", "an error occured when collect package info", var9);
        }

        Field[] var10 = Build.class.getDeclaredFields();
        Field[] var11 = var10;
        int var12 = var10.length;

        for (int var13 = 0; var13 < var12; ++var13) {
            Field field = var11[var13];

            try {
                field.setAccessible(true);
                this.infos.put(field.getName(), field.get((Object) null).toString());
                Log.d("CrashHandler", field.getName() + " : " + field.get((Object) null));
            } catch (Exception var8) {
                Log.e("CrashHandler", "an error occured when collect crash info", var8);
            }
        }

    }

    private String saveCrashInfo2File(@NonNull Throwable ex) {
        StringBuffer sb = new StringBuffer();
        Iterator writer = this.infos.entrySet().iterator();

        String result;
        while (writer.hasNext()) {
            Map.Entry printWriter = (Map.Entry) writer.next();
            String cause = (String) printWriter.getKey();
            result = (String) printWriter.getValue();
            sb.append(cause + "=" + result + "\n");
        }

        StringWriter writer1 = new StringWriter();
        PrintWriter printWriter1 = new PrintWriter(writer1);
        ex.printStackTrace(printWriter1);

        for (Throwable cause1 = ex.getCause(); cause1 != null; cause1 = cause1.getCause()) {
            cause1.printStackTrace(printWriter1);
        }

        printWriter1.close();
        result = writer1.toString();
        sb.append(result);

        try {
            long e = System.currentTimeMillis();
            String time = this.formatter.format(new Date());
            String fileName = time + "-" + e + ".log";
            File file = new File(Environment.getExternalStorageDirectory(), fileName);
            Log.i("vbvb","log file path "+file.getAbsolutePath());
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(sb.toString().getBytes());
            fos.close();
            return fileName;
        } catch (Exception var12) {
            Log.e("CrashHandler", "an error occured while writing file...", var12);
            return null;
        }
    }
}
