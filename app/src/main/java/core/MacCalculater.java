package core;

import java.util.Arrays;

import base.Constants;
import db.bill.DBPosSettingBill;
import tools.com.hellolibrary.hello_convert.ConvertUtils;

import static pos2.utils.Ped.Urovo_PciDes;

/**
 * Created by lenovo on 2017/2/5.
 * 描述：计算Mac
 * mac计算范围（消息类型---63域）
 */

public class MacCalculater {
    /**
     *
     * @param pNeedCalMacMsg
     * @return
     */
    public static String getMac(String pBitMap,String pNeedCalMacMsg){
        String msg = pNeedCalMacMsg;
        if(pBitMap.endsWith("1")){
            int macKeyIndex = DBPosSettingBill.getMacKeyIndex();
            byte [] needCalMac = ConvertUtils.hexStringToByte(msg);
            byte [] macOut = new byte[8];
            GetMac(macKeyIndex,needCalMac.length,needCalMac,macOut,(byte)0);
            msg += ConvertUtils.bytesToHexString(macOut);
        }
        return msg;
    }

    private static int GetMac(int pMacKeyIndex, int pDataInLen, byte[] pDataIn, byte[] pMacOut, byte mode) {
        byte[] buf = new byte[17];
        byte[] tmpbuf = new byte[17];
        int i, l, k, iRet = 0;

        byte[] inbuf = new byte[pDataInLen + 8];
        byte[] Macbuf = new byte[9];

        Arrays.fill(buf, (byte) 0x00);
        System.arraycopy(pDataIn, 0, inbuf, 0, pDataInLen);

        if (pDataInLen % 8 != 0)
            l = pDataInLen / 8 + 1;
        else
            l = pDataInLen / 8;

        if (mode == 0x00) {
            for (i = 0; i < l; i++) {
                for (k = 0; k < 8; k++)
                    buf[k] ^= inbuf[i * 8 + k];
                buf[8] = 0x00;
            }

            iRet = Urovo_PciDes(Constants.KEY_TYPE._MACKEY, pMacKeyIndex, 8, buf, Macbuf, 1);
            if(iRet != 0) {
                return -1;
            }
            System.arraycopy(Macbuf, 0, pMacOut, 0, 8);
            return 0;
        }
        else if (mode == 0x10) {
            buf = new byte[8];
            for (i = 0; i < l; i++)
                for (k = 0; k < 8; k++)
                    buf[k] ^= inbuf[i * 8 + k];

            ConvertUtils.BcdToAsc(tmpbuf, buf, 16);
            tmpbuf[16] = 0;

            System.arraycopy(tmpbuf, 0, buf, 0, 8);

            iRet = Urovo_PciDes(Constants.KEY_TYPE._MACKEY, pMacKeyIndex, 8, buf, Macbuf, 1);


            Arrays.fill(buf, (byte) 0x00);
            System.arraycopy(Macbuf, 0, buf, 0, 8);

            for (k = 0; k < 8; k++)
                buf[k] ^= tmpbuf[8 + k];

            Arrays.fill(Macbuf, (byte) 0x00);

            iRet = Urovo_PciDes(Constants.KEY_TYPE._MACKEY, pMacKeyIndex, 8, buf, Macbuf, 1);


            Arrays.fill(buf, (byte) 0x00);
            System.arraycopy(Macbuf, 0, buf, 0, 8);

            Arrays.fill(tmpbuf, (byte) 0x00);
            ConvertUtils.BcdToAsc(tmpbuf, buf, 16);
            System.arraycopy(tmpbuf, 0, pMacOut, 0, 8);

            return 0;
        }
        return -2;
    }
}