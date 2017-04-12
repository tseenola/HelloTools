package com.customview.keytool.triple_des.utils;

import com.customview.keytool.triple_des.algorithm.ITripleDes;

/**
 * Created by lenovo on 2017/4/11.
 * 描述：3des加密工具类。
 */

public class TripleDesUtils {
    /**
     * DES 加密
     * @param pKey 密钥
     * @param pData 被加密数据
     * @param pITripleDes 3DES 加解密算法实现者（已经有一个默认实现，{@link com.customview.keytool.triple_des.algorithm.TripleDesImpl}），
     *              如果有自己的特殊3DES加解密算法，请继承{@link ITripleDes}
     * @return 加密结果
     */
    public static byte[] encrypt_16(byte[] pKey, byte[] pData, ITripleDes pITripleDes) throws Exception {
        return pITripleDes.encrypt_16(pKey,pData);
    }

    /**
     * DES 解密
     * @param pKey 密钥
     * @param pData 被解密数据
     * @param pITripleDes 3DES 加解密算法实现者（已经有一个默认实现，{@link com.customview.keytool.triple_des.algorithm.TripleDesImpl}），
     *              如果有自己的特殊3DES加解密算法，请继承{@link ITripleDes}
     * @return 解密结果
     */
    public static byte[] decrypt_16(byte[] pKey, byte[] pData, ITripleDes pITripleDes) throws Exception {
        return pITripleDes.decrypt_16(pKey,pData);
    }

    /**
     * DES 加密
     * @param pKey 密钥
     * @param pData 被加密数据
     * @param pITripleDes 3DES 加解密算法实现者（已经有一个默认实现，{@link com.customview.keytool.triple_des.algorithm.TripleDesImpl}），
     *              如果有自己的特殊3DES加解密算法，请继承{@link ITripleDes}
     * @return 加密结果
     */
    public static byte[] encrypt_24(byte[] pKey, byte[] pData, ITripleDes pITripleDes) throws Exception {
        return pITripleDes.encrypt_24(pKey,pData);
    }

    /**
     * DES 解密
     * @param pKey 密钥
     * @param pData 被解密数据
     * @param pITripleDes 3DES 加解密算法实现者（已经有一个默认实现，{@link com.customview.keytool.triple_des.algorithm.TripleDesImpl}），
     *              如果有自己的特殊3DES加解密算法，请继承{@link ITripleDes}
     * @return 解密结果
     */
    public static byte[] decrypt_24(byte[] pKey, byte[] pData, ITripleDes pITripleDes) throws Exception {
        return pITripleDes.decrypt_24(pKey,pData);
    }

}
