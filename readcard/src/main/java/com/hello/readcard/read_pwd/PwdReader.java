package com.hello.readcard.read_pwd;

import android.device.MaxqManager;
import android.support.annotation.Nullable;
import android.util.Log;

import com.hello.readcard.model.CardInfoModel;

import static tools.com.hellolibrary.hello_string.PosStringUtils.getStarPan;

/**
 * Created by lenovo on 2017/3/1.
 * 描述：
 */

public class PwdReader {
    private CardInfoModel mCardInfoModel;
    private PinpadManager mPinpadMgr;
    private OnEncryPwdFinish mOnEncryPwdFinish;

    /**
     * 获取pin加密后的密文
     * @param pCardInfo 刷卡信息
     * @param pPinKeyIndex pin密钥的索引
     * @param pAmt 金额 金额保留两位小数 eg( 0.01)
     * @param pOnEncryPwdFinish 运行结果回调接口
     */
    public void getEncryptedPwd(CardInfoModel pCardInfo, int pPinKeyIndex, @Nullable String pAmt, OnEncryPwdFinish pOnEncryPwdFinish){
        mOnEncryPwdFinish = pOnEncryPwdFinish;
        mCardInfoModel = pCardInfo;
        // 初始化密码键盘
        String amtAndCardNo = "";
        if(pAmt==null) {
            amtAndCardNo = "支付卡号：" + getStarPan(pCardInfo.getCardNo());
        } else {
            amtAndCardNo = "支付卡号：" + getStarPan(pCardInfo.getCardNo()) + "\n" + "交易金额：" + pAmt;
        }
        mPinpadMgr = PinpadManager.getInstance();
        mPinpadMgr.init();
        mPinpadMgr.startInputPwd(pPinKeyIndex,
                pCardInfo.getCardNo(),
                10 * 60 * 1000,
                amtAndCardNo,
                pedInputListener);
    }

    /**
     * 密码键盘监听
     */
    private MaxqManager.PedInputListener pedInputListener = new MaxqManager.PedInputListener() {
        /**
         * 密码输入回调
         *
         * @param result -1:失败或超时; 0:输入密码完成; 1:标示取消密码输入; 2:有密码输入
         * @param keylen 已经输入的密码长度
         * @param keybuf 输入完成时返回的key 数组
         */
        @Override
        public void onChanged(int result, int keylen, byte[] keybuf) {
            try {
                Log.i("vbvb","密码键盘返回值:" + result + "  已经输入密码长度："+keylen +"  返回的key数组："+new String(keybuf));

                if (result == 2) {
                    // 有密码数字输入
                    // 系统托管
                } else if (result == 0) {
                    // 确认按键
                    String encrypedPinKey = new String(keybuf);
                    Log.i("vbvb","按下了确认键:"+encrypedPinKey);
                    finishPinPad();
                    mOnEncryPwdFinish.onEncryPwdSucc(mCardInfoModel,encrypedPinKey);
                } else if (result == 1) {
                    // 取消按键
                    finishPinPad();
                    Log.i("vbvb","按下了取消键");
                    //onPasswordInputTimeout();
                } else if (result == -1) {
                    finishPinPad();
                    // 失败或超时
                    Log.i("vbvb","失败或超时");
                    //onPasswordInputTimeout();
                } else {
                    // 其他错误
                    finishPinPad();
                    Log.i("vbvb","其他错误");
                    //onPasswordInputTimeout();
                }
            } catch (Exception e) {
                Log.i("vbvb","发生异常："+e.getMessage());
                //onPasswordInputTimeout();
            }
        }
    };

    /**
     * 停止密码键盘
     */
    private void finishPinPad() {
        if(mPinpadMgr != null) {
            // 移除PinPad监听
            mPinpadMgr.removePinpadListener(pedInputListener);
            // 关闭密码键盘
            mPinpadMgr.fini();
            mPinpadMgr=null;
        }
    }

    /**
     * 对pin加密后的结果回调接口
     */
    public interface OnEncryPwdFinish{
        void onEncryPwdSucc(CardInfoModel pCardInfoModel, String pPinEncryStr);
        void onEncryPwdFail(String pErroMsg);
    }


}
