package tools.com.hellolibrary.hello_string;

import android.text.TextUtils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (!TextUtils.isEmpty(pS)) {
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
}
