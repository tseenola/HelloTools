package com.hello.readcard.read_pwd;

import android.content.Context;
import android.device.MaxqManager;
import android.device.MaxqManager.PedInputListener;
import android.util.Log;

/**
 * 模块：    金融交易密码键盘（POS厂商实现层）
 * 说明：
 * 实现更新密钥和输密流程
 * 版本号:   v2.0.3
 * 更新时间: 2016/01/26
 * 更新记录：
 * v2.0.0 2015/12/17 kay 在1.0基础上简化流程，更新为SDK2.0可移植包
 * v2.0.1 2015/12/22 kay 完善注解
 * v2.0.2 2016/01/20 kay showTxt形参String txt改为byte[] txt
 * v2.0.3 2016/01/26 kay 对encrypt和decrypt方法retBuf返回值进行补充说明
 * 特别说明：
 * 1）实现层所有异常，于实现层全部捕获处理，可转为错误Message或return值传递给APP调用层。
 * 2）APP调用层只使用酷银当前定义的接口和成员，不使用POS厂商定义的接口和成员。
 * 3）POS厂商须提供对应的demo来论证实现层是否符合要求。
 */

public class PinpadManager {
    private final static String TAG = "PinpadManager";
    private final static byte _PINKEY = 2;

    private volatile static PinpadManager singleton;
    private MaxqManager mMaxqManager = null;

    protected Context mContext = null; //保存APP调用层传入的context对象，避免直接使用调用层对象。

    private PinpadManager() {
    }

    public static PinpadManager getInstance() {
        if (singleton == null) {
            synchronized (PinpadManager.class) {
                if (singleton == null) {
                    singleton = new PinpadManager();
                }
            }
        }
        return singleton;
    }

    /**
     * 此接口主要实现银行卡交易密码键盘初始化工作
     */
    public boolean init() {
        mMaxqManager = new MaxqManager();
        int result = mMaxqManager.open();
        if (result != 0)
            return false;

        return true;
    }

    /**
     * 此接口主要实现数字密码输入计算出加密密码
     *
     * @param cardNo     银行卡号
     * @param pkIndex    终端pin密钥索引号
     * @param timeOut    输密超时时间，单位毫秒
     * @param amtAndCard 金额和卡号
     */
    public boolean startInputPwd(int pkIndex, String cardNo, long timeOut, String amtAndCard, PedInputListener pedInputListener) {
        if (cardNo == null || timeOut <= 0) {
            return false;
        }
        int ret = mMaxqManager.getPinBlock(_PINKEY, pkIndex, cardNo.getBytes(), cardNo.length(), amtAndCard, timeOut, pedInputListener);
        if (ret != 0) {
            Log.i("vbvb","updWorkKey mkIndex=" + pkIndex + " =ret=" + ret);
            Log.d(TAG, "updWorkKey mkIndex=" + pkIndex + " =ret=" + ret);
            return false;
        }
        return true;
    }

    public void removePinpadListener(PedInputListener pedInputListener) {
        if(mMaxqManager != null && pedInputListener != null) {
            mMaxqManager.removePedInputListener(pedInputListener);
        }
    }

    /**
     * 和init()配套，释放占用的密码键盘资源
     */
    public void fini() {
        if (mMaxqManager != null) {
            mMaxqManager.close();
        }
    }
}
