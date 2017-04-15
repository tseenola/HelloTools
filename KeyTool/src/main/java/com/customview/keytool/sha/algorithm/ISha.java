package com.customview.keytool.sha.algorithm;

import java.security.NoSuchAlgorithmException;

/**
 * Created by lenovo on 2017/4/15.
 * 描述：
 */

public interface ISha {
    /**
     * 计算sha
     * @param pDatas 计算sha的数据
     * @param pShaType 摘要长度
     * @return
     * @throws NoSuchAlgorithmException
     */
    byte [] encryptSha(byte [] pDatas, ShaType pShaType) throws NoSuchAlgorithmException;
}
