package activity.init_para.presenter;

import android.content.Context;
import android.util.Log;

import activity.init_para.model.AidDownLoadReq;
import activity.init_para.model.CAPKDownReq;
import activity.init_para.model.IcParamReq;
import activity.init_para.view.IInitParamAty;
import base.BaseReq;
import core.IcCardParamDownDecoder;
import db.bill.DBAppParasBill;
import db.bill.DBCapkBill;
import db.bill.DBPosSettingBill;
import models.MsgType;
import pos2.fields.F03;
import pos2.fields.F11;
import pos2.fields.F25;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F60;
import pos2.fields.F63;
import pos2.fields.F64;
import pos2.model.Body_STD;
import tools.com.hellolibrary.hello_string.StringUtils;
import utils.PosStringUtils;

/**
 * Created by lenovo on 2017/1/19.
 * 描述：
 */
public class InitParamPrt implements IInitParamPrt {
    private IInitParamAty mView;
    private Context mContext;

    public InitParamPrt(IInitParamAty pView) {
        mView = pView;
        mContext = (Context) pView;
    }

    /**
     * ic卡参数下载
     */
    @Override
    public void actionIcCardParamDown() {
        IcParamReq lIcParamReq = new IcParamReq(
                new F03("920000"),
                new F11(DBPosSettingBill.getTraceNo()),
                new F25("14"),
                new F41(DBPosSettingBill.getTerminalNo()),
                new F42(DBPosSettingBill.getMerchantNo()),
                new F60("A00199"),
                new F64("")
        );
        lIcParamReq.actionDeal(mContext, MsgType.IcCardParamDown, lIcParamReq, null,new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                int lAidNo = IcCardParamDownDecoder.getAidNum(pBody_std.getmF63().getValue());
                int lCapkNo = IcCardParamDownDecoder.getCapkNum(pBody_std.getmF63().getValue());
                DBAppParasBill.clearTable();
                DBCapkBill.clearTable();
                mView.onICParamDownSucc(lAidNo, lCapkNo);
                Log.i("vbvb", "ic卡参数下载成功");
            }

            @Override
            public void fail(Body_STD pBody_std) {
                Log.i("vbvb", "ic卡参数下载失败");
            }
        });
    }

    /**
     * 执行capk下载
     * @param pCapkSeq 下载第几条Capk
     */
    @Override
    public void actionCapkDown(final int pCapkSeq) {
        CAPKDownReq lCAPKDownReq = new CAPKDownReq(
                new F03("930000"),
                new F11(DBPosSettingBill.getTraceNo()),
                new F25("14"),
                new F41(DBPosSettingBill.getTerminalNo()),
                new F42(DBPosSettingBill.getMerchantNo()),
                new F60("A00199"),
                new F63(StringUtils.fillContentBy(StringUtils.Dir.left, "0", pCapkSeq + "", 2)),
                new F64("")
        );
        lCAPKDownReq.actionDeal(mContext, MsgType.CapkDown, lCAPKDownReq, null,new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                //拼接Capk
                String ridValue = pBody_std.getmF63().getValue().substring(2, 12);//RID
                String indexValue = pBody_std.getmF63().getValue().substring(12, 14); //认证中心公钥索引
                String hashFlag = pBody_std.getmF63().getValue().substring(14, 16);//认证中心哈希算法标识
                String algorithmFlag = pBody_std.getmF63().getValue().substring(16, 18);//认证中心公钥算法标识（签名）
                //认证中心公钥模
                int moduleLength = Integer.valueOf(pBody_std.getmF63().getValue().substring(18, 20), 16) * 2;
                String moduleValue = pBody_std.getmF63().getValue().substring(20, 20 + moduleLength);
                //认证中心公钥指数
                String exponentValue = pBody_std.getmF63().getValue().substring(20 + moduleLength, 26 + moduleLength);
                //认证中心公钥校验数
                String validValue = pBody_std.getmF63().getValue().substring(26 + moduleLength, 66 + moduleLength);
                //有效期
                String dateValue = "20" + pBody_std.getmF63().getValue().substring(66 + moduleLength, 72 + moduleLength);

                String strCapk = PosStringUtils.getTlvStr("9F06", ridValue)
                        + PosStringUtils.getTlvStr("9F22", indexValue)
                        + PosStringUtils.getTlvStr("DF06", hashFlag)
                        + PosStringUtils.getTlvStr("DF07", algorithmFlag)
                        + PosStringUtils.getTlvStr("DF02", moduleValue)
                        + PosStringUtils.getTlvStr("DF04", exponentValue)
                        + PosStringUtils.getTlvStr("DF03", validValue)
                        + PosStringUtils.getTlvStr("DF05", dateValue);
                DBCapkBill.inserAid(strCapk);
                mView.onCAPKDownDownSucc(strCapk,pCapkSeq);
            }

            @Override
            public void fail(Body_STD pBody_std) {
                Log.i("vbvb", "公钥下载失败");
            }
        });
    }


    /**
     * 执行Aid下载
     * @param pAidSeq 下载第几条Aid
     */
    @Override
    public void actionAidDown(final int pAidSeq) {
        AidDownLoadReq lAidDownLoadReq = new AidDownLoadReq(
                new F03("990000"),
                new F11(DBPosSettingBill.getTraceNo()),
                new F25("14"),
                new F41(DBPosSettingBill.getTerminalNo()),
                new F42(DBPosSettingBill.getMerchantNo()),
                new F60("A00199"),
                new F63(StringUtils.fillContentBy(StringUtils.Dir.left, "0", pAidSeq + "", 2)),
                new F64("")
        );
        lAidDownLoadReq.actionDeal(mContext, MsgType.AidDown, lAidDownLoadReq, null,new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                Log.i("vbvb", "aid 下载成功");
                String aid = pBody_std.getmF63().getValue().substring(2, 34).replace("FF", "");//AID
                String appVer = pBody_std.getmF63().getValue().substring(34, 38);//应用版本号
                String matchWay = pBody_std.getmF63().getValue().substring(38, 40);//AID匹配方式
                String defaultAct = pBody_std.getmF63().getValue().substring(40, 50);//终端行为代码（TAC）-缺省
                String refuseAct = pBody_std.getmF63().getValue().substring(50, 60);//终端行为代码（TAC）-拒绝
                String onlineAct = pBody_std.getmF63().getValue().substring(60, 70);//终端行为代码（TAC）-联机
                String termLow = pBody_std.getmF63().getValue().substring(70, 82);//终端最低限额
                String randomTransIndi = pBody_std.getmF63().getValue().substring(82, 84);//随机交易选择指示符
                String orThreshold = pBody_std.getmF63().getValue().substring(84, 96);//偏置随机选择阈值
                String orMaxPercent = pBody_std.getmF63().getValue().substring(96, 98);//偏置随机选择最大目标百分数
                String rTarPercent = pBody_std.getmF63().getValue().substring(98, 100);//随机选择目标百分数
                String defaultDDOL = pBody_std.getmF63().getValue().substring(100, 106);//缺省DDOL
                String supportPin = pBody_std.getmF63().getValue().substring(106, 108);//终端联机PIN支持能力

                String strAid = PosStringUtils.getTlvStr("9F06", aid)
                        + PosStringUtils.getTlvStr("9F09", appVer)
                        + PosStringUtils.getTlvStr("DF01", matchWay)
                        + PosStringUtils.getTlvStr("DF11", defaultAct)
                        + PosStringUtils.getTlvStr("DF13", refuseAct)
                        + PosStringUtils.getTlvStr("DF12", onlineAct)
                        + PosStringUtils.getTlvStr("9F1B", termLow)
                        + PosStringUtils.getTlvStr("DF15", orThreshold)
                        + PosStringUtils.getTlvStr("DF16", orMaxPercent)
                        + PosStringUtils.getTlvStr("DF17", rTarPercent)
                        + PosStringUtils.getTlvStr("DF14", defaultDDOL)
                        + PosStringUtils.getTlvStr("DF18", supportPin);
                DBAppParasBill.inserAid(strAid);
                mView.onAidDownSucc(strAid,pAidSeq);
            }

            @Override
            public void fail(Body_STD pBody_std) {
                Log.i("vbvb", "aid 下载失败");
            }
        });
    }

    @Override
    public void updateAidCapkStatus() {
        DBPosSettingBill.setNoNeedDownAid("0");
        DBPosSettingBill.setNoNeedDownCapk("0");
    }
}
