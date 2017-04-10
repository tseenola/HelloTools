package com.customview.writeworkkey;

/**
 * Created by lenovo on 2017/4/10.
 * 描述：写入工作密钥的封装
 */

public class WorkKeyWriteUtils {
    /**
     *
     * @param pPinDatas pin 密钥
     * @param pPiniKeyIndex pin 密钥索引
     * @param pMacDatas mac 密钥
     * @param pMacKeyIndex mac 密钥索引
     * @param pTrackDatas 密钥
     * @param pTrackKeyIndex 磁道 密钥索引
     * @param pMasterKeyIndex 主 密钥索引
     * @param pCheckVal 校验
     * @param pIsNeedCheck 是否校验
     * @param pWorkingKeyWriterTemplate 工作密钥具体写入类，执行具体的工作密钥写入，目前已经提供了一个默认写入算法 {@link WorkingKeyWriter}
     *                        如果有自己的特殊写入算法，请实现接口（{@link WorkingKeyWriterTemplate}）
     * @return 写入是否成功
     */
    public static boolean doWriteWorkKey(byte [] pPinDatas,int pPiniKeyIndex,byte pMacDatas [] ,int pMacKeyIndex,byte [] pTrackDatas,int pTrackKeyIndex,int pMasterKeyIndex,byte[] pCheckVal,boolean pIsNeedCheck,WorkingKeyWriterTemplate pWorkingKeyWriterTemplate){
        return pWorkingKeyWriterTemplate.writeWorkingKey(pPinDatas,pPiniKeyIndex,pMacDatas,pMacKeyIndex,pTrackDatas,pTrackKeyIndex,pMasterKeyIndex,pCheckVal,pIsNeedCheck);
    }
}
