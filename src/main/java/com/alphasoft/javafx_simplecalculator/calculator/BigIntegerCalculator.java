package com.alphasoft.javafx_simplecalculator.calculator;

import java.math.BigInteger;
import com.alphasoft.javafx_simplecalculator.entity.OperationEntity;

public class BigIntegerCalculator extends NumberCalculatorImpl<BigInteger>{
	
	@Override
	public Number calculate(String operation) {
		return super.calculate(operation);
	}
	
	@Override
	public BigInteger operate(OperationEntity<BigInteger> operationEntity) {
		try {
			BigInteger leftOperand = operationEntity.getLeftOperand();
			BigInteger rightOperand = operationEntity.getRightOperand();
			Operator operator = operationEntity.getOperator();
			
			switch(operator) {
				case PLUS:
					return leftOperand.add(rightOperand);
				case MINUS:
					return leftOperand.subtract(rightOperand);
				case MULTIPLICATION:
					return leftOperand.multiply(rightOperand);
				case DIVISION:
					return leftOperand.divide(rightOperand);
				default:
					throw new CalculatorException(CalculatorException.NO_OPERATOR_FOUND);
			}
		}catch(ArithmeticException ex) {
			throw new CalculatorException(CalculatorException.ARITHMETIC_ERROR);
		}
	}

	@Override
	public BigInteger valueOf(String value) {
		try {
			return new BigInteger(value);
		}catch(NumberFormatException ex) {
			throw new CalculatorException(CalculatorException.SYNTAX_ERROR);
		}
	}

	
	
}
