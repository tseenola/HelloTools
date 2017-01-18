package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;

/**
 * 2016��8��23��
 * by lee
 * for���ܿ���ϵͳ���ٺ�(System Trace Audit Number)
 */
public class F11 extends BaseField {
	public static final String lengtype = "fix";
	public static final String DES = "受卡方系统跟踪号";
	public static boolean IS_VAR_LEN = false;//�Ƿ�Ϊ�߳�����
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.N;
	public static final int NORMAL_LEN = 3;
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"NORMAL_LEN:"+NORMAL_LEN; 
	public F11(){}
    public F11(String fieldValue){
		value = fieldValue;
	}
}
