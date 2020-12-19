package com.alphasoft.javafx_simplecalculator.calculator;

import com.alphasoft.javafx_simplecalculator.entity.OperationEntity;

public class DoubleCalculator extends NumberCalculatorImpl<Double>{

	@Override
	public Number calculate(String operation) {
		return super.calculate(operation);
	}

	@Override
	public Double operate(OperationEntity<Double> operationEntity) {
		try {
			Double leftOperand = operationEntity.getLeftOperand();
			Double rightOperand = operationEntity.getRightOperand();
			Operator operator = operationEntity.getOperator();
			switch (operator) {
			case PLUS:
				return leftOperand + rightOperand;
			case MINUS:
				return leftOperand - rightOperand;
			case MULTIPLICATION:
				return leftOperand *  rightOperand;
			case DIVISION:
				return leftOperand / rightOperand;
			default:
				throw new CalculatorException(CalculatorException.NO_OPERATOR_FOUND);
			}
		}catch(ArithmeticException ex) {
			throw new CalculatorException(CalculatorException.ARITHMETIC_ERROR);
		}
	}

	@Override
	public Double valueOf(String value) {
		try {
			return Double.valueOf(value);
		}catch(NumberFormatException ex) {
			throw new CalculatorException(CalculatorException.SYNTAX_ERROR);
		}
	}

}
