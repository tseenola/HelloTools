package com.urovo.calculatemac;

import com.customview.keytool.des.algorithm.DesImpl;
import com.customview.keytool.des.utils.DesUtils;
import com.urovo.poscommon.models.KeyType;

import java.util.Arrays;

import static com.urovo.poscommon.utils.Ped.Urovo_PciDes;

/**
 * Created by lenovo on 2017/4/12.
 * 描述：X9.9MAC算法
 * 算法描述：
 * (1) ANSI X9.9MAC算法只使用单倍长密钥。
 * (2) MAC数据先按8字节分组，表示为D0～Dn，如果Dn不足8字节时，尾部以字节00补齐。
 * (3) 用MAC密钥加密D0，加密结果与D1异或作为下一次的输入。
 * (4) 将上一步的加密结果与下一分组异或，然后再用MAC密钥加密。
 * (5) 直至所有分组结束，取最后结果的左半部作为MAC。
 *
 */
public class MacCalculaterX9_9 implements IMacCalculater {
    private MacCalculaterX9_9(){}

    private static final MacCalculaterX9_9 sMacCalculaterX9_9 = new MacCalculaterX9_9();
    public static MacCalculaterX9_9 getInstance(){
        return sMacCalculaterX9_9;
    }
    /**
     * ANSI X9.9MAC算法（硬加密）
     * @param pMacKeyIndex mac密钥索引
     * @param pDataInLen mac数据长度
     * @param pNeedMacDatas 计算mac的数据
     * @return mac结果
     */
    @Override
    public byte[] getMac(int pMacKeyIndex, int pDataInLen, byte[] pNeedMacDatas) {
        byte[] buf = new byte[17];
        byte[] tmpbuf = new byte[17];
        byte [] macOut = new byte[8];
        int i = 0;
        int l = 0;
        int k = 0 ;
        int iRet = 0;

        byte[] inbuf = new byte[pDataInLen + 8];
        byte[] Macbuf = new byte[9];

        Arrays.fill(buf, (byte) 0x00);

        System.arraycopy(pNeedMacDatas, 0, inbuf, 0, pDataInLen);

        if (pDataInLen % 8 != 0){
            l = pDataInLen / 8 + 1;
        } else{
            l = pDataInLen / 8;
        }

        buf = new byte[8];
        tmpbuf = new byte[8];
        Arrays.fill(buf, (byte) 0x00);
        Arrays.fill(tmpbuf, (byte) 0x00);
        for (i = 0; i < l; i++) {
            System.arraycopy(tmpbuf, 0, buf, 0, 8);
            for (k = 0; k < 8; k++) {
                buf[k] ^= inbuf[i * 8 + k];
            }
            iRet = Urovo_PciDes(KeyType._MACKEY,
                    pMacKeyIndex, 8, buf,
                    tmpbuf, 1);
        }

        System.arraycopy(tmpbuf, 0, macOut, 0, 8);
        return macOut;
    }

    /**
     * ANSI X9.9MAC算法（软加密）<br/>
     * @param pKeys
     *            8字节密钥数据
     * @param pNeedMacDatas
     *            待计算mac的数据
     * @throws
     */
    @Override
    public byte[] getMac(byte pKeys [],byte[] pNeedMacDatas) throws Exception {
        if (pKeys.length!=8){
            throw new IllegalStateException("x9_9mac算法密钥长度应该为8");
        }
        final int dataLength = pNeedMacDatas.length;
        final int lastLength = dataLength % 8;
        final int lastBlockLength = lastLength == 0 ? 8 : lastLength;
        final int blockCount = dataLength / 8 + (lastLength > 0 ? 1 : 0);

        // 拆分数据（8字节块/Block）
        byte[][] dataBlock = new byte[blockCount][8];
        for (int i = 0; i < blockCount; i++) {
            int copyLength = i == blockCount - 1 ? lastBlockLength : 8;
            System.arraycopy(pNeedMacDatas, i * 8, dataBlock[i], 0, copyLength);
        }

        byte[] desXor = new byte[8];
        for (int i = 0; i < blockCount; i++) {
            byte[] tXor = xOr(desXor, dataBlock[i]);
            desXor = DesUtils.encrypt(pKeys, tXor, DesImpl.getInstance());// DES加密
        }
        return desXor;
    }

    /**
     * 将b1和b2做异或，然后返回
     *
     * @param b1
     * @param b2
     * @return 异或结果
     */
    public byte[] xOr(byte[] b1, byte[] b2) {
        byte[] tXor = new byte[Math.min(b1.length, b2.length)];
        for (int i = 0; i < tXor.length; i++)
            tXor[i] = (byte) (b1[i] ^ b2[i]); // 异或(Xor)
        return tXor;
    }


}
