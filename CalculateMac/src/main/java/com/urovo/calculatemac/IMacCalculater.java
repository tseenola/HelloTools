package com.urovo.calculatemac;

/**
 * Created by lenovo on 2017/3/7.
 * 描述：
 */

public interface IMacCalculater {
    /**
     * 计算MAC通过(硬加密）的方式
     * @param pMacKeyIndex mac密钥索引
     * @param pDataInLen mac数据长度
     * @param pNeedMacDatas 计算mac的数据
     * @return mac计算结果
     */
    byte [] getMac(int pMacKeyIndex, int pDataInLen, byte[] pNeedMacDatas);

    /**
     * 计算MAC通过（软加密）的方式
     * @param pKeys 密钥
     * @param pNeedMacDatas 待计算mac的数据
     * @return mac计算结果
     */
    byte [] getMac(byte pKeys [],byte[] pNeedMacDatas) throws Exception;

}
