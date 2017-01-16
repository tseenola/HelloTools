package pos;

import android.content.Context;

/**
 * Created by lenovo on 2017/1/11.
 * 描述：
 * 1.发送报文
 * 2.解析报文
 */

public interface IBaseDealPrt {
    public interface OnSendAndRcvFinish{
        void onSendAndRcvSucc(String pRcvMsg);
        void onSendAndRcvFail(String pMsg);
    }
    /**
     * 调用（建立socket连接，发送报文，接收报文）
     * @param lSendMsg 发的报文
     * @param pIp
     * @param pPort
     * @param pTimeOut
     * @return
     */
    void sendAndRcvMsg(Context pContexts,byte [] lSendMsg, String pIp, int pPort, int pTimeOut, OnSendAndRcvFinish pListner);

    /**
     * 建立SocketL连接
     * @return
     */
    void initSocket(String ServerIp, int iPort, int timeout);

    /**
     * 发送报文
     * @param buff
     * @param usLen
     */
    void sendMsg(byte[] buff, int usLen);

    /**
     * 接收报文
     * @param MS 超时时间
     * @return 接收到的报文字节数组
     */
    byte [] revMsg(int MS);

    /**
     * 解包
     * @param rcvdMsg
     * @param
     */
    void unPackRcvHexStr(Context pContext,byte rcvdMsg []);
}
