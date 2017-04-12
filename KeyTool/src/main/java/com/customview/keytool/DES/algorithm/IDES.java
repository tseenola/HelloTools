package com.customview.keytool.des.algorithm;

/**
 * Created by lenovo on 2017/4/10.
 * 描述：
 */

public interface IDes {
    /**
     * DES 加密
     * @param pKey 密钥
     * @param pData 被加密数据
     * @return 加密结果
     */
    byte [] encrypt(byte pKey [] ,byte pData [])throws Exception;

    /**
     * DES 加密
     * @param pHexStrKey 16进制字符串表示的 密钥
     * @param pHexStrData 16进制字符串表示的 被加密数据
     * @return 加密结果
     */
    byte [] encrypt(String pHexStrKey ,String pHexStrData)throws Exception;

    /**
     * DES 解密
     * @param pKey 密钥
     * @param pData 被解密数据
     * @return 解密结果
     */
    byte [] decrypt(byte pKey [] ,byte pData []) throws Exception;

    /**
     * DES 解密
     * @param pHexStrKey 16进制字符串表示的 密钥
     * @param pHexStrData 16进制字符串表示的 被解密数据
     * @return 解密结果
     */
    byte [] decrypt(String pHexStrKey ,String pHexStrData) throws Exception;
}
