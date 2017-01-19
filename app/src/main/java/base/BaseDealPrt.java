package base;

import android.content.Context;

import java.io.IOException;

import factory.FieldFactory;
import pos.Field;
import tools.com.hellolibrary.hello_convert.ConvertUtils;
import tools.com.hellolibrary.hello_socket.SocketUtils;
import tools.com.hellolibrary.hello_thread.ThreadUtil;

/**
 * Created by lenovo on 2017/1/11.
 * 描述：
 */

public class BaseDealPrt implements IBaseDealPrt {

    @Override
    public void sendAndRcvMsg(final Context pContext, final byte [] lSendMsg, final String pIp, final int pPort, final int pTimeOut, final OnSendAndRcvFinish pListner) {

        ThreadUtil.runCachedService(new Runnable() {
            @Override
            public void run() {

                initSocket(pIp,pPort,pTimeOut);

                sendMsg(lSendMsg,lSendMsg.length);

                byte pRevMsgByte[] = revMsg(pTimeOut);

                unPackRcvHexStr(pContext,pRevMsgByte);



             /*   ThreadUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pListner.onSendAndRcvSucc(revMsgHexStr);
                    }
                });*/
            }
        });
    }

    @Override
    public void initSocket(String ServerIp, int iPort, int timeout) {
        final int initRet = SocketUtils.initSocket(ServerIp,iPort,timeout);
        if(initRet!=0){
            throw new IllegalStateException("建立socket失败:initRet"+initRet);
        }
    }

    @Override
    public void sendMsg(byte[] buff, int usLen) {
        final int sendMsgRet = SocketUtils.sendMsg(buff);
        if (sendMsgRet!=0){
            throw new IllegalStateException("发送失败:sendMsgRet"+sendMsgRet);
        }
    }

    @Override
    public byte[] revMsg(int MS) {
        byte revMsg[] = SocketUtils.revMsg(MS);
        if(revMsg==null){
            throw new IllegalStateException("接收失败:revMsgRet");
        }
        return revMsg;
    }

    @Override
    public void unPackRcvHexStr(Context pContexts,byte[] rcvdMsg) {
        Field lField = null;
        try {
            lField = FieldFactory.getField(pContexts, FieldFactory.DearType.unpack);
        } catch (IOException pE) {
            pE.printStackTrace();
        }
        String revMsgHexStr  = ConvertUtils.bytesToHexString(rcvdMsg);

    }
}
