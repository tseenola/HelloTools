package com.customview.keytool.hmac.algorithm;

/**
 * Created by lenovo on 2017/4/15.
 * 描述：
 * HmacMD5   :摘要长度（128）；
 * HmacSHA1  :摘要长度（160）；
 * HmacSHA256:摘要长度（256）；
 * HmacSHA384:摘要长度（384）；
 * HamcSHA512:摘要长度（512）；
 */

public enum HMacType {
    HMAC_MD5("HmacMD5"),
    HMAC_SHA1("HmacSHA1"),
    HMAC_SHA256("HmacSHA256"),
    HMAC_SHA384("HmacSHA384"),
    HMAC_SHA512("HamcSHA512");
    private String mHmacType;
    HMacType(String pHMacType) {
        mHmacType = pHMacType;
    }

    public String getHmacType() {
        return mHmacType;
    }

    public void setHmacType(String pHmacType) {
        mHmacType = pHmacType;
    }
}
