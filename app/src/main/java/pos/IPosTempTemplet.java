package pos;

import android.content.Context;

import pos2.biz.BaseReq;

/**
 * Created by lenovo on 2017/1/13.
 * 描述：
 */

public interface IPosTempTemplet {
    /**
     * 执行组包发包等
     * @param pTpdu  TPDU
     * @param pDealType 交易类型 eg:0200
     * @param pBitMapStr 位图 eg:"02,03,25,64"
     * @param pDealReq 交易实体 ：eg:SignInReq
     * @return
     */
    void actionDeal(final Context pContext,final String pIp,final int pPort,final int pTime, final String pTpdu, final String pDealType, final String pBitMapStr, final BaseReq pDealReq);
    /**
     * 组包
     * @param pTpdu  TPDU
     * @param pDealType 交易类型 eg:0200
     * @param pBitMapStr 位图 eg:"02,03,25,64"
     * @param pDealReq 交易实体 ：eg:SignInReq
     * @return
     */
    byte [] pack(String pTpdu, String pDealType, String pBitMapStr, BaseReq pDealReq);

    /**
     * 发包
     */
    void sendPack(final Context pContext, final byte [] lSendMsg, final String pIp, final int pPort, final int pTimeOut);

    /**
     * 收包
     */
    String rcvPack();

    /**
     * 解包
     */
    void unPack(String pRcvedHexMsg);

    /**
     * 查包
     */
    void chkPack();
}
