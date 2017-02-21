package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;
import tools.com.hellolibrary.hello_string.StringUtils;

/**
 * 2016��8��23��
 * by lee
 * for��
 */
public class F44 extends BaseField {
	public static final StringUtils.Dir DIR = StringUtils.Dir.left;
	public static final String FiLL = "0";
	public static final String lengtype = "llvar";
	public static final String DES = "附加响应数据";
	public static boolean IS_VAR_LEN = true;
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.ASCII;
	public static final int VAR_LEN = 1;
	public static final int CONTENT_MAX_LEN = 25;
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"VAR_LEN:"+VAR_LEN + "\r\n"+
			"CONTENT_MAX_LEN:"+CONTENT_MAX_LEN;
	public F44(){}
	public F44(String fieldValue){
		value = fieldValue;
	}
}
