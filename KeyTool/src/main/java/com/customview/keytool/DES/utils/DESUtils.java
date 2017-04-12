package com.customview.keytool.des.utils;

import com.customview.keytool.des.algorithm.DesImpl;
import com.customview.keytool.des.algorithm.IDes;

/**
 * Created by lenovo on 2017/4/10.
 * 描述：DesImpl 加密工具
 */

public class DesUtils {

    /**
     * DES 加密
     * @param pKey 密钥
     * @param pData 被加密数据
     * @param pIDES DES 加解密算法实现者（已经有一个默认实现，{@link DesImpl}），
     *              如果有自己的特殊DES加解密算法，请继承{@link IDes}
     * @return 加密结果
     */
    public static byte[] encrypt(byte[] pKey, byte[] pData, IDes pIDES) throws Exception {
        return pIDES.encrypt(pKey,pData);
    }
    /**
     * DES 加密
     * @param pHexStrKey 16进制字符串表示的 密钥
     * @param pHexStrData 16进制字符串表示的 被加密数据
     * @param pIDES DES 加解密算法实现者（已经有一个默认实现，{@link DesImpl}），
     *              如果有自己的特殊DES加解密算法，请继承{@link IDes}
     * @return 加密结果
     */
    public static byte[] encrypt(String pHexStrKey, String pHexStrData, IDes pIDES) throws Exception {
        return pIDES.encrypt(pHexStrKey,pHexStrData);
    }

    /**
     * DES 解密
     * @param pKey 密钥
     * @param pData 被解密数据
     * @param pIDES DES 加解密算法实现者（已经有一个默认实现，{@link DesImpl}），
     *              如果有自己的特殊DES加解密算法，请继承{@link IDes}
     * @return 解密结果
     */
    public static byte[] decrypt(byte[] pKey, byte[] pData,IDes pIDES) throws Exception {
        return pIDES.decrypt(pKey,pData);
    }

    /**
     * DES 解密
     * @param pHexStrKey 16进制字符串表示的 密钥
     * @param pHexStrData 16进制字符串表示的 被解密数据
     * @param pIDES DES 加解密算法实现者（已经有一个默认实现，{@link DesImpl}），
     *              如果有自己的特殊DES加解密算法，请继承{@link IDes}
     * @return 解密结果
     */
    public static byte[] decrypt(String pHexStrKey, String pHexStrData,IDes pIDES) throws Exception {
        return pIDES.decrypt(pHexStrKey,pHexStrData);
    }
}
