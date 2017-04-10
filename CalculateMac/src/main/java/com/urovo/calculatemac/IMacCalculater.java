package com.urovo.calculatemac;

/**
 * Created by lenovo on 2017/3/7.
 * 描述：
 */

public interface IMacCalculater {

    /**
     * 计算mac
     * @param pMacKeyIndex mac索引
     * @param pNeedCalMacMsg 计算mac的16进制字符串表示
     * @return 16进制Mac计算结果字符串
     */
    String getMac(int pMacKeyIndex,String pNeedCalMacMsg);


    /**
     * 计算mac
     * @param pMacKeyIndex mac索引
     * @param pNeedCalMacMsgs 计算mac的消息数组（2-63域）
     * @return 16进制Mac计算结果字符串
     */
    String getMac(int pMacKeyIndex,byte pNeedCalMacMsgs []);

    /**
     * mac真正的算法
     * @param pMacKeyIndex mac的密钥索引
     * @param pDataInLen 计算Mac的数据
     * @param pDataIn 计算Mac数据的长度
     * @param pMacOut 计算Mac的输出
     * @param mode
     * @return
     */
    int getMac(int pMacKeyIndex, int pDataInLen, byte[] pDataIn, byte[] pMacOut, byte mode);



}
