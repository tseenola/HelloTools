package models;

import android.util.Log;

/**
 * Created by lenovo on 2017/2/22.
 * 描述：消息
 */

public enum MsgType {
    KeyDownLoad(new MsgTypeInfo("主密钥下载","0800","03,41,42,60")),
    SignIn(new MsgTypeInfo("签到","0800","03,25,41,42,60")),
    IcCardParamDown(new MsgTypeInfo("ic卡参数下载","0800","03,11,25,41,42,60,64")),
    CapkDown(new MsgTypeInfo("capk下载","0800","03,11,25,41,42,60,63,64")),
    AidDown(new MsgTypeInfo("Aid下载","0800","03,11,25,41,42,60,63,64")),
    BalanceQuery(new MsgTypeInfo("余额查询","0200","02,03,11,14,22,23,25,35,36,41,42,49,52,55,60,62,64"));
    private MsgTypeInfo value;

    MsgType(MsgTypeInfo value) {
        Log.i("vbvb","MsgType初始化");
        this.value = value;
    }

    public MsgTypeInfo getValue() {
        return value;
    }



}
