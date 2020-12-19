package com.alphasoft.javafx_simplecalculator.calculator;

public class CalculatorException extends RuntimeException{
	
	private static final long serialVersionUID = -9204672977922137768L;
	
	public static final String SYNTAX_ERROR = "Syntax Error";
	public static final String ARITHMETIC_ERROR = "Arithmetic Error";
	public static final String NO_OPERATOR_FOUND = "No Operator Found";

	public CalculatorException(String message) {
		super(message);
	}
}
