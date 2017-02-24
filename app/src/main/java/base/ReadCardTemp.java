package base;

import android.device.MaxqManager;
import android.text.TextUtils;
import android.util.Log;

import com.jniexport.UROPElibJni;

import core.CardReader;
import core.PinpadManager;
import db.bill.DBPosSettingBill;
import models.CardInfoModel;
import models.MsgType;
import models.SwipedMode;
import tools.com.hellolibrary.hello_convert.ConvertUtils;
import utils.PosStringUtils;

/**
 * Created by lenovo on 2017/2/16.
 * 描述：
 */

public abstract class ReadCardTemp implements IReadCardTemp,CardReader.OnReadCardFinish, CardReader.OnEncryPwdFinish {
    CardReader.OnEncryPwdFinish mOnEncryPwdFinish;
    CardInfoModel mCardInfoModel;
    static String encrypedPinKey= "";
    private PinpadManager pinpadMgr;

    @Override
    public void actionReadCardProcess(CardReader.OnEncryPwdFinish pOnEncryPwdFinish) {
        mOnEncryPwdFinish = pOnEncryPwdFinish;
        encrypedPinKey = "";
        new CardReader().readCard(this);
    }

    /**
     * 2.弹出密码键盘接收密码
     * @param pPardInfo
     */
    protected void inputTradePwdEntry(CardInfoModel pPardInfo) {
        mCardInfoModel = pPardInfo;
        // 获取PIN KEY INDEX
        int pinKeyIndex = DBPosSettingBill.getPinKeyIndex();

        // 初始化密码键盘
        String amtAndCardNo = "";
        //if(inputDatas.iTransType == PosTransType.POS_QUE) {
        amtAndCardNo = "支付卡号：" + PosStringUtils.getStarPan(pPardInfo.getCardNo());
        /*} else {
            amtAndCardNo = "支付卡号：" + StringUtil.getStarPan(inputDatas.sPan) + "\n" + "交易金额：" + inputDatas.sAmt;
        }*/
        pinpadMgr = PinpadManager.getInstance();
        pinpadMgr.init();
        pinpadMgr.startInputPwd(pinKeyIndex,
                pPardInfo.getCardNo(),
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

    /**获取22域的值
     * @param
     * @return
     */
    public String getField22(int bSwipedMode,String sPINData) {
        String str1 = "";
        /*if(bSwipedMode == Constants.SWIPE_MODE.NO_SWIPE_INSERT) {
            str1 = "001";
        } else if (bSwipedMode == Constants.SWIPE_MODE.CARD_SWIPED) {
            str1 = "002";
        } else if (bSwipedMode == Constants.SWIPE_MODE.CARD_INSERTED) {
            str1 = "005";
        } else if (bSwipedMode == Constants.SWIPE_MODE.CLCARD_SWIPED) {
            str1 = "007";
        }*/

        if(bSwipedMode == SwipedMode.NO_SWIPE_INSERT.getMode()) {
            str1 = "001";
        } else if (bSwipedMode == SwipedMode.CARD_SWIPED.getMode()) {
            str1 = "002";
        } else if (bSwipedMode == SwipedMode.CARD_INSERTED.getMode()) {
            str1 = "005";
        } else if (bSwipedMode == SwipedMode.CLCARD_SWIPED.getMode()) {
            str1 = "007";
        }
        if (TextUtils.isEmpty(sPINData)) {
            str1 += "2";
        } else {
            str1 += "1";
        }
        return str1;
    }

    public String getField22_2(SwipedMode pSwipedMode,String sPINData) {
        String str1 = "";
        if(pSwipedMode == SwipedMode.NO_SWIPE_INSERT) {
            str1 = "001";
        } else if (pSwipedMode == SwipedMode.CARD_SWIPED) {
            str1 = "002";
        } else if (pSwipedMode == SwipedMode.CARD_INSERTED) {
            str1 = "005";
        } else if (pSwipedMode == SwipedMode.CLCARD_SWIPED) {
            str1 = "007";
        }
        if (TextUtils.isEmpty(sPINData)) {
            str1 += "2";
        } else {
            str1 += "1";
        }
        return str1;
    }


    /**
     * 获取IC卡的发送数据,是在报文上送时，从这里取出55域
     * @return
     */
    public String getF55ForOnlineTx() {
        String str = "";
        int[] IccDatasLen = new int[2];
        byte[] ICCDatas = new byte[256];
        byte[] ICCDatasAsc = new byte[1024];

        int get55Result = UROPElibJni.GetF55ForOnlineTx(ICCDatas, IccDatasLen);
        if (IccDatasLen[0] > 512)
            IccDatasLen[0] = 512;

        if (IccDatasLen[0] > 0) {
            int Bcdlen = IccDatasLen[0];
            ICCDatasAsc = new byte[Bcdlen * 2];
            ConvertUtils.BcdToAsc(ICCDatasAsc, ICCDatas, Bcdlen * 2);

            str = new String(ICCDatasAsc);
            Log.i("vbvb","Ic卡数据域 : "+str);
            return str;
        } else {
            Log.i("vbvb","Ic卡数据域 : ");
            return "";
        }
    }
    /**
     * 检查IC卡
     * @param pCardInfoModel
     * @param pPinEncryStr
     * @param pMsgType
     */
    protected void checkICCard(CardInfoModel pCardInfoModel, String pPinEncryStr, MsgType pMsgType) {
        int pinMode = 0;
        int i= pCardInfoModel.getSwipedMode().getMode();
        int ii = SwipedMode.CARD_INSERTED.getMode();
        if (pCardInfoModel.getSwipedMode().getMode() == SwipedMode.CARD_INSERTED.getMode()) {
            if (pPinEncryStr=="") {
                pinMode = 2;    // 没有输PIN
            } else {
                pinMode = 1;    // 有输入PIN
            }
            switch (pCardInfoModel.getCvmStartRet()) {
                case 0:         // 无需cvm
                case 49:        // 请出示证件
                    break;
                case 50:        // 需要输入联机密文
                    UROPElibJni.SetPinCVR(pinMode);
                    break;
                case 51:        // 需要输入脱机明文
                    // 暂不处理
                    // if (pwd.length() > 0)
                    //     UROPElibJni.ProcOfflinePlantPin(pwd.getBytes(), pwd.length());
                default:
                    break;
            }
            // 不输入密码执行ProcRiskActAnalyse会返回-225
            // 参数设置需要输入密码：消费撤销、预授权撤销
            // 无需输密：退货、预授权完成、预授权完成(请求)撤销
            if (pMsgType.getValue() != MsgType.Sale.getValue()) {
                int analyseRet = UROPElibJni.ProcRiskActAnalyse();
                switch (analyseRet) {
                    case 203:   // 脱机接收
                    case 204:   // 电子现金脱机接收
                    case 223:   // 联机处理
                        break;
                    default:
                        throw new IllegalStateException("终端行为分析出错 " + analyseRet);
                }
            }
        } else if (pCardInfoModel.getSwipedMode() == SwipedMode.CLCARD_SWIPED) {
            UROPElibJni.SetPinCVR(0);
        }
    }

    /**
     * 停止密码键盘
     */
    private void finishPinPad() {
        if(pinpadMgr != null) {
            // 移除PinPad监听
            pinpadMgr.removePinpadListener(pedInputListener);
            // 关闭密码键盘
            pinpadMgr.fini();
            pinpadMgr=null;
        }
    }
}