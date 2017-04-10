package com.urovo.calculatemac.utils;

import com.urovo.calculatemac.IMacCalculater;

/**
 * Created by lenovo on 2017/4/10.
 * 描述：计算mac调用工具
 */

public class MacCalculaterUtils {
    /**
     *
     * @param pMacKeyIndex mac索引
     * @param pNeedCalMacMsg 计算mac的16进制字符串表示
     * @param pIMacCalculater mac算法类，执行具体的mac计算，目前已经提供了一个默认mac算法（{@link com.urovo.calculatemac.MacDefCalculater}）
     *                        如果有自己的mac算法，请实现接口（{@link IMacCalculater}）
     * @return 16进制Mac计算结果字符串
     */
    public static String getMac(int pMacKeyIndex, String pNeedCalMacMsg,IMacCalculater pIMacCalculater){
        return pIMacCalculater.getMac(pMacKeyIndex,pNeedCalMacMsg);
    }

    /**
     *
     * @param pMacKeyIndex mac索引
     * @param pNeedCalMacMsgs 计算mac的消息数组（2-63域）
     * @param pIMacCalculater mac算法类，执行具体的mac计算，目前已经提供了一个默认mac算法（{@link com.urovo.calculatemac.MacDefCalculater}）
     *                        如果有自己的mac算法，请实现接口（{@link IMacCalculater}）
     * @return 16进制Mac计算结果字符串
     */
    public static String getMac(int pMacKeyIndex, byte[] pNeedCalMacMsgs,IMacCalculater pIMacCalculater){
        return pIMacCalculater.getMac(pMacKeyIndex,pNeedCalMacMsgs);
    }
}
