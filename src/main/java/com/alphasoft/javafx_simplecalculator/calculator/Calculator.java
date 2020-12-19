package com.alphasoft.javafx_simplecalculator.calculator;

public interface Calculator<R> {
	
	R calculate(String operation);
	
	public enum Operator{
		PLUS("+"), MINUS("-"), MULTIPLICATION("×"), DIVISION("÷");
		
		private final String value;
		
		private Operator(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
	}
}
