package com.alphasoft.javafx_simplecalculator.entity;

import com.alphasoft.javafx_simplecalculator.calculator.Calculator.Operator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperationEntity<T> {
	private T leftOperand;
	private T rightOperand;
	private Operator operator;
}
