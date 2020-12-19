package com.alphasoft.javafx_simplecalculator.view.controller;

import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;

import com.alphasoft.javafx_simplecalculator.calculator.BigDecimalCalculator;
import com.alphasoft.javafx_simplecalculator.calculator.BigIntegerCalculator;
import com.alphasoft.javafx_simplecalculator.calculator.Calculator;
import com.alphasoft.javafx_simplecalculator.calculator.CalculatorException;
import com.alphasoft.javafx_simplecalculator.calculator.DoubleCalculator;
import com.alphasoft.javafx_simplecalculator.calculator.NumberCalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class CalculatorController implements Initializable{
	
	@FXML
	private Label resultLabel;
	
	@FXML
	private ComboBox<NumberCalculator> calculatorSelector;
	
	private boolean start;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		NumberCalculator bigDecimalCalculator = new BigDecimalCalculator(30,RoundingMode.HALF_UP);
		NumberCalculator doubleCalculator = new DoubleCalculator();
		NumberCalculator bigIntegerCalculator = new BigIntegerCalculator();
		ObservableList<NumberCalculator> calculatorList = FXCollections.observableArrayList();
		calculatorList.addAll(bigDecimalCalculator, bigIntegerCalculator, doubleCalculator);
		
		calculatorSelector.getItems().addAll(calculatorList);
	}
	
	@FXML
	public void onInputEnter(ActionEvent event) {
		if(start) {
			onClearResult();
			start = false;
		}
		
		Button btn = (Button) event.getSource();
		String btnText = btn.getText();
		
		StringBuilder sb = new StringBuilder();
		sb.append(resultLabel.getText()).append(btnText);
		
		resultLabel.setText(sb.toString());
	}
	
	@FXML
	public void onCalculate() {
		String operation = resultLabel.getText();
		Calculator<? extends Number> calculator = calculatorSelector.getValue();
		
		if( null == calculator ) {
			resultLabel.setText("Please select a calculator");
			start = true;
			return;
		}
		
		try {
			Number result = calculator.calculate(operation);
			resultLabel.setText(trimZero(result.toString()));
		}catch(CalculatorException ex) {
			resultLabel.setText(ex.getMessage());
		}finally {
			start = true;
		}
	}
	
	@FXML
	public void onClearResult() {
		resultLabel.setText("");
	}
	
	@FXML
	public void onDeleteResult() {
		if(start) {
			onClearResult();
			return;
		}
		
		String result = resultLabel.getText();
		if( !result.isEmpty()) {
			result = result.substring(0, result.length() - 1);
			resultLabel.setText(result);
		}
	}
	
	private String trimZero(String value) {
		int index = value.length();
		if(value.contains(".")) {
			for(int i = value.length()-1; i >= 0; i--) {
				if(value.charAt(i) == '.') {
					--index;
					break;
				}
				
				if(value.charAt(i) == '0') {
					--index;
				}else {
					break;
				}
			}
		}
		return value.substring(0,index);
	}
	
}
