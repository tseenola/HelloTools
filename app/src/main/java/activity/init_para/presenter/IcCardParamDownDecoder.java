package activity.init_para.presenter;

/**
 * Created by lenovo on 2017/2/5.
 * 描述：当IC卡参数下载完成后对ic卡参数进行解析，不同项目ic卡参数不同
 *
 *
 * 天下汇：6.30.2	IC卡参数下载（DOWNLORD ICC PARAMETER）
 * 6.30.2.1	概述
 * 在初始化参数步骤3中，用于存放POS的IC卡工作参数，这些参数包括：认证中心公钥数量、IC卡终端数据和AID数量
 */

public class IcCardParamDownDecoder {

    /**
     *@param IcCardParamDownRevMsg 收到的ic卡参数下载报文，需要精确到域
     6.30.2.2	F63.1认证中心公钥数量
     指明需要下载到POS上的认证中心公钥证书的数量，终端收到此数据元后，在初始化参数步骤4：认证中心公钥下载中依次下载指定数量的公钥证书。
     该数据元为2位BCD码，1个字节长。

     * @return
     */
    public static int getCapkNum(String IcCardParamDownRevMsg){

        int capkCount = Integer.valueOf(IcCardParamDownRevMsg.substring(0, 2));
        return capkCount;
    }

    /**
     * @param IcCardParamDownRevMsg 收到的ic卡参数下载报文，需要精确到域
     * 6.30.2.4	AID数量
     指明需要下载到POS上的AID的数量，终端收到此数据元后，在初始化参数步骤5：AID下载中依次下载指定数量的AID。
     该数据元为2位BCD码，1个字节长。

     * @return
     */
    public static int getAidNum(String IcCardParamDownRevMsg){
        int aidCount = Integer.valueOf(IcCardParamDownRevMsg.substring(IcCardParamDownRevMsg.length() - 2), 16);//天下汇aid数量和文档不符，文档为bcd，实际为16进制，所以需要转
        return aidCount;
    }

}
