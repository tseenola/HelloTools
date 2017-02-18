package utils;

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
}
