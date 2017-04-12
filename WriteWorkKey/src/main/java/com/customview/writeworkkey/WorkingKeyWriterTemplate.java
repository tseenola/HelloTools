package com.customview.writeworkkey;


import com.urovo.poscommon.models.MaxqManagerHelper;

/**
 * Created by lenovo on 2017/2/1.
 * 描述：
 */

public abstract class WorkingKeyWriterTemplate extends MaxqManagerHelper {

    /**
     * 写pin密钥
     * @param pPiniKeyIndex pin密钥索引
     * @param pPinDatas pin密钥明文
     * @param pMasterKeyIndex 主密钥索引
     * @param pCheckVal 校验值
     * @param pIsNeedCheck 是否需要校验
     * @return 写入结果
     */
    public abstract boolean writePinKey(int pPiniKeyIndex,byte [] pPinDatas,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck);


    /**
     * 写mac密钥
     * @param pMacKeyIndex mac 密钥索引
     * @param pMacDatas mac 密钥明文
     * @param pMasterKeyIndex 主密钥索引
     * @param pCheckVal 校验值
     * @param pIsNeedCheck 是否需要校验
     * @return 写入结果
     */
    public abstract boolean writeMacKey(int pMacKeyIndex,byte pMacDatas [],int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck);


    /**
     * 写磁道密钥
     * @param pTrackKeyIndex 磁道 密钥索引
     * @param pTrackDatas 磁道 密钥明文
     * @param pMasterKeyIndex  主密钥索引
     * @param pCheckVal 校验值
     * @param pIsNeedCheck 是否需要校验
     * @return 写入结果
     */
    public abstract boolean writeTrackKey(int pTrackKeyIndex,byte [] pTrackDatas,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck);

    /**
     *
     * @param pPinDatas pin密钥明文
     * @param pPiniKeyIndex pin密钥索引
     * @param pMacDatas mac 密钥明文
     * @param pMacKeyIndex mac 密钥索引
     * @param pTrackDatas 磁道 密钥明文
     * @param pTrackKeyIndex 磁道 密钥索引
     * @param pMasterKeyIndex 主密钥索引
     * @param pCheckVal  校验值
     * @param pIsNeedCheck 是否需要校验
     * @return 工作密钥写入结果
     */
    protected boolean writeWorkingKey(byte [] pPinDatas,int pPiniKeyIndex,byte pMacDatas [] ,int pMacKeyIndex,byte [] pTrackDatas,int pTrackKeyIndex,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck){
        return openMaxqManager()&&
                writePinKey(pPiniKeyIndex,pPinDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)&&
                writeMacKey(pMacKeyIndex,pMacDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)&&
                //writeTrackKey(pTrackKeyIndex,pTrackDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)&& //天下汇没有磁道密钥
                closeMaxqManager();
    }


}
