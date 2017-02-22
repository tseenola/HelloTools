package activity.sign_in.presenter;

import android.content.Context;
import android.widget.Toast;

import activity.sign_in.model.SignInReq;
import activity.sign_in.view.ISignInAty;
import base.BaseReq;
import core.WorkingKeyWriter;
import db.bill.DBPosSettingBill;
import models.MsgType;
import pos2.fields.F03;
import pos2.fields.F25;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F60;
import pos2.model.Body_STD;
import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lijun on 2017/1/5.
 * 描述：签到完成后需要（写入工作密钥，还需要同步批次号和流水号---->syncParaWithServiceAndDB()）
 */
public class SignInPrt implements ISignInPrt {

    private final ISignInAty mView;
    private Context mContext;
    public SignInPrt(ISignInAty pView) {
        mContext = (Context) pView;
        mView = pView;
    }

    @Override
    public void actionSign() {
        //封装对象
        SignInReq signReq = new SignInReq(
                new F03("940000"),
                new F25("14"),
                new F41(DBPosSettingBill.getTerminalNo()),
                new F42(DBPosSettingBill.getMerchantNo()),
                new F60("A00199"));//BCD
        //交易并接受结果
        signReq.actionDeal(mContext, MsgType.SignIn, signReq, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                Toast.makeText(mContext,"succ"+pBody_std.getmF44().getValue(),Toast.LENGTH_LONG).show();
                syncParaWithServiceAndDB(pBody_std);
            }

            @Override
            public void fail(Body_STD pBody_std) {
                Toast.makeText(mContext,"fail"+pBody_std.getmF44().getValue(),Toast.LENGTH_LONG).show();
            }
        });
    }
    /**
     * 1.同步批次号
     * 2.同步流水号
     * 3.写入工作密钥
     * 4.同步签到状态到数据库（是否已经签到）
     */
    @Override
    public void syncParaWithServiceAndDB(Body_STD pBody_std) {
        //1.同步批次号,2.同步流水号
        String f63 = pBody_std.getmF62().getValue().split("-->")[1];
        String lBatch = f63.substring(6,12);
        String lTrace = f63.substring(0,6);
        DBPosSettingBill.syncBatchAndTrace(lBatch,lTrace);
        //3.写入工作密钥
        /* 天下汇工作密钥的数据长度33个字节。
         * 第1字节MAC类型，目前只支持0x01，采用ECB进行运算。
         * 第2-17字节PIN Key的密文。
         * 第18-33字节MAC Key的密文。
         */
        String workKeySec = pBody_std.getmF61().getValue();

        if(workKeySec == null) {
            throw new IllegalArgumentException("工作密钥获取失败");
        }else if(workKeySec.length()/2 != 33) {
            throw new IllegalArgumentException("工作密钥长度和文档不符");
        }

        if(!workKeySec.startsWith("01")) {
            throw new IllegalArgumentException("不支持的工作密钥加密类型,现在只支持ECB");
        }

        String lPinSec = workKeySec.substring(2,17*2);
        String lMacSec = workKeySec.substring(17*2,33*2);

        byte pinDatas [] = ConvertUtils.hexStringToByte(lPinSec);
        byte macDatas [] = ConvertUtils.hexStringToByte(lMacSec);

        int masterKeyIndex = DBPosSettingBill.getMasterKeyIndex();

        boolean succ = WorkingKeyWriter.doWriteWorkKey(pinDatas,macDatas,new byte[0],masterKeyIndex,new byte[4],false);

        if(succ){
            //4.同步签到状态到数据库（是否已经签到）
            DBPosSettingBill.setSignInStatus(true);
            mView.onSignInSucc("签到and写入工作密钥成功");
        }else {
            //4.同步签到状态到数据库（是否已经签到）
            DBPosSettingBill.setSignInStatus(false);
            mView.onSignInFail("签到but写入工作密钥失败");
        }
    }
}
