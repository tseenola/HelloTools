package com.buildpackage.model;

/**
 *
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
