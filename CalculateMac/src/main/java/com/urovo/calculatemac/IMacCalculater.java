package com.urovo.calculatemac;

/**
 * Created by lenovo on 2017/3/7.
 * 描述：
 */

public interface IMacCalculater {
    /**
     * 计算mac （ECB）类型
     * @param pMacKeyIndex mac密钥索引
     * @param pDataInLen mac数据长度
     * @param pNeedMacDatas 计算mac的数据
     * @return mac计算结果
     */
    byte [] getMac(int pMacKeyIndex, int pDataInLen, byte[] pNeedMacDatas);
}
