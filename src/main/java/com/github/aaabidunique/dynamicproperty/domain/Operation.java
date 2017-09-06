package com.github.aaabidunique.dynamicproperty.domain;

import java.util.List;

public class Operation {

	private Criteria criteria;
	private List<OperationProperty> trueOperations;
	private List<OperationProperty> falseOperations;

	public Criteria getCriteria() {
		return criteria;
	}

	public List<OperationProperty> getTrueOperations() {
		return trueOperations;
	}

	public List<OperationProperty> getFalseOperations() {
		return falseOperations;
	}

	@Override
	public String toString() {
		return "Operation [criteria=" + criteria + ", trueOperations=" + trueOperations + ", falseOperations=" + falseOperations + "]";
	}
}