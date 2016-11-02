package tools.com.hellolibrary.hello_string;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.text.TextUtils.isEmpty;

/**
 * Created by lenovo on 2016/6/17.
 * 描述：
 */
public class StringUtils {
    /**
     * 金额保留两位小数
     * @param amt
     * @return
     */
    public static String formatAmt(double amt) {
        DecimalFormat pattern = new DecimalFormat("0.00");
        return pattern.format(amt);
    }

    /**
     * 格式化为两位数字
     *
     * @param str
     * @param
     * @return
     */
    public static String formatStr(int str, String partten) {
        DecimalFormat pattern = new DecimalFormat(partten);
        return pattern.format(str);
    }

    /**
     * 验证字符串是否为指定长度
     *
     * @param pS
     * @param len
     * @return
     */
    public static boolean isTextRight(String pS, int len) {
        if (!isEmpty(pS)) {
            if (pS.length() == len) {
                return true;
            }
        }
        return false;
    }

    /**
     * 清除字符串中所有的空格
     *
     * @param pS
     */
    public static String clearAllBlank(String pS) {
        return pS.replace(" ", "");
    }

    /**
     * 清除左边的指定字符
     *
     * @param pS
     */
    public static String clearLeftTargetChar(String pS, char pTarget) {
        if (pS.startsWith(pTarget + "")) {
            pS = pS.substring(1, pS.length());
            return clearLeftTargetChar(pS, pTarget);
        } else {
            return pS;
        }
    }

    /**
     * 清除右边指定字符
     *
     * @param pS
     * @param target
     * @return
     */
    public static String clearRightTargetChart(String pS, char target) {
        if (pS.endsWith(target + "")) {
            pS = pS.substring(0, pS.length() - 1);
            return clearRightTargetChart(pS, target);
        } else {
            return pS;
        }
    }

    /**
     * 清除右边和左边所有空格
     *
     * @param pS
     * @return
     */
    public static String clearLeftRightChar(String pS) {
        return pS.trim();
    }

    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 保留小数后两位
     *
     * @param value
     * @return
     */
    public static String formatStr(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value);
    }

    /**
     * 首字母大写
     *
     * @param s 待转字符串
     * @return 首字母大写字符串
     */
    public static String upperFirstLetter(String s) {
        if (isEmpty(s) || !Character.isLowerCase(s.charAt(0))) {
            return s;
        }
        return String.valueOf((char) (s.charAt(0) - 32)) + s.substring(1);
    }

    /**
     * 首字母小写
     *
     * @param s 待转字符串
     * @return 首字母小写字符串
     */
    public static String lowerFirstLetter(String s) {
        if (isEmpty(s) || !Character.isUpperCase(s.charAt(0))) {
            return s;
        }
        return String.valueOf((char) (s.charAt(0) + 32)) + s.substring(1);
    }

    /**
     * 反转字符串
     *
     * @param s 待反转字符串
     * @return 反转字符串
     */
    public static String reverse(String s) {
        int len = s.length();
        if (len <= 1) return s;
        int mid = len >> 1;
        char[] chars = s.toCharArray();
        char c;
        for (int i = 0; i < mid; ++i) {
            c = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = c;
        }
        return new String(chars);
    }
}
