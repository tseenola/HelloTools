package com.customview.writemasterkey;

/**
 * Created by lenovo on 2017/1/31.
 * 描述：写入主密钥模板（模板方法模式）
 * 1.解密主密钥
 * 2.
 * 3.写入主密钥
 */

public abstract class MasterKeyWriteTemplate extends MaxqManagerHelper{
    public static final int BE_USED_TO_LOAD_PARENT_KEY = 0;

    /**
     * 清除安全芯片中指定的密钥索引下所有主密钥
     * @param pMasterKeyIndex
     * @return
     */
    public abstract boolean clearAllMasterKeyByIndex(int pMasterKeyIndex);

    /**
     * 写入主密钥解密密钥明文到安全芯片
     * @param pKeyUsage
     * @param KeyNo
     * @param ParentKeyNo
     * @param KeyData
     * @param KeyDataLen
     * @param ResponseData
     * @param ResLen
     * @return
     */
    public abstract boolean writeKEK(KeyUsage pKeyUsage,
                                     int KeyNo,
                                     int ParentKeyNo,
                                     byte[] KeyData,
                                     int KeyDataLen,
                                     byte[] ResponseData,
                                     byte[] ResLen);

    /**
     * 对主密钥密文解密
     * @param pKeyUsage
     * @param KeyNo
     * @param pAlgorithm
     * @param StartValue
     * @param StartValueLen
     * @param PaddingChar
     * @param DecryptData
     * @param DecryptDataLen
     * @param ResponseData
     * @param ResLen
     * @return
     */
    public abstract boolean decryMasterKey(KeyUsage pKeyUsage,
                                           int KeyNo,
                                           Algorithm pAlgorithm,
                                           byte[] StartValue,
                                           int StartValueLen,
                                           int PaddingChar,
                                           byte[] DecryptData,
                                           int DecryptDataLen,
                                           byte[] ResponseData,
                                           byte[] ResLen);
    /**
     * 写入主密钥明文到安全芯片
     * @return
     */
    public abstract boolean writeMasterKey(KeyUsage pKeyUsage,
                                           int pMasterKeyIndex,
                                           int ParentKeyNo,
                                           byte[] pMasterKeys,
                                           int pMasterKeysLength,
                                           byte[] ResponseData,
                                           byte[] ResLen);

    /**
     * 写入主密钥
     */
    public boolean doWriteMasterKeyByKEK(int pMasterKeyIndex, byte[] kekData, byte[] masterSecData){
        byte[] ResponseData = new byte[kekData.length];
        byte[] ResLen = new byte[1];
        byte[] DecryResponseData = new byte[16];
        byte[] DecryResLen = new byte[1];

        byte[] StartValueLen = new byte[8];

        return initMaxqManager()&&//初始化安全芯片

               clearAllMasterKeyByIndex(pMasterKeyIndex)&&//清除指定密钥索引所有主密钥

               writeKEK(KeyUsage.MASTER_KEY,pMasterKeyIndex, BE_USED_TO_LOAD_PARENT_KEY,kekData,kekData.length,ResponseData,ResLen)&&//写入主密钥解密密钥明文到安全芯片

               decryMasterKey(KeyUsage.MASTER_KEY,pMasterKeyIndex,Algorithm.ECB,StartValueLen,StartValueLen.length,0x00,masterSecData,masterSecData.length,DecryResponseData,DecryResLen)&&//对主密钥密文解密

               clearAllMasterKeyByIndex(pMasterKeyIndex)&&//清除指定密钥索引所有主密钥

               writeMasterKey(KeyUsage.MASTER_KEY,pMasterKeyIndex, BE_USED_TO_LOAD_PARENT_KEY,DecryResponseData,DecryResponseData.length,ResponseData,ResLen)&&//写入主密钥明文到安全芯片

               closeMaxqManager();
    }


}
