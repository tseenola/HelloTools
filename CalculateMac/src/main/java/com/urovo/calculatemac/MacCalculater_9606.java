package com.urovo.calculatemac;

import com.urovo.poscommon.models.KeyType;

import java.util.Arrays;

import static com.urovo.poscommon.utils.Ped.Urovo_PciDes;

/**
 * Created by lenovo on 2017/4/12.
 * 描述：Mac9606算法
 */

public class MacCalculater_9606 implements IMacCalculater {
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


        for (i = 0; i < l; i++) {
            for (k = 0; k < 8; k++)
                buf[k] ^= inbuf[i * 8 + k];
            buf[8] = 0x00;
        }

        iRet = Urovo_PciDes(KeyType._MACKEY, pMacKeyIndex, 8, buf, Macbuf, 1);
        if(iRet != 0) {
            throw new IllegalStateException("Mac计算错误，计算结果:"+iRet);
        }
        System.arraycopy(Macbuf, 0, macOut, 0, 8);

        return macOut;
    }
}
