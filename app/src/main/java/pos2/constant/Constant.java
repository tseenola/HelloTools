package pos2.constant;
/**
 * 2016��8��23��
 * by lee
 * for��
 */
public class Constant {

	/**
	 * BCD 压缩型BCD码，长度的单位为数字位数。
	 * ASCII ASCII码字符，长度单位为字符数。
	 * BIN 无格式二进制数，长度单位为比特（bit）。
	 * HEX 无格式十六进制数，长度单位为字节（Byte）
	 * TRACK 压缩的磁道信息。长度为磁道字符数。
	 */
	public static enum FieldType{
		BCD,ASCII,BIN,HEX,TRACK
	}
}
