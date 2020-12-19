package com.alphasoft.javafx_simplecalculator.calculator;

import java.lang.reflect.ParameterizedType;

import com.alphasoft.javafx_simplecalculator.entity.OperationEntity;

public abstract class NumberCalculatorImpl<T extends Number> implements NumberCalculator{
	
	public abstract T operate(OperationEntity<T> operationEntity);
	
	public abstract T valueOf(String value);

	@SuppressWarnings("unchecked")
	@Override
	public Number calculate(String operation) {
		try {
			String[] operands;
			Operator operator;
			if( operation.contains(Operator.PLUS.toString()) ) {
				operands = operation.split("\\+",2);
				operator = Operator.PLUS;
			}else if( operation.contains(Operator.MINUS.toString()) ) {
				operands = operation.split("-",2);
				operator = Operator.MINUS;
			}else if( operation.contains(Operator.MULTIPLICATION.toString()) ) {
				operands = operation.split("×",2);
				operator = Operator.MULTIPLICATION;
			}else if( operation.contains(Operator.DIVISION.toString()) ) {
				operands = operation.split("÷",2);
				operator = Operator.DIVISION;
			}else {
				return valueOf(operation);
			}
			
			T leftOperand = (T) calculate(operands[0]);
			T rightOperand = (T) calculate(operands[1]);
			
			OperationEntity<T> operationEntity = new OperationEntity<>(leftOperand, rightOperand, operator);
			return operate(operationEntity);
		}catch(ArithmeticException ex) {
			throw new CalculatorException(CalculatorException.ARITHMETIC_ERROR);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		Class<T> type = (Class<T>) ( (ParameterizedType)(getClass().getGenericSuperclass()) ).getActualTypeArguments()[0];
		StringBuilder sb = new StringBuilder();
		sb.append(type.getSimpleName()).append(" ").append("Calculator");
		return sb.toString();
	}
	
}
