package base;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.buildpackage.model.Body_STD;
import com.hello.readcard.enumm.SwipedMode;
import com.hello.readcard.model.CardInfoModel;
import com.jniexport.UROPElibJni;
import com.urovo.poscommon.models.MsgType;

import tools.com.hellolibrary.hello_convert.ConvertUtils;
import tools.com.hellolibrary.hello_dialog.DialogUtil;

/**
 * Created by lenovo on 2017/2/28.
 * 描述：
 */

public abstract class BaseSwipeCardPrt implements IBaseSwipeCardPrt{

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

    public String getField22_2(SwipedMode pSwipedMode, String sPINData) {
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
     * 检查IC卡
     * @param pCardInfoModel
     * @param pPinEncryStr
     * @param pMsgType
     */
    @Override
    public void checkICCard(CardInfoModel pCardInfoModel, String pPinEncryStr, MsgType pMsgType) {
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

    @Override
    public void actionCardDeal(Context pContext, CardInfoModel pCardInfoModel, MsgType pMsgType, final IBaseSwipeCardAty pIBaseSwipeCardAty) {
        checkICCard(pCardInfoModel,pCardInfoModel.getEncrypedPwd(),pMsgType);
        BaseReq lBaseReq = getMsgModle(pCardInfoModel);
        lBaseReq.actionDeal(pContext, pMsgType, lBaseReq, pCardInfoModel, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                DialogUtil.hideProgressDialog();
                pIBaseSwipeCardAty.onDealSucc("成功！",pBody_std);
            }

            @Override
            public void fail(Body_STD pBody_std) {
                DialogUtil.hideProgressDialog();
                if(!TextUtils.equals("附加响应数据",pBody_std.getmF44().DES)){
                    throw new IllegalStateException("获取 附加响应数据 时发生错误，当前域DES不是 附加响应数据 ！请重新确认 附加响应数据 所在域！");
                }else {
                    pIBaseSwipeCardAty.onDealFail("失败："+pBody_std.getmF44().getValue(),pBody_std);
                }
            }
        });
    }

    /**
     * 获得报文对象
     * @param pCardInfoModel
     * @return
     */
    public abstract BaseReq getMsgModle(CardInfoModel pCardInfoModel);
}
