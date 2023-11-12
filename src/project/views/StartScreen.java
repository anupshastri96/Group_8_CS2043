package project.views;

import project.controller.UserLoginController;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartScreen extends Application{
		
	@Override
	public void start(final Stage primaryStage){
				
		UserLoginController.userSelectView(primaryStage);
	}
	
	public static void main(String args[]){
		launch(args);
	}
	
}

