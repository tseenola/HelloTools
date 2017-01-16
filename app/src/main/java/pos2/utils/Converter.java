package pos2.utils;

/**
 * 2016��8��23�� by lee for��
 */
public class Converter {
	public static void main(String[] args) {
	 
		//2  -  32 
		System.out.println(Integer.toHexString(0));
	}

	/**
	 * byte����תΪ16�����ַ���
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

	/**
	 * 16�����ַ���ת��Ϊbyte ����
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

	private static byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	public static int PubBcdToByte(byte ch) {
		if (((ch & 0x0F) > 9) || ((ch >> 4) > 9))
			return 0;
		return (ch >> 4) * 10 + (ch & 0x0f);
	}

	/* 16�����ַ���תΪ2�����ַ��� */
	public static String hexString2BinaryString(String hexString) {
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

	/* 16�����ַ���תΪasc */
	public static String hexString2Asc(String hexString) {
		if (hexString == null || hexString.length() % 2 != 0) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hexString.length(); i += 2) {
			String str = hexString.substring(i, i + 2);
			int target = Integer.valueOf(str);
			if (target >= 30 && target <= 39) {
				sb.append((target - 30) + "");
			}
		}

		return sb.toString();
	}

}
