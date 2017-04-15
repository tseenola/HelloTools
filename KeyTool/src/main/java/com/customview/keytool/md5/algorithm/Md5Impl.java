package com.customview.keytool.md5.algorithm;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lenovo on 2017/4/15.
 * 描述：
 */

public class Md5Impl implements IMd5{

    @Override
    public byte[] encryptMd5(byte[] pData) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(pData);
        return md5.digest();
    }

    @Override
    public byte[] encryptMd5OfFile(InputStream pInputStream) throws NoSuchAlgorithmException, IOException {
        DigestInputStream lDigestIs = new DigestInputStream(pInputStream,MessageDigest.getInstance("MD5"));
        byte buffer []= new byte[1024];
        int lRead = lDigestIs.read(buffer,0,1024);
        while (lRead!=-1){
            lRead = lDigestIs.read(buffer,0,1024);
        }
        MessageDigest lMessageDigest = lDigestIs.getMessageDigest();
        return lMessageDigest.digest();
    }
}
