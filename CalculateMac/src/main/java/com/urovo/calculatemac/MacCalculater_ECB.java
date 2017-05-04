package com.urovo.calculatemac;

import com.customview.keytool.des.algorithm.DesImpl;
import com.customview.keytool.des.utils.DesUtils;
import com.urovo.poscommon.models.KeyType;

import java.util.Arrays;

import tools.com.hellolibrary.hello_convert.ConvertUtils;

import static com.urovo.poscommon.utils.Ped.Urovo_PciDes;

/**
 * Created by lijun on 2017/4/12.
 * 描述：MacECB算法，银联商务标准算法
 * a) 将欲发送给POS中心的消息中，从消息类型（MTI）到63域之间的部分构成MAC ELEMEMENT BLOCK （MAB）。
 * b) 对MAB，按每8个字节做异或（不管信息中的字符格式），如果最后不满8个字节，则添加“0X00”。
 * c) 将异或运算后的最后8个字节（RESULT BLOCK）转换成16 个HEXDECIMAL：
 * d) 取前8 个字节用MAK加密：
 * e) 将加密后的结果与后8 个字节异或：
 * f) 用异或的结果TEMP BLOCK 再进行一次单倍长密钥算法运算。
 * g) 将运算后的结果（ENC BLOCK2）转换成16 个HEXDECIMAL：
 * h) 取前8个字节作为MAC值。
 */

public class MacCalculater_ECB implements IMacCalculater {
    private MacCalculater_ECB(){}

    private static final MacCalculater_ECB sMacCalculaterEcb = new MacCalculater_ECB();
    public static MacCalculater_ECB getInstance(){
        return sMacCalculaterEcb;
    }

    /**
     * 银商标准Mac计算方法（硬加密）
     * @param pMacKeyIndex mac密钥索引
     * @param pDataInLen mac数据长度
     * @param pNeedMacDatas 计算mac的数据
     * @return
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
        //b) 对MAB，按每8个字节做异或（不管信息中的字符格式），如果最后不满8个字节，则添加“0X00”。
        buf = new byte[8];
        for (i = 0; i < l; i++)
            for (k = 0; k < 8; k++)
                buf[k] ^= inbuf[i * 8 + k];

        //c) 将异或运算后的最后8个字节（RESULT BLOCK）转换成16 个HEXDECIMAL：
        ConvertUtils.BcdToAsc(tmpbuf, buf, 16);
        tmpbuf[16] = 0;

        //d) 取前8 个字节用MAK加密：
        System.arraycopy(tmpbuf, 0, buf, 0, 8);
        iRet = Urovo_PciDes(KeyType._MACKEY, pMacKeyIndex, 8, buf, Macbuf, 1);

        if (iRet!=0){
            throw new IllegalStateException("Mac计算出错返回值："+iRet);
        }
        //e) 将加密后的结果与后8 个字节异或：
        Arrays.fill(buf, (byte) 0x00);
        System.arraycopy(Macbuf, 0, buf, 0, 8);

        for (k = 0; k < 8; k++)
            buf[k] ^= tmpbuf[8 + k];

        Arrays.fill(Macbuf, (byte) 0x00);
        //f) 用异或的结果TEMP BLOCK 再进行一次单倍长密钥算法运算。
        iRet = Urovo_PciDes(KeyType._MACKEY, pMacKeyIndex, 8, buf, Macbuf, 1);

        if (iRet!=0){
            throw new IllegalStateException("Mac计算出错返回值："+iRet);
        }

        Arrays.fill(buf, (byte) 0x00);
        System.arraycopy(Macbuf, 0, buf, 0, 8);

        Arrays.fill(tmpbuf, (byte) 0x00);
        //g) 将运算后的结果（ENC BLOCK2）转换成16 个HEXDECIMAL：
        ConvertUtils.BcdToAsc(tmpbuf, buf, 16);
        //h) 取前8个字节作为MAC值。
        System.arraycopy(tmpbuf, 0, macOut, 0, 8);
        return macOut;
    }

    /**
     * 银商标准Mac计算方法（软加密）
     * @param pKeys 密钥
     * @param pNeedMacDatas 待计算mac的数据
     * @return
     * @throws Exception
     */
    @Override
    public byte[] getMac(byte[] pKeys, byte[] pNeedMacDatas) throws Exception {
        byte[] buf = new byte[17];
        byte[] tmpbuf = new byte[17];
        byte [] macOut = new byte[8];
        int i = 0;
        int l = 0;
        int k = 0 ;

        byte[] inbuf = new byte[pNeedMacDatas.length + 8];
        byte[] Macbuf = new byte[9];

        Arrays.fill(buf, (byte) 0x00);
        System.arraycopy(pNeedMacDatas, 0, inbuf, 0, pNeedMacDatas.length);

        if (pNeedMacDatas.length % 8 != 0){
            l = pNeedMacDatas.length / 8 + 1;
        } else{
            l = pNeedMacDatas.length / 8;
        }

        buf = new byte[8];
        for (i = 0; i < l; i++)
            for (k = 0; k < 8; k++)
                buf[k] ^= inbuf[i * 8 + k];

        ConvertUtils.BcdToAsc(tmpbuf, buf, 16);
        tmpbuf[16] = 0;

        System.arraycopy(tmpbuf, 0, buf, 0, 8);

        Macbuf = DesUtils.encrypt(pKeys, buf, DesImpl.getInstance());

        Arrays.fill(buf, (byte) 0x00);
        System.arraycopy(Macbuf, 0, buf, 0, 8);

        for (k = 0; k < 8; k++)
            buf[k] ^= tmpbuf[8 + k];

        Arrays.fill(Macbuf, (byte) 0x00);

        Macbuf = DesUtils.encrypt(pKeys, buf, DesImpl.getInstance());

        Arrays.fill(buf, (byte) 0x00);
        System.arraycopy(Macbuf, 0, buf, 0, 8);

        Arrays.fill(tmpbuf, (byte) 0x00);
        ConvertUtils.BcdToAsc(tmpbuf, buf, 16);
        System.arraycopy(tmpbuf, 0, macOut, 0, 8);
        return macOut;
    }
}
