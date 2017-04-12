package com.customview.writeworkkey;

import android.util.Log;

import com.urovo.poscommon.models.Algorithm;
import com.urovo.poscommon.models.KeyUsage;

import java.util.Arrays;

import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lenovo on 2017/2/1.
 * 描述：工作密钥写入者
 */

public class WorkingKeyWriter extends WorkingKeyWriterTemplate{
    public static final int _PED_TESTKEY_ID = 19;//一共有20组密钥，这个用于测试使用
    private WorkingKeyWriter(){}

    private static final WorkingKeyWriter mWorkingKeyWriter = new WorkingKeyWriter();
    public static WorkingKeyWriter getInstance(){
        return mWorkingKeyWriter;
    }

    @Override
    public boolean writePinKey(int pPiniKeyIndex,byte [] pPinDatas,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck) {
        boolean isSucc = Urovo_PciWriteWorkKey(KeyUsage.PIN_KEY,pPiniKeyIndex,pPinDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)==0;
        return isSucc;
    }

    @Override
    public boolean writeMacKey(int pMacKeyIndex,byte pMacDatas [],int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck) {
        boolean isSucc = Urovo_PciWriteWorkKey(KeyUsage.MAC_KEY,pMacKeyIndex,pMacDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)==0;
        return isSucc;
    }

    @Override
    public boolean writeTrackKey(int pTrackKeyIndex,byte [] pTrackDatas,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck) {
        boolean isSucc = Urovo_PciWriteWorkKey(KeyUsage.TRACK_KEY,pTrackKeyIndex,pTrackDatas,pMasterKeyIndex,pCheckVal,pIsNeedCheck)==0;
        return isSucc;
    }

    /**
     * 写工作密钥具体实现
     *
     * @param pKeyUsage     :密钥类型,
     * @param pKeyIndex      :密钥号 0-20
     * @param pKeyDatas    :被写进去的密钥
     * @param pMasterKeyIndex     :为主密钥索引号,是通过这个索引对应的主密钥对key_data运算
     * @param pCheckVal :检验值
     * @param pNeedCheck  :1要求校验，0不要校验 返回0成功，非0不成功
     * @return
     */

    public int Urovo_PciWriteWorkKey(KeyUsage pKeyUsage, int pKeyIndex, byte[] pKeyDatas, int pMasterKeyIndex, byte[] pCheckVal, boolean pNeedCheck) {
        int iRet;
        byte[] reslen = new byte[1];
        byte[] dStartValue = new byte[8];

        byte[] response = new byte[16];
        byte[] sTemp = new byte[32 + 1];
        byte[] sbuf = new byte[33];

        // 先用test ID写进去。

        clearAllKeysByKeyIndex(_PED_TESTKEY_ID);

        loadKey(KeyUsage.MAC_KEY,_PED_TESTKEY_ID, pMasterKeyIndex, pKeyDatas);

        Arrays.fill(sTemp, (byte) 0);
        Arrays.fill(sbuf, (byte) 0);

        // 对8个0做3des运算
        byte encrypedResult [] = encryptData(KeyUsage.MAC_KEY, _PED_TESTKEY_ID, Algorithm.ECB, sTemp);

        Log.i("vbvb","des结果"+ pKeyUsage.getValue() + ":"+ConvertUtils.bytesToHexString(encrypedResult));

        if (pNeedCheck){
            if (comparabytes(pCheckVal, encrypedResult, 4) != 0){
                return ResponseCode._OPER_VERIFY_ERROR;
            }
        }

        clearAllKeysByKeyIndex(_PED_TESTKEY_ID);

        loadKey(pKeyUsage,pKeyIndex, pMasterKeyIndex, pKeyDatas);

        return 0;
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
