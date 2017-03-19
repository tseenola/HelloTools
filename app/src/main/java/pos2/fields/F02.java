package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;
import tools.com.hellolibrary.hello_string.StringUtils;


public class F02 extends BaseField {
	public static final LenthType lengthtype = LenthType.llvar;
	public static final StringUtils.Dir DIR = StringUtils.Dir.left;
	public static final String FiLL = "0";
	public static final String DES = "主账号";//域名称
	public static boolean IS_VAR_LEN = true;//是否为变长
	public static final Constant.FieldType FILED_TYPE =  Constant.FieldType.BCD;//类型为数字
	public static final int VAR_LEN = 1;//1个字节表示长度
	public static final int CONTENT_MAX_LEN = 10;//最大10个字节
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"VAR_LEN:"+VAR_LEN + "\r\n"+
			"CONTENT_MAX_LEN:"+CONTENT_MAX_LEN; 
	public F02(){}
	public F02(String fieldValue){
		value = fieldValue;
	}
}
