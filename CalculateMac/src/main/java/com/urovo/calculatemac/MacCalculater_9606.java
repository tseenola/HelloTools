package com.urovo.calculatemac;

import com.customview.keytool.des.algorithm.DesImpl;
import com.customview.keytool.des.utils.DesUtils;
import com.urovo.poscommon.models.KeyType;

import java.util.Arrays;

import static com.urovo.poscommon.utils.Ped.Urovo_PciDes;

/**
 * Created by lenovo on 2017/4/12.
 * 描述：Mac9606算法
 * 算法描述：
 *
 * a) 每8个字节做异或
 * b) 最后异或的结果做一次DES运算
 */

public class MacCalculater_9606 implements IMacCalculater {

    private MacCalculater_9606(){}

    private static final MacCalculater_9606 sMacCalculater_9606 = new MacCalculater_9606();
    public static MacCalculater_9606 getInstance(){
        return sMacCalculater_9606;
    }

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

        //a) 每8个字节做异或
        for (i = 0; i < l; i++) {
            for (k = 0; k < 8; k++)
                buf[k] ^= inbuf[i * 8 + k];
            buf[8] = 0x00;
        }
        //b) 最后异或的结果做一次DES运算
        iRet = Urovo_PciDes(KeyType._MACKEY, pMacKeyIndex, 8, buf, Macbuf, 1);
        if(iRet != 0) {
            throw new IllegalStateException("Mac计算错误，计算结果:"+iRet);
        }
        System.arraycopy(Macbuf, 0, macOut, 0, 8);

        return macOut;
    }

    @Override
    public byte[] getMac(byte[] pKeys, byte[] pNeedMacDatas) throws Exception {
        byte[] buf = new byte[17];
        byte[] tmpbuf = new byte[17];
        byte [] macOut = new byte[8];
        int i = 0;
        int l = 0;
        int k = 0 ;
        int iRet = 0;

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


        Macbuf = DesUtils.encrypt(pKeys, buf, DesImpl.getInstance());

        System.arraycopy(Macbuf, 0, macOut, 0, 8);

        return macOut;
    }
}
