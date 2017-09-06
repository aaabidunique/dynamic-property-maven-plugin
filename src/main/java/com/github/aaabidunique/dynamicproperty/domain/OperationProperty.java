package com.github.aaabidunique.dynamicproperty.domain;

public class OperationProperty {

	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "OperationProperty [key=" + key + ", value=" + value + "]";
	}
}