package pos2.utils;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 

/**
 * Created by lenovo on 2016/6/17.
 * 鎻忚堪锛�
 */
public class StringUtils {

	public static void main(String[] args) {
		 
		System.out.println(getData(35, "6212264402021674373=24052206429991773"));
	}
    public static String formatAmt(double amt) {
        DecimalFormat pattern = new DecimalFormat("0.00");
        return pattern.format(amt);
    }
 
    /**
     * 鏍煎紡鍖栦负涓や綅鏁板瓧
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
     * 楠岃瘉瀛楃涓叉槸鍚︿负鎸囧畾闀垮害
     *
     * @param pS
     * @param len
     * @return
     */
    

    /**
     * 娓呴櫎瀛楃涓蹭腑鎵�鏈夌殑绌烘牸
     *
     * @param pS
     */
    public static String clearAllBlank(String pS) {
        return pS.replace(" ", "");
    }

    /**
     * 娓呴櫎宸﹁竟鐨勬寚瀹氬瓧绗�
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
     * 娓呴櫎鍙宠竟鎸囧畾瀛楃
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
     * 娓呴櫎鍙宠竟鍜屽乏杈规墍鏈夌┖鏍�
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
     * 淇濈暀灏忔暟鍚庝袱浣�
     *
     * @param value
     * @return
     */
    public static String formatStr(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value);
    }
    /**
     * 根据用户提供的内容进行填充，直到达到指定的长度位置
     * 
     * @param dir     填充的方位
     * @param fill    填充物
     * @param content 被填充的内容 
     * @param mastLen 填充后需要达到的长度
     * @return
     */
    public static String fillContentBy(Dir dir,String fill,String content,int mastLen){
    	if(fill.length()!=1){
    		return "填充字符不为一";
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
 
    /**
	 * 
	 * @param orgData
	 * @param lenth
	 * @return
	 */
	public static String getData(int field ,String orgData){
		String data = "";
		 
		if(field==2||field==14){
			return StringUtils.fillContentBy(Dir.left, "0", "0", orgData.length());
		}else if(field==35||field==36){
			data = orgData.replace("=", "D");
			if(data.length()<=32){
				data = StringUtils.fillContentBy(Dir.left, "0", "0", 32);
			}else{
				data = StringUtils.fillContentBy(Dir.left, "0", "0", 32)+data.substring(32);
			}
		}
		return data;
	}
}
 

