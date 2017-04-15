package com.customview.keytool.md5.algorithm;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lenovo on 2017/4/15.
 * 描述：
 */

public interface IMd5 {
    /**
     * 计算byte数组的md5
     * @param pData
     * @return
     * @throws NoSuchAlgorithmException
     */
    byte [] encryptMd5(byte [] pData) throws NoSuchAlgorithmException;

    /**
     * 计算文件的md5
     * @param pInputStream
     * @return
     * @throws NoSuchAlgorithmException
     */
    byte [] encryptMd5OfFile(InputStream pInputStream) throws NoSuchAlgorithmException, IOException;


}
