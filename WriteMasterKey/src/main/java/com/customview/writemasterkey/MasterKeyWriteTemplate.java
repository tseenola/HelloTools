package com.customview.writemasterkey;

import com.urovo.poscommon.models.KeyUsage;
import com.urovo.poscommon.models.MaxqManagerHelper;

/**
 * Created by lenovo on 2017/1/31.
 * 描述：写入主密钥模板（模板方法模式）
 * 1.解密主密钥
 * 2.
 * 3.写入主密钥
 */

public abstract class MasterKeyWriteTemplate extends MaxqManagerHelper {
    public static final int BE_USED_TO_LOAD_PARENT_KEY = 0;

    /**
     * 清除安全芯片中指定的密钥索引下所有主密钥
     * @param pMasterKeyIndex
     * @return
     */
    public abstract boolean clearAllMasterKeyByIndex(int pMasterKeyIndex);


    /**
     * 使用主密钥的密钥对主密钥密文进行解密
     * @param pMasterKeyAntidoteKey
     * @param pMasterKeyData
     * @return
     */
    public abstract byte [] decryMasterKey(byte pMasterKeyAntidoteKey [] , byte pMasterKeyData []);

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
     * 1.初始化安全芯片 openMaxqManager()
     * 2.清空芯片中的主密钥 clearAllMasterKeyByIndex(pMasterKeyIndex)
     * 3.使用主密钥的密钥对主密钥密文进行解密 decryMasterKey(pMasterKeyKey,pMasterSecKey)
     * 4.向芯片中写入主密钥明文 writeMasterKey（,,,,,,,,）
     * 5.关闭芯片释放资源 closeMaxqManager()
     * @param pMasterKeyIndex 主密钥索引
     * @param pMasterKeyAntidoteKey 对主密钥的密钥
     * @param pMasterSecKey 主密钥密文
     * @return 返回是否写入主密钥成功
     */
    public boolean doWriteMasterKeyByAntidoteKey(int pMasterKeyIndex, byte[] pMasterKeyAntidoteKey, byte[] pMasterSecKey){
        byte[] ResponseData = new byte[pMasterKeyAntidoteKey.length];
        byte[] ResLen = new byte[1];

        boolean initRet = openMaxqManager();//初始化安全芯片
        boolean clearRet = clearAllMasterKeyByIndex(pMasterKeyIndex);//清除指定密钥索引所有主密钥
        byte decryptdMasterKey [] = decryMasterKey(pMasterKeyAntidoteKey,pMasterSecKey);//对主密钥密文解密
        boolean decryptRet = decryptdMasterKey!=null;
        boolean writeRet = writeMasterKey(KeyUsage.MASTER_KEY,pMasterKeyIndex, BE_USED_TO_LOAD_PARENT_KEY,decryptdMasterKey,decryptdMasterKey.length,ResponseData,ResLen);//写入主密钥明文到安全芯片
        boolean closeRet = closeMaxqManager();

        return initRet && clearRet && decryptRet && writeRet && closeRet;
    }

}
