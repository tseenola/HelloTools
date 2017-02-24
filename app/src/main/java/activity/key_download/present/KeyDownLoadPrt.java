package activity.key_download.present;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import activity.key_download.model.KeyDownReq;
import activity.key_download.view.IKeyDownLoadAty;
import base.BaseReq;
import core.MasterKeyWriter;
import db.bill.DBPosSettingBill;
import models.MsgType;
import pos2.fields.F03;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F60;
import pos2.model.Body_STD;
import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lenovo on 2017/1/5.
 * 描述：
 */
public class KeyDownLoadPrt implements IKeyDownLoadPrt {
    public static String STRKEK = "31313131313131313131313131313131";//主密钥解密密钥
    private final IKeyDownLoadAty mView;
    private Context mContext;
    public KeyDownLoadPrt(IKeyDownLoadAty pView) {
        mContext = (Context) pView;
        mView = pView;
    }

    /**
     * 下主密钥
     */
    @Override
    public void actionKeyDown() {
        KeyDownReq lKeyDownReq = new KeyDownReq(
                new F03("900000"),
                new F41(DBPosSettingBill.getTerminalNo()),
                new F42(DBPosSettingBill.getMerchantNo()),
                new F60("A00199")//BCD
        );

        lKeyDownReq.actionDeal(mContext, MsgType.KeyDownLoad, lKeyDownReq, null,new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                writeMasterKey(pBody_std);
            }

            @Override
            public void fail(Body_STD pBody_std) {
                mView.onKeyDownFail("主密钥下载失败："+pBody_std.getmF44().getValue());
            }
        });
    }

    /**
     * 写主密钥
     * @param pBody_std 报文体
     */
    @Override
    public void writeMasterKey(Body_STD pBody_std) {
        if(!TextUtils.equals(pBody_std.getmF48().DES,"附加数据－私有(主密钥)")){
            throw new IllegalStateException("获取主密钥时出错，当前域DES不是 附加数据－私有(主密钥) ！请重新确认附加数据－私有(主密钥) 所在域！");
        }
        byte[] bcdKEK = ConvertUtils.hexStringToByte(STRKEK);
        String strMstSec = pBody_std.getmF48().getValue().split("-->")[1];
        byte[] bcdMstSec = ConvertUtils.hexStringToByte(strMstSec);
        int masterKeyIndex = DBPosSettingBill.getMasterKeyIndex();
        boolean iRet = MasterKeyWriter.actionMasterKeyWrite(masterKeyIndex,bcdKEK,bcdMstSec);
        if(iRet) {
            Log.i("vbvb","写入主密钥成功");
            mView.onKeyDownSucc("主密钥下载成功写入成功");
        } else {
            mView.onKeyDownFail("主密钥下载成功写入失败:");
        }
    }
}
