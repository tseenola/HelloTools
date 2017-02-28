/*
package core;

import tools.com.hellolibrary.hello_convert.ConvertUtils;

public class TlvUtils {

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
*/
