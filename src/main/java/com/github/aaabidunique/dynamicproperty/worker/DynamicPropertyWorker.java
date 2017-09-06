package com.github.aaabidunique.dynamicproperty.worker;

import java.util.List;
import java.util.Properties;

import com.github.aaabidunique.dynamicproperty.domain.Criteria;
import com.github.aaabidunique.dynamicproperty.domain.Operation;
import com.github.aaabidunique.dynamicproperty.domain.OperationProperty;

public class DynamicPropertyWorker {

	private DynamicPropertyWorker() {
	}

	public static List<OperationProperty> getOperationPropertyList(Operation operation) {
		boolean criteriaTruthy = false;
		Criteria criteria = operation.getCriteria();
		switch (criteria.getOperator()) {
		case EQUALS:
			criteriaTruthy = criteria.getInputProperty().equals(criteria.getOperand());
			break;
		case EQUALS_IGNORE_CASE:
			criteriaTruthy = criteria.getInputProperty().equalsIgnoreCase(criteria.getOperand());
			break;
		case CONTAINS:
			criteriaTruthy = criteria.getInputProperty().contains(criteria.getOperand());
			break;
		default:
			criteriaTruthy = criteria.getInputProperty().matches(criteria.getOperand());
			break;
		}
		return (criteriaTruthy) ? operation.getTrueOperations() : operation.getFalseOperations();
	}

	public static void updateProperty(Properties properties, List<OperationProperty> operationPropertyList) {
		for (OperationProperty eachOperationProperty : operationPropertyList) {
			properties.setProperty(eachOperationProperty.getKey(), eachOperationProperty.getValue());
		}
	}

}