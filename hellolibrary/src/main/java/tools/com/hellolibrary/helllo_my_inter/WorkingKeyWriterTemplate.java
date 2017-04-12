package tools.com.hellolibrary.helllo_my_inter;

/**
 * Created by lenovo on 2017/2/1.
 * 描述：
 */

/*public abstract class WorkingKeyWriterTemplate extends MaxqManagerHelper{
    protected int mMasterKeyIndex = 0;
    *//**
     * 写pin密钥
     * @return
     *//*
    public abstract boolean writePinKey(byte [] pPinDatas,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck);

    *//**
     * 写mac密钥
     * @return
     *//*
    public abstract boolean writeMacKey(byte pMacDatas [],int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck);

    *//**
     * 写磁道密钥
     * @return
     *//*
    public abstract boolean writeTrackKey(byte [] pTrackDatas,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck);


    protected boolean writeWorkingKey(byte [] pPinDatas,byte pMacDatas [] ,byte [] pTrackDatas,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck){
        return openMaxqManager()&&
                writePinKey(pPinDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)&&
                writeMacKey(pMacDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)&&
                //天下汇没有磁道密钥所以注释掉  writeTrackKey(pTrackDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)&&
                closeMaxqManager();
    }
}*/
