package pos2.model;

/**
 * 2016��8��29��
 * by lee
 * for��
 */
public class BaseField {

	public String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public enum LenthType{
		fix,llvar,lllvar;
	}
}
