package com.alphasoft.javafx_simplecalculator.calculator;

public interface Calculator<R> {
	
	R calculate(String operation);
	
	public enum Operator{
		PLUS("+"), MINUS("-"), TIMES("×"), OBELUS("÷");
		
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
