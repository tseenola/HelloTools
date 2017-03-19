package com.urovo.calculatemac;

/**
 * Created by lenovo on 2017/3/7.
 * 描述：
 */

public interface IMacCalculater {
    /**
     *
     * @param pMacKeyIndex mac的密钥索引
     * @param pDataInLen 计算Mac的数据
     * @param pDataIn 计算Mac数据的长度
     * @param pMacOut 计算Mac的输出
     * @param mode
     * @return
     */
    int getMac(int pMacKeyIndex, int pDataInLen, byte[] pDataIn, byte[] pMacOut, byte mode);
}
