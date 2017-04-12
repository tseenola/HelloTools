package com.urovo.calculatemac.utils;

import com.urovo.calculatemac.IMacCalculater;

/**
 * Created by lenovo on 2017/4/12.
 * 描述：
 */

public class MacCalculaterUtils {

    /**
     *
     * @param pMacKeyIndex mac索引
     * @param pDataInLen 计算长度
     * @param pNeedMacDatas  计算mac的消息数组（2-63域）
     * @param pIMacCalculater mac算法类，执行具体的mac计算，目前已经提供了一些默认mac算法such as:（{@link com.urovo.calculatemac.MacCalculater_ECB}）
     *                        如果有自己的mac算法，请实现接口（{@link IMacCalculater}）
     * @return
     */
    public static byte[] getMac(int pMacKeyIndex, int pDataInLen, byte[] pNeedMacDatas,IMacCalculater pIMacCalculater){
        return pIMacCalculater.getMac(pMacKeyIndex,pDataInLen,pNeedMacDatas);
    }
}
