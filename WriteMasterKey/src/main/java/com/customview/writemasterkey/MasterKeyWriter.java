package com.customview.writemasterkey;


import android.util.Log;

import com.customview.keytool.triple_des.algorithm.TripleDesImpl;
import com.customview.keytool.triple_des.utils.TripleDesUtils;
import com.urovo.poscommon.models.KeyUsage;

import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lenovo on 2017/1/31.
 * 描述：主密钥写入者
 */

public class MasterKeyWriter extends MasterKeyWriteTemplate {
    private MasterKeyWriter(){}

    private static final MasterKeyWriter mMasterKeyWriter = new MasterKeyWriter();
    public static MasterKeyWriter getInstance(){
        return mMasterKeyWriter;
    }
    @Override
    public boolean clearAllMasterKeyByIndex(int pMasterKeyIndex) {
        if (mMaxqManager==null){
            openMaxqManager();
        }

        byte[] response = new byte[16];
        byte[] reslen = new byte[1];

        for (int i = 1; i <= 7; i++){
            int ret = mMaxqManager.deleteKey(i, pMasterKeyIndex, response, reslen);
        }
        return true;
    }

    @Override
    public byte [] decryMasterKey(byte[] pMasterKeyAntidoteKey, byte[] pMasterKeyData) {
        byte [] decryptedMasterKey = null;
        try {
            decryptedMasterKey = TripleDesUtils.decrypt_16(pMasterKeyAntidoteKey,pMasterKeyData, TripleDesImpl.getInstance());
        } catch (Exception pE) {
            pE.printStackTrace();
        }
        return decryptedMasterKey;
    }

    @Override
    public boolean writeMasterKey(KeyUsage pKeyUsage, int pMasterKeyIndex, int ParentKeyNo, byte[] pMasterKeys, int pMasterKeysLength, byte[] ResponseData, byte[] ResLen) {
        if(mMaxqManager==null){
            openMaxqManager();
        }
        boolean succ = mMaxqManager.loadKey(pKeyUsage.getValue(), pMasterKeyIndex,ParentKeyNo, pMasterKeys, pMasterKeysLength,ResponseData,ResLen)==0;
        Log.i("vbvb","被写入主密钥明文："+ConvertUtils.bytesToHexString(pMasterKeys));
        return succ;
    }
}
