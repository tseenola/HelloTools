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
     * @param pMasterKeyWriteTemplate
     * @return
     */
    public static boolean doMasterKeyWrite(int pMasterKeyIndex, String pMasterKeyAntidoteKey, String pMasterSecKey, MasterKeyWriteTemplate pMasterKeyWriteTemplate){
        return pMasterKeyWriteTemplate.doWriteMasterKeyByKEK(pMasterKeyIndex,
                ConvertUtils.hexStringToByte(pMasterKeyAntidoteKey),
                ConvertUtils.hexStringToByte(pMasterSecKey));
    }
}
