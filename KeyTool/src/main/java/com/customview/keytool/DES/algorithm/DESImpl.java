package com.customview.keytool.des.algorithm;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by lenovo on 2017/4/10.
 * 描述：DES 加密默认实现
 */

public class DESImpl implements IDES{


    @Override
    public byte[] encrypt(byte[] pKey, byte[] pData)throws Exception {
        checkParams(pKey,pData);
        SecretKeySpec secretKey = new SecretKeySpec(pKey, "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte result [] = cipher.doFinal(pData);
        return result;
    }

    @Override
    public byte[] decrypt(byte[] pKey, byte[] pData) throws Exception{
        checkParams(pKey,pData);
        SecretKeySpec secretKey = new SecretKeySpec(pKey, "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte result [] = cipher.doFinal(pData);
        return result;
    }

    /**
     * 检查传入的DES参数是否正确
     * @param pKey
     * @param pData
     */
    private void checkParams(byte[] pKey, byte[] pData){
        if (pKey.length%8 != 0){
            throw new IllegalArgumentException("密钥长度必须为8的倍数");
        }

        if (pKey.length%8 != 0){
            throw new IllegalArgumentException("被加密数据长度必须为8的倍数");
        }
    }
}
