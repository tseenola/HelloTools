package core;

import tools.com.hellolibrary.helllo_my_inter.MasterKeyWriteTemplate;

/**
 * Created by lenovo on 2017/1/31.
 * 描述：主密钥写入者
 */

public class MasterKeyWriter extends MasterKeyWriteTemplate {

    private MasterKeyWriter(){};


    public static boolean actionMasterKeyWrite(int masterKeyIndex,byte[] kekData,byte[] masterSecData){
        return new MasterKeyWriter().doWriteMasterKeyByKEK(masterKeyIndex,kekData,masterSecData);
    }

    @Override
    public boolean clearAllMasterKeyByIndex(int masterKeyIndex) {
        if (mMaxqManager==null){
            initMaxqManager();
        }

        byte[] response = new byte[16];
        byte[] reslen = new byte[1];

        for (int i = 1; i <= 7; i++){
            mMaxqManager.deleteKey(i, masterKeyIndex, response, reslen);
        }
        return true;
    }

    @Override
    public boolean writeKEK(int KeyUsage, int KeyNo, int ParentKeyNo, byte[] KeyData, int KeyDataLen, byte[] ResponseData, byte[] ResLen) {
        if(mMaxqManager==null){
            initMaxqManager();
        }
        boolean succ = mMaxqManager.loadKey(KeyUsage,KeyNo,ParentKeyNo,KeyData,KeyDataLen,ResponseData,ResLen)==0;
        return succ;
    }


    @Override
    public boolean decryMasterKey(int KeyUsage,
                                  int KeyNo,
                                  int Algorithm,
                                  byte[] StartValue,
                                  int StartValueLen,
                                  int PaddingChar,
                                  byte[] DecryptData,
                                  int DecryptDataLen,
                                  byte[] ResponseData,
                                  byte[] ResLen) {
        if(mMaxqManager==null){
            initMaxqManager();
        }
        boolean succ = mMaxqManager.decryptData(KeyUsage, KeyNo,Algorithm,StartValue,StartValueLen,PaddingChar,DecryptData,DecryptDataLen,ResponseData,ResLen)==0;
        return succ;
    }

    @Override
    public boolean writeMasterKey(int KeyUsage, int KeyNo, int ParentKeyNo, byte[] KeyData, int KeyDataLen, byte[] ResponseData, byte[] ResLen) {
        if(mMaxqManager==null){
            initMaxqManager();
        }
        boolean succ = mMaxqManager.loadKey(KeyUsage,KeyNo,ParentKeyNo,KeyData,KeyDataLen,ResponseData,ResLen)==0;
        return succ;
    }


    @Override
    public boolean closeMaxqManager() {
        int ret = 0;
        if(mMaxqManager!=null){
            ret = mMaxqManager.close();
        }
        return ret ==0;
    }
}
