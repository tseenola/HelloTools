package tools.com.hellolibrary.hello_string;

import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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
    public static boolean isTextRight(@NonNull String pS, int len) {
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
    public static String clearAllBlank(@NonNull String pS) {
        return pS.replace(" ", "");
    }

    /**
     * 清除左边的指定字符
     *
     * @param pS
     */
    @NonNull
    public static String clearLeftTargetChar(@NonNull String pS, char pTarget) {
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
    @NonNull
    public static String clearRightTargetChart(@NonNull String pS, char target) {
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
    public static String clearLeftRightChar(@NonNull String pS) {
        return pS.trim();
    }

    public static boolean isNumber(@NonNull String str) {
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
    @NonNull
    public static String upperFirstLetter(@NonNull String s) {
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
    @NonNull
    public static String lowerFirstLetter(@NonNull String s) {
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
    @NonNull
    public static String reverse(@NonNull String s) {
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

    /**
     * 对指定数据进行填充，直到达到需要的长度
     *
     * @param dir     在左或者右填充
     * @param fill    长度不足用什么填充
     * @param content 被填充的内容
     * @param mastLen 需要达到的长度
     * @return
     */
    @NonNull
    public static String fillContentBy(Dir dir, @NonNull String fill, @NonNull String content, int mastLen){
        if(fill.length()!=1){
            return "fill 参数错误！";
        }
        String x = fill;
        int contentLen = content.length();
        int needAddLen = mastLen - contentLen;
        if(needAddLen<=0){
            return content;
        }
        while(fill.length()<needAddLen){
            fill+=x;
        }
        if(dir==Dir.left){
            content = fill+content;
        }else{
            content = content+fill;
        }
        return content;
    }
    public static enum Dir{
        left,right
    }


    /*
    * To convert the InputStream to String we use the BufferedReader.readLine()
    * method. We iterate until the BufferedReader return null which means
    * there's no more data to read. Each line will appended to a StringBuilder
    * and returned as String.
    */
    public static String streamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    /**
     * 对字符串进行分割，每？个一组
     * eg:SlipContentByNum("abcd", 2);返回{ab,cd}
     * @param pData
     * @param pNum
     * @return
     */
    public static List<String> SlipContentByNum(String pData, int pNum){
        List<String> slipedList = new ArrayList<String>();
        int befor = 0;
        int after = befor+pNum;
        for(;;){
            if(after>=pData.length()){
                after = pData.length();
                slipedList.add(pData.substring(befor,after));
                befor+=pNum;
                after+=pNum;
                break;
            }else{
                slipedList.add(pData.substring(befor,after));
                befor+=pNum;
                after+=pNum;
            }
        }
        return slipedList;
    }

}
