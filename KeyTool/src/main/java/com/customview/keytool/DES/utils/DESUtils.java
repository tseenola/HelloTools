package com.customview.keytool.des.utils;

import com.customview.keytool.des.algorithm.IDES;

/**
 * Created by lenovo on 2017/4/10.
 * 描述：DESImpl 加密工具
 */

public class DESUtils {

    /**
     * DES 加密
     * @param pKey 密钥
     * @param pData 被加密数据
     * @param pIDES
     * @return 加密结果
     */
    public static byte[] encrypt(byte[] pKey, byte[] pData, IDES pIDES) throws Exception {
        return pIDES.encrypt(pKey,pData);
    }

    /**
     * DES 解密
     * @param pKey 密钥
     * @param pData 被解密数据
     * @param pIDES
     * @return 解密结果
     */
    public static byte[] decrypt(byte[] pKey, byte[] pData,IDES pIDES) throws Exception {
        return pIDES.decrypt(pKey,pData);
    }
}
