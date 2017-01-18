package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;

/**
 * 2016��8��23��
 * by lee
 * for��
 */
public class F14 extends BaseField {
	public static final String lengtype = "fix";
	public static final String DES = "卡有效期";
	public static boolean IS_VAR_LEN = false;
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.N;
	public static final int NORMAL_LEN = 2;
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"NORMAL_LEN:"+NORMAL_LEN; 
	public F14(){}
	public F14(String fieldValue){
		value = fieldValue;
	}
}
