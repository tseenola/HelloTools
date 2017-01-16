package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;

/**
 * 2016��8��23��
 * by lee
 * for��
 */
public class F53 extends BaseField {
	public static final String lengtype = "fix";
	public static final String DES = "��ȫ������Ϣ";
	public static boolean IS_VAR_LEN = false;//�Ƿ�Ϊ�߳�����
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.N;//����Ϊ_����
	public static final int NORMAL_LEN = 8;//������С
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"NORMAL_LEN:"+NORMAL_LEN; 
	public F53(){}
	public F53(String fieldValue){
		value = fieldValue;
	}
}
