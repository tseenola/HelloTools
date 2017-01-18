package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;

/**
 * 2016��8��23��
 * by lee
 * for��
 */
public class F61 extends BaseField {
	public static final String lengtype = "llvar";
	public static final String DES = "原始信息域";
	public static boolean IS_VAR_LEN = true;
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.N;
	public static final int VAR_LEN = 2;
	public static final int CONTENT_MAX_LEN = 15;
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"VAR_LEN:"+VAR_LEN + "\r\n"+
			"CONTENT_MAX_LEN:"+CONTENT_MAX_LEN; 
	public F61(){}
	public F61(String fieldValue){
		value = fieldValue;
	}
}
