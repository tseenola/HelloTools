package activity.sale.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.jniexport.UROPElibJni;

import activity.sale.model.SaleReq;
import activity.sale.view.ISaleAty;
import activity.sale.view.SaleAty;
import base.BaseReq;
import db.bill.DBPosSettingBill;
import models.CardInfoModel;
import models.MsgType;
import models.SwipedMode;
import pos2.fields.F02;
import pos2.fields.F03;
import pos2.fields.F04;
import pos2.fields.F11;
import pos2.fields.F14;
import pos2.fields.F22;
import pos2.fields.F23;
import pos2.fields.F25;
import pos2.fields.F35;
import pos2.fields.F36;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F49;
import pos2.fields.F52;
import pos2.fields.F55;
import pos2.fields.F60;
import pos2.fields.F62;
import pos2.fields.F64;
import pos2.model.Body_STD;
import tools.com.hellolibrary.hello_convert.ConvertUtils;
import utils.SensitiveDataUtil;

/**
 * Created by lenovo on 2017/2/24.
 * 描述：
 */

public class SalePrt implements ISalePrt{

    private ISaleAty mView;
    private Context mContext;
    private SaleAty mSaleAty;
    public SalePrt(ISaleAty pView) {
        mView = pView;
        mContext = (Context)pView;
        mSaleAty = (SaleAty) pView;
    }


    @Override
    public void actionSale(CardInfoModel pCardInfoModel) {
        checkICCard(pCardInfoModel,pCardInfoModel.getEncrypedPwd(),MsgType.Sale);

        SaleReq lSaleReq = new SaleReq(
                new F02(SensitiveDataUtil.hideSensitiveData(2,pCardInfoModel.getCardNo())),
                new F03("00A000"),
                new F04("000000000001"),
                new F11(DBPosSettingBill.getTraceNo()),
                new F14(SensitiveDataUtil.hideSensitiveData(14,pCardInfoModel.getValidTime())),
                new F22(getField22_2(pCardInfoModel.getSwipedMode(),pCardInfoModel.getEncrypedPwd())),
                new F23(pCardInfoModel.getCardSeqNo()),
                new F25("14"),
                new F35(SensitiveDataUtil.hideSensitiveData(35,pCardInfoModel.getTrack2())),
                new F36(SensitiveDataUtil.hideSensitiveData(36,pCardInfoModel.getTrack3())),
                new F41(DBPosSettingBill.getTerminalNo()),
                new F42(DBPosSettingBill.getMerchantNo()),
                new F49("156"),
                new F52(pCardInfoModel.getEncrypedPwd()),
                new F55(getF55ForOnlineTx()),
                new F60(SensitiveDataUtil.getEncryptionData(1,
                        new String[] {
                                pCardInfoModel.getCardNo(),
                                pCardInfoModel.getValidTime(),
                                "",
                                pCardInfoModel.getTrack2().replaceAll("=", "D"),
                                pCardInfoModel.getTrack3().replaceAll("=", "D")
                        })),
                new F62(DBPosSettingBill.getTraceNo()+DBPosSettingBill.getBatchNo()),
                new F64(""));

        lSaleReq.actionDeal(mContext, MsgType.Sale, lSaleReq, pCardInfoModel, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                mView.onSaleSucc("消费成功！");
            }

            @Override
            public void fail(Body_STD pBody_std) {
                if(!TextUtils.equals("附加响应数据",pBody_std.getmF44().DES)){
                    throw new IllegalStateException("获取 附加响应数据 时发生错误，当前域DES不是 附加响应数据 ！请重新确认 附加响应数据 所在域！");
                }else {
                    mView.onSaleFail(pBody_std.getmF44().getValue());
                }
            }
        });
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
}
