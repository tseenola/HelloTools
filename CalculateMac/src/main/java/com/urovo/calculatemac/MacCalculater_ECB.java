package com.urovo.calculatemac;

import com.urovo.poscommon.models.KeyType;

import java.util.Arrays;

import tools.com.hellolibrary.hello_convert.ConvertUtils;

import static com.urovo.poscommon.utils.Ped.Urovo_PciDes;

/**
 * Created by lenovo on 2017/4/12.
 * 描述：MacECB算法，银联商务标准算法
 */

public class MacCalculater_ECB implements IMacCalculater {


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
        for (i = 0; i < l; i++)
            for (k = 0; k < 8; k++)
                buf[k] ^= inbuf[i * 8 + k];

        ConvertUtils.BcdToAsc(tmpbuf, buf, 16);
        tmpbuf[16] = 0;

        System.arraycopy(tmpbuf, 0, buf, 0, 8);

        iRet = Urovo_PciDes(KeyType._MACKEY, pMacKeyIndex, 8, buf, Macbuf, 1);


        Arrays.fill(buf, (byte) 0x00);
        System.arraycopy(Macbuf, 0, buf, 0, 8);

        for (k = 0; k < 8; k++)
            buf[k] ^= tmpbuf[8 + k];

        Arrays.fill(Macbuf, (byte) 0x00);

        iRet = Urovo_PciDes(KeyType._MACKEY, pMacKeyIndex, 8, buf, Macbuf, 1);


        Arrays.fill(buf, (byte) 0x00);
        System.arraycopy(Macbuf, 0, buf, 0, 8);

        Arrays.fill(tmpbuf, (byte) 0x00);
        ConvertUtils.BcdToAsc(tmpbuf, buf, 16);
        System.arraycopy(tmpbuf, 0, macOut, 0, 8);
        return macOut;
    }
}
