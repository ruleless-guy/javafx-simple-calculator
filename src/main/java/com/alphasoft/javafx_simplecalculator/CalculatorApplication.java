package com.alphasoft.javafx_simplecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorApplication extends Application {
	
    public static void execute( String[] args ) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/com/alphasoft/javafx_simplecalculator/view/calculator.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple Calculator");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}

