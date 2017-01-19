package pos;

import android.content.Context;

import base.BaseReq;

/**
 * Created by lenovo on 2017/1/13.
 * 描述：
 */

public interface IPosTempTemplet {


    /**
     * 执行交易流程（模板方法模式）
     * @param pContext 上下文
     * @param pIp ip地址
     * @param pPort 端口
     * @param pTime 超时时间
     * @param pTpdu tpdu
     * @param pDealType 交易类型 eg:0200 , 0800 and so on
     * @param pBitMapStr 位图 eg:"02,03,25,64"
     * @param pDealReq 交易实体 ：eg:SignInReq , KeyDownReq
     */
    void actionDeal(final Context pContext, final String pIp, final int pPort, final int pTime, final String pTpdu, final String pDealType, final String pBitMapStr, final BaseReq pDealReq, BaseReq.ResultListener pResultListener);
    /**
     * 组包
     * @param pTpdu  TPDU
     * @param pDealType 交易类型 eg:0200
     * @param pBitMapStr 位图 eg:"02,03,25,64"
     * @param pDealReq 交易实体 ：eg:SignInReq , KeyDownReq
     * @return
     */
    byte [] pack(String pTpdu, String pDealType, String pBitMapStr, BaseReq pDealReq);

    /**
     * 发包
     * @param pContext 上下文
     * @param lSendMsg 发送数据的字节数组，到这里报文是完整的，不要再在这里组包了
     * @param pIp  ip地址
     * @param pPort 端口
     * @param pTimeOut 超时时间
     */
    void sendPack(final Context pContext, final byte [] lSendMsg, final String pIp, final int pPort, final int pTimeOut);

    /**
     * 收包
     */
    String rcvPack();

    /**
     * 解包
     * @param pRcvedHexMsg 收到的报文的16进制字符串表示放在这里
     * @return 解包结果。Object[0] 存放报文头对象：Header_STD
     * Object[1]存放报文体对象: Body_STD
     */
    Object [] unPack(String pRcvedHexMsg);

    /**
     * 检查包
     * @param pUnPackResult 解包后的结果作为参数
     * @return 交易是否成功
     */
    boolean chkPack(Object [] pUnPackResult);
}
