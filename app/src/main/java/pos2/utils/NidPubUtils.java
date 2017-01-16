package pos2.utils;

/**
 * Created by lenovo on 2016/11/20. 描述：
 */

public class NidPubUtils {

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
	public static String bytesToHexString(byte[] bArray) {
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

	public static byte[] hexStringToByte(String hex) {
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
	 public static String binaryStringToHexString(String binaryString){
		 if(binaryString==null||binaryString.length()%4!=0){
			 return null;
		 }
		 String target = "";
		 for(int i = 0;i<binaryString.length()/4;i++){
			 String str = binaryString.substring(i*4,i*4+4);
			 System.out.println("str:"+str);
			 target+=Integer.toString (Integer.parseInt (str, 2), 16);
			 System.out.println("target:"+target);
		 }
		 return target;
	 }
  
}
