package com.customview.writeworkkey;

import tools.com.hellolibrary.helllo_my_inter.MaxqManagerHelper;

/**
 * Created by lenovo on 2017/2/1.
 * 描述：
 */

public abstract class WorkingKeyWriterTemplate extends MaxqManagerHelper {
    protected int mMasterKeyIndex = 0;
    /**
     * 写pin密钥
     * @return
     */
    public abstract boolean writePinKey(int pPiniKeyIndex,byte [] pPinDatas,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck);

    /**
     * 写mac密钥
     * @return
     */
    public abstract boolean writeMacKey(int pMacKeyIndex,byte pMacDatas [],int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck);

    /**
     * 写磁道密钥
     * @return
     */
    public abstract boolean writeTrackKey(int pTrackKeyIndex,byte [] pTrackDatas,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck);


    protected boolean writeWorkingKey(byte [] pPinDatas,int pPiniKeyIndex,byte pMacDatas [] ,int pMacKeyIndex,byte [] pTrackDatas,int pTrackKeyIndex,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck){
        return initMaxqManager()&&
                writePinKey(pPiniKeyIndex,pPinDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)&&
                writeMacKey(pMacKeyIndex,pMacDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)&&
                writeTrackKey(pTrackKeyIndex,pTrackDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)&& //天下汇没有磁道密钥
                closeMaxqManager();
    }
}
