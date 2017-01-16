package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;

/**
 * 2016��8��23��
 * by lee
 * for��
 */
public class F62 extends BaseField {
	public static final String lengtype = "llvar";
	public static final String DES = "�Զ�����";
	public static boolean IS_VAR_LEN = true;//�Ƿ�Ϊ�߳�����
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.ANS;//����Ϊ_����
	public static final int LLVAR_LEN = 2;//�����ֽڱ�ʾ����
	public static final int CONTENT_MAX_LEN = 512;//������󳤶�	
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"LLVAR_LEN:"+LLVAR_LEN + "\r\n"+
			"CONTENT_MAX_LEN:"+CONTENT_MAX_LEN; 
	public F62(){}
	public F62(String fieldValue){
		value = fieldValue;
	}
}
