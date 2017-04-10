package com.customview.keytool.des.algorithm;

/**
 * Created by lenovo on 2017/4/10.
 * 描述：
 */

public interface IDES {
    /**
     * DES 加密
     * @param pKey 密钥
     * @param pData 被加密数据
     * @return 加密结果
     */
    byte [] encrypt(byte pKey [] ,byte pData [])throws Exception;

    /**
     * DES 解密
     * @param pKey 密钥
     * @param pData 被解密数据
     * @return 解密结果
     */
    byte [] decrypt(byte pKey [] ,byte pData []) throws Exception;
}
