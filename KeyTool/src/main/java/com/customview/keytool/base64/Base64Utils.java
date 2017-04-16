package com.customview.keytool.base64;

import org.apache.commons.net.util.Base64;

/**
 * Created by lenovo on 2017/4/15.
 * 描述：
 */

public class Base64Utils {
    public static String encrypt(byte [] pDatas){
        return Base64.encodeBase64String(pDatas);
    }

    public static byte[] decode(String pBase64Str){
        return Base64.decodeBase64(pBase64Str);
    }
}
