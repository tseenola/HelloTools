package com.urovo.calculatemac;

import com.customview.keytool.des.algorithm.DesImpl;
import com.customview.keytool.des.utils.DesUtils;
import com.urovo.calculatemac.utils.MacCalculaterUtils;

/**
 * Created by lenovo on 2017/4/12.
 * 描述：
 *              算法描述
 * ANSI X9.19 MAC算法
 *
 *    (1)      ANSI X9.19MAC算法只使用双倍长密钥。
 *    (2)      MAC数据先按8字节分组，表示为D0～Dn，如果Dn不足8字节时，尾部以字节00补齐。
 *    (3)      用MAC密钥左半部加密D0，加密结果与D1异或作为下一次的输入。
 *    (4)      将上一步的加密结果与下一分组异或，然后用MAC密钥左半部加密。
 *    (5)      直至所有分组结束。
 *    (6)      用MAC密钥右半部解密(5)的结果。
 *    (7)      用MAC密钥左半部加密(6)的结果。
 *    (8)      取(7)的结果的左半部作为MAC。
 */

public class MacCalculaterX9_19 implements IMacCalculater {

    private MacCalculaterX9_19(){}

    private static final MacCalculaterX9_19 sMacCalculaterX9_19 = new MacCalculaterX9_19();
    public static MacCalculaterX9_19 getInstance(){
        return sMacCalculaterX9_19;
    }

    @Override
    public byte[] getMac(int pMacKeyIndex, int pDataInLen, byte[] pNeedMacDatas) {
        return new byte[0];
    }

    @Override
    public byte[] getMac(byte[] pKeys, byte[] pNeedMacDatas) throws Exception {
        if (pKeys == null || pNeedMacDatas == null)
            return null;

        if (pKeys.length != 16) {
            throw new RuntimeException("秘钥长度错误.");
        }

        byte[] keyLeft = new byte[8];
        byte[] keyRight = new byte[8];
        System.arraycopy(pKeys, 0, keyLeft, 0, 8);
        System.arraycopy(pKeys, 8, keyRight, 0, 8);

        byte[] result99 = MacCalculaterUtils.getMac(keyLeft, pNeedMacDatas,MacCalculaterX9_9.getInstance());

        byte[] resultTemp = DesUtils.decrypt(keyRight, result99, DesImpl.getInstance());

        return DesUtils.encrypt(keyLeft, resultTemp, DesImpl.getInstance());
    }
}
