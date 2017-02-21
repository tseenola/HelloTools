package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;
import tools.com.hellolibrary.hello_string.StringUtils;

/**
 * 2016��8��23��
 * by lee
 * for�����׽��(Amount Of Transactions)
 */
public class F04 extends BaseField {
	public static final StringUtils.Dir DIR = StringUtils.Dir.left;
	public static final String FiLL = "0";
	public static final String lengtype = "fix";
	public static final String DES = "交易金额";
	public static boolean IS_VAR_LEN = false;
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.BCD;
	public static final int NORMAL_LEN = 6;
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"NORMAL_LEN:"+NORMAL_LEN; 
	public F04(){}
	public F04(String fieldValue){
		value = fieldValue;
	}
}
