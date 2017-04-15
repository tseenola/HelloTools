package com.customview.keytool.hmac.algorithm;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by lenovo on 2017/4/15.
 * 描述：
 */

public class HMacImpl implements IHMac{

    @Override
    public byte[] encryptHMac(byte[] pDatas, byte[] pKeys, HMacType pHMacType) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKey lSecretKey = new SecretKeySpec(pKeys,pHMacType.getHmacType());
        Mac mac = Mac.getInstance(pHMacType.getHmacType());
        mac.init(lSecretKey);
        return mac.doFinal(pDatas);
    }
}
