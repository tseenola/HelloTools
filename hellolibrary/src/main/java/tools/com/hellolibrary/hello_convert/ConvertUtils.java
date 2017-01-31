package tools.com.hellolibrary.hello_convert;

import android.support.annotation.NonNull;

/**
 * Created by lenovo on 2016/11/20.
 * 描述：
 */

public class ConvertUtils {

    public static int PubBcdToByte(byte ch) {
        if (((ch & 0x0F) > 9) || ((ch >> 4) > 9))
            return 0;
        return (ch >> 4) * 10 + (ch & 0x0f);
    }

    /**
     * byte 转为16进制字符串
     *
     * @param bArray
     * @return
     */
    public static String bytesToHexString(@NonNull byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    /**
     * 16进制字符串转换为byte 数组
     *
     * @param hex
     * @return
     */
    @NonNull
    public static byte[] hexStringToByte(@NonNull String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    /**
     * 二进制字符串转16进制字符串
     */
    public static String binaryStringToHexString(String binaryString) {
        if (binaryString == null || binaryString.length() % 4 != 0) {
            return null;
        }
        String target = "";
        for (int i = 0; i < binaryString.length() / 4; i++) {
            String str = binaryString.substring(i * 4, i * 4 + 4);
            target += Integer.toString(Integer.parseInt(str, 2), 16);
        }
        return target.toUpperCase();
    }

    /**
     * 16进制字符串转为2进制字符串
     * @param hexString
     * @return
     */
    public static String hexStringToBinaryString(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0)
            return null;
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000"
                    + Integer.toBinaryString(Integer.parseInt(
                    hexString.substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }


    /**
     * 字符串转16进制字符串
     * @param
     * @return
     */
    public static String strToHexString(String pOrg) {
        String lTarget = "";
        for (int i = 0; i < pOrg.length(); i++) {
            int ch = (int) pOrg.charAt(i);
            String s4 = Integer.toHexString(ch);
            lTarget = lTarget + s4;
        }
        return lTarget.toUpperCase();
    }

    /**
     * 16进制字符串转为字符串
     * @return
     */
    public static String hexStringToStr(String pHexString){
        return new String(ConvertUtils.hexStringToByte(pHexString));
    }
////////////////////////////////////////////////////////////////////////////////



    public static void BcdToAsc(byte[] sAscBuf, byte[] sBcdBuf, int iAscLen) {
        int i, j;

        j = 0;
        for (i = 0; i < iAscLen / 2; i++) {
            sAscBuf[j] = (byte) ((sBcdBuf[i] & 0xf0) >> 4);
            sAscBuf[j] = abcd_to_asc(sAscBuf[j]);
            j++;
            sAscBuf[j] = (byte) (sBcdBuf[i] & 0x0f);
            sAscBuf[j] = abcd_to_asc(sAscBuf[j]);
            j++;
        }
        if (iAscLen % 2 != 0) {
            sAscBuf[j] = (byte) ((sBcdBuf[i] & 0xf0) >> 4);
            sAscBuf[j] = abcd_to_asc(sAscBuf[j]);
        }
    }

    public static byte abcd_to_asc(byte ucBcd) {
        byte ucAsc;

        ucBcd &= 0x0f;
        if (ucBcd <= 9) {
            ucAsc = (byte) (ucBcd + (byte) '0');
        } else {
            ucAsc = (byte) (ucBcd + (byte) 'A' - (byte) 10);
        }
        return ucAsc;
    }


    public static void AscToBcd(byte[] sBcdBuf, byte[] sAscBuf, int iAscLen) {
        int i, j;

        j = 0;

        for (i = 0; i < (iAscLen + 1) / 2; i++) {
            sBcdBuf[i] = (byte) (aasc_to_bcd(sAscBuf[j++]) << 4);
            if (j >= iAscLen) {
                sBcdBuf[i] |= 0x00;
            } else {
                sBcdBuf[i] |= aasc_to_bcd(sAscBuf[j++]);
            }
        }
    }

    public static byte aasc_to_bcd(byte ucAsc) {
        byte ucBcd;

        if (ucAsc >= '0' && ucAsc <= '9')
            ucBcd = (byte) (ucAsc - '0');
        else if (ucAsc >= 'A' && ucAsc <= 'F')
            ucBcd = (byte) (ucAsc - 'A' + 10);
        else if (ucAsc >= 'a' && ucAsc <= 'f')
            ucBcd = (byte) (ucAsc - 'a' + 10);
        else if (ucAsc > 0x39 && ucAsc <= 0x3f)
            ucBcd = (byte) (ucAsc - '0');
        else ucBcd = 0x0f;

        return ucBcd;
    }


    public static void do_xor_urovo(byte[] src1, byte[] src2, int num) {
        int i;

        int data2 = 0;
        int data1 = 0;

        for (i = 0; i < num; i++) {
            data1 = 0x00ff & src1[i];
            data2 = 0x00ff & src2[i];
            data1 ^= data2;
            src1[i] = (byte) (data1 & 0x00ff);
        }
    }
}
