package com.urovo.poscommon.models;

import android.device.MaxqManager;

/**
 * Created by lenovo on 2017/1/31.
 * 描述：
 */

public class MaxqManagerHelper {

    protected MaxqManager mMaxqManager;

    /**
     * 开启安全芯片
     * @return
     */
    protected boolean openMaxqManager() {
        int ret = 0;
        if (mMaxqManager == null) {
            mMaxqManager = new MaxqManager();
            ret = mMaxqManager.open();
        }
        return ret == 0;
    }

    /**
     * 关闭安全芯片
     * @return
     */
    protected boolean closeMaxqManager() {
        int ret = 0;
        if (mMaxqManager != null) {
            ret = mMaxqManager.close();
        }
        return ret == 0;
    }

    /**
     * 清除指定密钥索引中所有类型密钥
     * @param pKeyIndex 密钥索引
     * @return
     */
    protected boolean clearAllKeysByKeyIndex(int pKeyIndex){
        if (pKeyIndex<0 || pKeyIndex >20){
            throw new IllegalArgumentException("您传入的密钥索引超过了安全芯片密钥索引范围，请传入0-20之间的密钥索引。详情请查看sdk文档");
        }

        byte[] response = new byte[16];
        byte[] reslen = new byte[1];

        for(KeyUsage keyUsage:KeyUsage.values()){
            int ret = mMaxqManager.deleteKey(keyUsage.getValue(), pKeyIndex, response, reslen);
        }
        return true;
    }

    /**
     * 向安全芯片写入密钥
     * @param pKeyUsage 密钥作用
     * @param pKeyIndex 密钥索引
     * @param pMasterKeyIndex 主密钥索引
     * @param pKeyDatas 密钥byte数组
     * @return 写入是否成功
     */
    protected boolean loadKey(KeyUsage pKeyUsage, int pKeyIndex, int pMasterKeyIndex, byte pKeyDatas []){
        if (pKeyIndex<0 || pKeyIndex >20 ||pMasterKeyIndex <0 || pMasterKeyIndex  >20){
            throw new IllegalArgumentException("您传入的密钥索引超过了安全芯片密钥索引范围，请传入0-20之间的密钥索引。详情请查看sdk文档");
        }

        byte[] response = new byte[16];
        byte[] reslen = new byte[1];

        int iRet = mMaxqManager.loadKey(pKeyUsage.getValue(), pKeyIndex, pMasterKeyIndex, pKeyDatas, pKeyDatas.length, response, reslen);
        return iRet == 0;
    }


    /**
     * 调用安全芯片进行数据加密
     * @param pKeyUsage 密钥作用
     * @param pKeyIndex 密钥索引
     * @param pAlgorithm 算法类型
     * @param pEncryptData 待加密数据
     * @return
     */
    protected byte [] encryptData(KeyUsage pKeyUsage, int pKeyIndex, Algorithm pAlgorithm, byte[] pEncryptData){
        if (pKeyIndex<0 || pKeyIndex >20){
            throw new IllegalArgumentException("您传入的密钥索引超过了安全芯片密钥索引范围，请传入0-20之间的密钥索引。详情请查看sdk文档");
        }

        byte[] dStartValue = new byte[8];
        byte[] response = new byte[16];
        byte[] reslen = new byte[1];
        byte[] responseData = new byte[pEncryptData.length];

        int ret = mMaxqManager.encryptData(pKeyUsage.getValue(), pKeyIndex, pAlgorithm.getValue(), dStartValue, dStartValue.length, 0x00, pEncryptData, 8, responseData, reslen);
        if (ret!=0){
            throw new IllegalStateException("数据加密发生失败!");
        }
        return responseData;
    }

}
