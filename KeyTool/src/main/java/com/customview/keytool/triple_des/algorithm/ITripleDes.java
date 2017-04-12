package com.customview.keytool.triple_des.algorithm;

/**
 * Created by lenovo on 2017/4/11.
 * 描述：
 */

public interface ITripleDes{
    /**
     * 3DES 加密(密钥长度16个字节)
     * @param pKey 密钥
     * @param pData 被加密数据
     * @return 加密结果
     */
    byte [] encrypt_16(byte pKey [] ,byte pData [])throws Exception;

    /**
     * 3DES 加密(密钥长度16个字节)
     * @param pHexStrKey 16进制字符串表示的 密钥
     * @param pHexStrData 16进制字符串表示的 被加密数据
     * @return 加密结果
     */
    byte [] encrypt_16(String pHexStrKey ,String pHexStrData)throws Exception;

    /**
     * 3DES 解密(密钥长度16个字节)
     * @param pKey 密钥
     * @param pData 被解密数据
     * @return 解密结果
     */
    byte [] decrypt_16(byte pKey [] ,byte pData []) throws Exception;

    /**
     * 3DES 解密(密钥长度16个字节)
     * @param pHexStrKey 16进制字符串表示的 密钥
     * @param pHexStrData 16进制字符串表示的 被解密数据
     * @return 解密结果
     */
    byte [] decrypt_16(String pHexStrKey ,String pHexStrData) throws Exception;

    /**
     * 3DES 加密(密钥长度24个字节)
     * @param pKey 密钥
     * @param pData 被加密数据
     * @return 加密结果
     */
    byte [] encrypt_24(byte pKey [] ,byte pData [])throws Exception;

    /**
     * 3DES 加密(密钥长度24个字节)
     * @param pHexStrKey 16进制字符串表示的 密钥
     * @param pHexStrData 16进制字符串表示的 被加密数据
     * @return 加密结果
     */
    byte [] encrypt_24(String pHexStrKey ,String pHexStrData)throws Exception;

    /**
     * 3DES 解密(密钥长度24个字节)
     * @param pKey 密钥
     * @param pData 被解密数据
     * @return 解密结果
     */
    byte [] decrypt_24(byte pKey [] ,byte pData []) throws Exception;

    /**
     * 3DES 解密(密钥长度24个字节)
     * @param pHexStrKey 16进制字符串表示的 密钥
     * @param pHexStrData 16进制字符串表示的 被解密数据
     * @return 解密结果
     */
    byte [] decrypt_24(String pHexStrKey ,String pHexStrData) throws Exception;
}
