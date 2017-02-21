package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;

/**
 * 2016��8��29��
 * by lee
 * for��
 */
public class F_04 extends BaseField {
	public static final String ORDER = "_4";
	public static final String DES = "消息类型";
	public static boolean IS_VAR_LEN = false;//�Ƿ�Ϊ�߳�����
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.BCD;//����Ϊ_����
	public static final int NORMAL_LEN = 2;//������С
	
	public F_04(){}
	public F_04(String fieldValue){
		value = fieldValue;
	}
}
