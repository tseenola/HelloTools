package com.customview.keytool.sha.algorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lenovo on 2017/4/15.
 * 描述：
 */

public class ShaImpl implements ISha{
    @Override
    public byte[] encryptSha(byte[] pDatas, ShaType pShaType) throws NoSuchAlgorithmException {
        MessageDigest lMessageDigest = MessageDigest.getInstance(pShaType.getShaType());
        lMessageDigest.update(pDatas);
        return lMessageDigest.digest();
    }
}
