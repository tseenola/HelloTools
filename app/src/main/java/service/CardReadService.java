package service;

import com.jniexport.UROPElibJni;

/**
 * Created by lenovo on 2017/2/7.
 * 描述：
 */

public class CardReadService {
    /**
     * 获取TLV
     */
    public static String GetTlv(int Tag) {
        byte outData[] = new byte[255];
        int length = UROPElibJni.GetTlv(Tag, outData);
        if (length > 0) {
            return bytes2HexString(outData, length);
        } else {
            return "";
        }
    }

    private static String bytes2HexString(byte[] b, int blen) {
        String ret = "";
        int i = 0;
        for (byte element : b) {
            String hex = Integer.toHexString(element & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
            i++;
            if (i >= blen) {
                break;
            }
        }
        return ret;
    }
}
