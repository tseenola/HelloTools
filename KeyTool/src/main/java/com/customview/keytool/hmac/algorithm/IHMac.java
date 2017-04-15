package com.customview.keytool.hmac.algorithm;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lenovo on 2017/4/15.
 * 描述：
 */

public interface IHMac {
    byte [] encryptHMac(byte [] pDatas,byte [] pKeys,HMacType pHMacType) throws NoSuchAlgorithmException, InvalidKeyException;
}
