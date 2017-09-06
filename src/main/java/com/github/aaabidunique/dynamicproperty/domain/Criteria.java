package com.github.aaabidunique.dynamicproperty.domain;

import com.github.aaabidunique.dynamicproperty.constant.Operator;

public class Criteria {

	private String inputProperty;
	private Operator operator;
	private String operand;

	public String getInputProperty() {
		return inputProperty;
	}

	public Operator getOperator() {
		return operator;
	}

	public String getOperand() {
		return operand;
	}

	@Override
	public String toString() {
		return "Criteria [inputProperty=" + inputProperty + ", operator=" + operator + ", operand=" + operand + "]";
	}
}