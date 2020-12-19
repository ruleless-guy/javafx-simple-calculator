package com.alphasoft.javafx_simplecalculator.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.alphasoft.javafx_simplecalculator.entity.OperationEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BigDecimalCalculator extends NumberCalculatorImpl<BigDecimal>{
	
	
	private int decimalPlace = 14;
	
	private RoundingMode roundingMode = RoundingMode.HALF_UP;

	@Override
	public Number calculate(String operation) {
		return super.calculate(operation);
	}

	@Override
	public BigDecimal operate(OperationEntity<BigDecimal> operationEntity) {
		try {
			BigDecimal leftOperand = operationEntity.getLeftOperand();
			BigDecimal rightOperand = operationEntity.getRightOperand();
			Operator operator = operationEntity.getOperator();
			
			switch(operator) {
				case PLUS:
					return leftOperand.add(rightOperand);
				case MINUS:
					return leftOperand.subtract(rightOperand);
				case MULTIPLICATION:
					return leftOperand.multiply(rightOperand);
				case DIVISION:
					return leftOperand.divide(rightOperand, decimalPlace, roundingMode);
				default:
					throw new CalculatorException(CalculatorException.NO_OPERATOR_FOUND);
			}
		}catch(ArithmeticException ex) {
			throw new CalculatorException(CalculatorException.ARITHMETIC_ERROR);
		}
	}

	@Override
	public BigDecimal valueOf(String value) {
		try {
			return new BigDecimal(value);
		}catch(NumberFormatException ex) {
			throw new CalculatorException(CalculatorException.SYNTAX_ERROR);
		}
	}

}
