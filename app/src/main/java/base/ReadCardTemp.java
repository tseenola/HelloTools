package base;

import android.device.MaxqManager;
import android.util.Log;

import core.CardReader;
import core.PinpadManager;
import db.bill.DBPosSettingBill;
import models.CardInfoModel;
import utils.PosStringUtils;

/**
 * Created by lenovo on 2017/2/16.
 * 描述：
 */

public class ReadCardTemp implements IReadCardTemp,CardReader.OnReadCardFinish{
    public static String encrypedPinKey= "";
    @Override
    public void actionReadCardProcess() {
        encrypedPinKey = "";
        new CardReader().readCard(this);
    }

    /**
     * 2.弹出密码键盘接收密码
     * @param pPardInfo
     */
    private void inputTradePwdEntry(CardInfoModel pPardInfo) {
        // 获取PIN KEY INDEX
        int pinKeyIndex = Integer.valueOf(DBPosSettingBill.getPinKeyIndex());

        // 初始化密码键盘
        String amtAndCardNo = "";
        //if(inputDatas.iTransType == PosTransType.POS_QUE) {
        amtAndCardNo = "支付卡号：" + PosStringUtils.getStarPan(pPardInfo.getCardNo());
        /*} else {
            amtAndCardNo = "支付卡号：" + StringUtil.getStarPan(inputDatas.sPan) + "\n" + "交易金额：" + inputDatas.sAmt;
        }*/
        PinpadManager pinpadMgr = PinpadManager.getInstance();
        pinpadMgr.init();
        pinpadMgr.startInputPwd(pinKeyIndex,
                pPardInfo.getCardNo(),
                10 * 60 * 1000,
                amtAndCardNo,
                pedInputListener);
    }


    @Override
    public void onReadCardSucc(CardInfoModel pPardInfo) {
        CardReader.checkCardThreadIsRun = false;
        Log.i("vbvb","读卡成功："+pPardInfo.toString());
        inputTradePwdEntry(pPardInfo);
    }

    @Override
    public void onReadCardFail(String pFailMsg) {
        Log.i("vbvb","读卡失败：");
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
                } else if (result == 1) {
                    // 取消按键
                    Log.i("vbvb","按下了取消键");
                    //onPasswordInputTimeout();
                } else if (result == -1) {
                    // 失败或超时
                    Log.i("vbvb","失败或超时");
                    //onPasswordInputTimeout();
                } else {
                    // 其他错误
                    Log.i("vbvb","其他错误");
                    //onPasswordInputTimeout();
                }
            } catch (Exception e) {
                Log.i("vbvb","发生异常："+e.getMessage());
                //onPasswordInputTimeout();
            }
        }
    };

}
