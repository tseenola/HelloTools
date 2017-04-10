package com.customview.writemasterkey;


import android.util.Log;

import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lenovo on 2017/1/31.
 * 描述：主密钥写入者
 */

public class MasterKeyWriter extends MasterKeyWriteTemplate {

    @Override
    public boolean clearAllMasterKeyByIndex(int pMasterKeyIndex) {
        if (mMaxqManager==null){
            initMaxqManager();
        }

        byte[] response = new byte[16];
        byte[] reslen = new byte[1];

        for (int i = 1; i <= 7; i++){
            int ret = mMaxqManager.deleteKey(i, pMasterKeyIndex, response, reslen);
        }
        return true;
    }

    @Override
    public boolean writeKEK(KeyUsage pKeyUsage, int KeyNo, int ParentKeyNo, byte[] KeyData, int KeyDataLen, byte[] ResponseData, byte[] ResLen) {
        if(mMaxqManager==null){
            initMaxqManager();
        }
        boolean succ = mMaxqManager.loadKey(pKeyUsage.getValue(),KeyNo,ParentKeyNo,KeyData,KeyDataLen,ResponseData,ResLen)==0;
        return succ;
    }


    @Override
    public boolean decryMasterKey(KeyUsage pKeyUsage,
                                  int KeyNo,
                                  Algorithm pAlgorithm,
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
        Log.i("vbvb","被解密数据："+ ConvertUtils.bytesToHexString(DecryptData));
        boolean succ = mMaxqManager.decryptData(pKeyUsage.getValue(), KeyNo,pAlgorithm.getValue(),StartValue,StartValueLen,PaddingChar,DecryptData,DecryptDataLen,ResponseData,ResLen)==0;
        Log.i("vbvb","decryptData ret:" + succ);
        Log.i("vbvb","解密结果："+ ConvertUtils.bytesToHexString(ResponseData));
        return succ;
    }

    @Override
    public boolean writeMasterKey(KeyUsage pKeyUsage, int pMasterKeyIndex, int ParentKeyNo, byte[] pMasterKeys, int pMasterKeysLength, byte[] ResponseData, byte[] ResLen) {
        if(mMaxqManager==null){
            initMaxqManager();
        }
        boolean succ = mMaxqManager.loadKey(pKeyUsage.getValue(), pMasterKeyIndex,ParentKeyNo, pMasterKeys, pMasterKeysLength,ResponseData,ResLen)==0;
        Log.i("vbvb","被写入主密钥明文："+ConvertUtils.bytesToHexString(pMasterKeys));
        Log.i("vbvb","主密钥写入结果："+succ);
        return succ;
    }
}
