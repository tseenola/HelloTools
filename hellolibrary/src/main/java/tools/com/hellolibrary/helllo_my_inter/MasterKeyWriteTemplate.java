package tools.com.hellolibrary.helllo_my_inter;

/**
 * Created by lenovo on 2017/1/31.
 * 描述：写入主密钥模板
 * 1.解密主密钥
 * 2.
 * 3.写入主密钥
 */

public abstract class  MasterKeyWriteTemplate extends MaxqManagerHelper{


    /**
     * 清除安全芯片中指定的密钥索引下所有主密钥
     * @param masterKeyIndex
     * @return
     */
    public abstract boolean clearAllMasterKeyByIndex(int masterKeyIndex);

    /**
     * 写入主密钥解密密钥明文到安全芯片
     */
    public abstract boolean writeKEK(int KeyUsage,
                                     int KeyNo,
                                     int ParentKeyNo,
                                     byte[] KeyData,
                                     int KeyDataLen,
                                     byte[] ResponseData,
                                     byte[] ResLen);
    /**
     * 对主密钥密文解密
     */

    public abstract boolean decryMasterKey(int KeyUsage,
                                           int KeyNo,
                                           int Algorithm,
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
    public abstract boolean writeMasterKey(int KeyUsage,
                                           int KeyNo,
                                           int ParentKeyNo,
                                           byte[] KeyData,
                                           int KeyDataLen,
                                           byte[] ResponseData,
                                           byte[] ResLen);

    public abstract boolean closeMaxqManager();
    /**
     * 写入主密钥
     * @
     * @
     */
    public boolean writeMasterKeyByKEK(int masterKeyIndex,byte[] kekData,byte[] masterSecData){
        byte[] ResponseData = new byte[kekData.length];
        byte[] ResLen = new byte[1];
        byte[] DecryResponseData = new byte[16];
        byte[] DecryResLen = new byte[1];

        byte[] StartValueLen = new byte[8];

        return initMaxqManager()&&//初始化安全芯片
                clearAllMasterKeyByIndex(masterKeyIndex)&&//清除指定密钥索引所有主密钥
                writeKEK(KeyUsage._MASTKEY,masterKeyIndex,ParentKeyNo,kekData,kekData.length,ResponseData,ResLen)&&//写入主密钥解密密钥明文到安全芯片
                decryMasterKey(KeyUsage._MASTKEY,masterKeyIndex,Algorithm._ECB,StartValueLen,StartValueLen.length,0x00,masterSecData,masterSecData.length,DecryResponseData,DecryResLen)&&//对主密钥密文解密
                clearAllMasterKeyByIndex(masterKeyIndex)&&//清除指定密钥索引所有主密钥
                writeMasterKey(KeyUsage._MASTKEY,masterKeyIndex,ParentKeyNo,DecryResponseData,DecryResponseData.length,ResponseData,ResLen);//写入主密钥明文到安全芯片
    }


}
