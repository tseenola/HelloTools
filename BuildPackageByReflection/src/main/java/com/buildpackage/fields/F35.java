package com.buildpackage.fields;


import com.buildpackage.constant.Constant;
import com.buildpackage.model.BaseField;

import tools.com.hellolibrary.hello_string.StringUtils;


public class F35 extends BaseField {
	public static final LenthType lengthtype = LenthType.llvar;
	public static final StringUtils.Dir DIR = StringUtils.Dir.right;
	public static final String FiLL = "0";
	public static final String DES = "2磁道数据";
	public static boolean IS_VAR_LEN = true;
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.TRACK;
	public static final int VAR_LEN = 1;
	public static final int CONTENT_MAX_LEN = 19;
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"VAR_LEN:"+VAR_LEN + "\r\n"+
			"CONTENT_MAX_LEN:"+CONTENT_MAX_LEN; 
	public F35(){}
	public F35(String fieldValue){
		value = fieldValue;
	}
}
