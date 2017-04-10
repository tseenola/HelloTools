package com.customview.writeworkkey;

import android.util.Log;

import java.util.Arrays;

import tools.com.hellolibrary.helllo_my_inter.IUrovoSDK;
import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lenovo on 2017/2/1.
 * 描述：工作密钥写入者
 */

public class WorkingKeyWriter extends WorkingKeyWriterTemplate{


    /**
     *
     * @param pPinDatas pin密钥
     * @param pMacDatas mac密钥
     * @param pTrackDatas 磁道密钥
     * @param pMasterKeyIndex 主密钥索引
     * @param pCheckVal 校验值
     * @param pIsNeedCheck 是否校验
     * @return
     */
    public boolean doWriteWorkKey(byte [] pPinDatas,int pPiniKeyIndex,byte pMacDatas [] ,int pMacKeyIndex,byte [] pTrackDatas,int pTrackKeyIndex,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck){
        return new WorkingKeyWriter().writeWorkingKey(pPinDatas,pPiniKeyIndex,pMacDatas,pMacKeyIndex,pTrackDatas,pTrackKeyIndex,pMasterKeyIndex,pCheckVal,pIsNeedCheck);
    }

    @Override
    public boolean writePinKey(int pPiniKeyIndex,byte [] pPinDatas,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck) {
        boolean isSucc = Urovo_PciWriteWorkKey(KeyType._PINKEY,pPiniKeyIndex,pPinDatas.length,pPinDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)==0;
        return isSucc;
    }

    @Override
    public boolean writeMacKey(int pMacKeyIndex,byte pMacDatas [],int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck) {
        boolean isSucc = Urovo_PciWriteWorkKey(KeyType._MACKEY,pMacKeyIndex,pMacDatas.length,pMacDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)==0;
        return isSucc;
    }

    @Override
    public boolean writeTrackKey(int pTrackKeyIndex,byte [] pTrackDatas,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck) {
        boolean isSucc = Urovo_PciWriteWorkKey(KeyType._TLK,pTrackKeyIndex,pTrackDatas.length,pTrackDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)==0;
        return isSucc;
    }

    /**
     * 写工作密钥
     *
     * @param pKeyType     :密钥类型,
     * @param KeyNo      :密钥号 0-20
     * @param key_len     :密钥长度(一般十六个字节长)
     * @param key_data    :被写进去的密钥
     * @param masterKeyIndex     :为主密钥索引号,是通过这个索引对应的主密钥对key_data运算
     * @param sbcdMacbuff :检验值
     * @param pNeedCheck  :1要求校验，0不要校验 返回0成功，非0不成功
     */

    public int Urovo_PciWriteWorkKey(KeyType pKeyType, int KeyNo, int key_len, byte[] key_data, int masterKeyIndex, byte[] sbcdMacbuff, boolean pNeedCheck) {
        int iRet;
        byte[] reslen = new byte[1];
        byte[] dStartValue = new byte[8];

        byte[] response = new byte[16];
        byte[] sTemp = new byte[32 + 1];
        byte[] sbuf = new byte[33];
        int kt = 0;

        if (pKeyType == KeyType._TLK){
            kt = KeyType._MASTKEY.getValue();
        } else{
            kt =  pKeyType.getValue();
        }

        // 先用test ID写进去。
        for (int i = 1; i <= 7; i++) {
            mMaxqManager.deleteKey(i, Constants._PED_TESTKEY_ID, response, reslen);
        }
        iRet = mMaxqManager.loadKey(IUrovoSDK.KeyUsage._MACKEY, Constants._PED_TESTKEY_ID, masterKeyIndex, key_data, key_len, response, reslen);
        Log.i("vbvb","mMaxqManager.loadKey():" + "" + iRet);
        if (iRet != 0x00){
            return ResponseCode._PCI_MAXQ32550_ERROR;
        }

        Arrays.fill(sTemp, (byte) 0);
        Arrays.fill(sbuf, (byte) 0);

        // 对8个0做3des运算
        iRet = mMaxqManager.encryptData(IUrovoSDK.KeyUsage._MACKEY, Constants._PED_TESTKEY_ID, Algorithm._ECB, dStartValue, dStartValue.length, 0x00, sTemp, 8, sbuf, reslen);
        Log.i("vbvb","Urovo_PciDes():" + "" + iRet);
        Log.i("vbvb","des结果"+ ConvertUtils.bytesToHexString(sbuf));
        if (iRet != 0x00){
            return ResponseCode._PCI_MAXQ32550_ERROR;
        }

        if (pNeedCheck){
            if (comparabytes(sbcdMacbuff, sbuf, 4) != 0){
                return ResponseCode._OPER_VERIFY_ERROR;
            }
        }

        for (int i = 1; i <= 7; i++){
            iRet = mMaxqManager.deleteKey(i, KeyNo, response, reslen);
        }

        iRet = mMaxqManager.loadKey(kt, KeyNo, masterKeyIndex, key_data, key_len, response, reslen);
        return iRet;
    }

    public int comparabytes(byte[] temp1, byte[] temp2, int len) {
        for (int i = 0; i < len; i++) {
            if (temp1[i] != temp2[i]) {
                return -1;
            }
        }
        return 0;
    }
}
