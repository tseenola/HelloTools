package tools.com.hellolibrary.hello_socket;


import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Socket工具
 * 1.建立socket连接
 * 2.发送消息
 * 3.接收消息
 */
public class SocketUtils {
    private static Socket mScoketClient;

    /**
     * 获得socket连接
     * 返回0为建立连接成功
     *
     * @param pIp 服务器IP地址
     * @param pPort 服务器端口
     * @param pTimeOut 连接超时时间
     * @return 0建立成功，其它失败
     */
    public static int initSocket(String pIp, int pPort, int pTimeOut) {
        int iRet = 0;
        mScoketClient = null;
        try {
            mScoketClient = new Socket();
            InetSocketAddress isa = new InetSocketAddress(pIp, pPort);
            mScoketClient.connect(isa, pTimeOut * 1000);
        } catch (UnknownHostException e) {
            iRet = -1;
        } catch (IOException e) {
            iRet = -2;
        }
        return iRet;
    }

    /**
     * 通过 socket发送消息，
     * 返回0为发送消息成功
     *
     * @param pBuff 发送消息的字节数组
     * @return 0：发送消息成功，其它失败
     */
    public static int sendMsg(byte[] pBuff) {
        int iRet = 0;
        try {
            if (mScoketClient == null) {
                throw new NullPointerException("mScoketClient为null,你是否已经执行initSocket函数？");
            }
            OutputStream socketWriter = mScoketClient.getOutputStream();
            Log.i("vbvb", "发送出去的报文：" + ConvertUtils.bytesToHexString(pBuff));
            socketWriter.write(pBuff);
            socketWriter.flush();
        } catch (Exception e) {
            closeSocket();
            iRet = -1;
        }
        return iRet;
    }

    /**
     * 接收消息
     * @param MS   接收超时时间(单位秒)
     * @return 接收消息结果
     */
    public static byte[] revMsg(int MS) {
        byte[] RecvBuff = new byte[2048];
        System.gc();
        try {
            mScoketClient.setSoTimeout(MS * 1000);
            InputStream input = mScoketClient.getInputStream();
            int Recvlen = input.read(RecvBuff);
            byte lRevMsg [] = new byte[Recvlen];
            System.arraycopy(RecvBuff,0,lRevMsg,0,Recvlen);
            Log.i("vbvb", "接收到的报文：" + ConvertUtils.bytesToHexString(lRevMsg));
            return lRevMsg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeSocket();
        }
    }

    /**
     * 关闭socket并释放资源
     */
    private static void closeSocket() {
        if (mScoketClient != null) {
            try {
                if (mScoketClient.isConnected()) {
                    mScoketClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            mScoketClient = null;
        }
    }
}
