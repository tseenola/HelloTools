package com.customview.keytool.sha.algorithm;

/**
 * Created by lenovo on 2017/4/15.
 * 描述：sha算法类型
 *  SHA-1   摘要长度160
 *  SHA-256 摘要长度256
 *  SHA-384 摘要长度384
 *  SHA-512 摘要长度512
 */

public enum ShaType {
    SHA_160("SHA-1"),
    SHA_256("SHA-256"),
    SHA_384("SHA-384"),
    SHA_512("SHA-512");

    String mShaType;
    ShaType(String pShaType) {
        mShaType = pShaType;
    }

    public String getShaType() {
        return mShaType;
    }

    public void setShaType(String pShaType) {
        mShaType = pShaType;
    }
}
