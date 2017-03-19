package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;


public class F_05 extends BaseField {
	public static final String ORDER = "_5";
	public static final String DES = "位图";
	public static boolean IS_VAR_LEN = false;
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.BCD;
	public static final int NORMAL_LEN = 8;
	public F_05(){}
	public F_05(String fieldValue){
		value = fieldValue;
	}
}
