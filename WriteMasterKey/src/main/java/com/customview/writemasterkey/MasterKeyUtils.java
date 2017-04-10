package com.customview.writemasterkey;

import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lenovo on 2017/4/7.
 * 描述：
 */

public class MasterKeyUtils {

    /**
     * 执行主密钥写入芯片
     * @param pMasterKeyIndex 主密钥索引
     * @param pMasterKeyAntidoteKey 主密钥解密密钥
     * @param pMasterSecKey 主密钥
     * @param pMasterKeyWriteTemplate 主密钥具体写入类，执行具体的主密钥写入，目前已经提供了一个默认写入算法（com.customview.writemasterkey.MasterKeyWriter#MasterKeyWriter()）
     *                        如果有自己的写入算法，请实现接口（com.customview.writemasterkey.MasterKeyWriteTemplate）
     * @return
     */
    public static boolean doMasterKeyWrite(int pMasterKeyIndex, String pMasterKeyAntidoteKey, String pMasterSecKey, MasterKeyWriteTemplate pMasterKeyWriteTemplate){
        return pMasterKeyWriteTemplate.doWriteMasterKeyByKEK(pMasterKeyIndex,
                ConvertUtils.hexStringToByte(pMasterKeyAntidoteKey),
                ConvertUtils.hexStringToByte(pMasterSecKey));
    }
}
