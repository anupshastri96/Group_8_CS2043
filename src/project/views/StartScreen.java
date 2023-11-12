/**
Module Name: StartScrenn
Date Created: 2023-11-10
Created By: Kayla Chapman and Sarah Flynn
Class begins starts the application
Functions:
	main()
	start()
**/
package project.views;

import project.controller.UserLoginController;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartScreen extends Application{
		
	@Override
	public void start(final Stage primaryStage){
				
		UserLoginController.userSelect(primaryStage);
	}
	
	public static void main(String args[]){
		launch(args);
	}
	
}

