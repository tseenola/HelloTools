package tools.com.hellolibrary.hello_string;

import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lenovo on 2017/2/14.
 * 描述：
 */

public class PosStringUtils {
    /**
     * 获取加*卡号
     */
    public static String getStarPan(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string.substring(0, 6));

        String String2 = string.substring(6, string.length() - 4);
        for (int i = 0; i < String2.length(); i++)
            stringBuffer.append("*");

        stringBuffer.append(string.substring(string.length() - 4, string.length()));
        return stringBuffer.toString();
    }

    public static String getTlvStr(String tag, String value) {
        String result = tag;
        int length = value.length() / 2;
        if(length <= 0) {
            result = "";
        }
        else if(length <= 127) {
            result += ConvertUtils.bytesToHexString(new byte[] {(byte) length})+value;
        }
        else if(length <= 255) {
            result += ConvertUtils.bytesToHexString(new byte[] {(byte) 0x81, (byte) length})+value;
        }
        else {
            result = "";
        }
        return result;
    }

}
