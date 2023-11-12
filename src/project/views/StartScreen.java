package project.views;

import project.controller.UserLoginController;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;


public class StartScreen extends Application{
	
	Scene scene0;
	
	@Override
	public void start(final Stage primaryStage){
				
		primaryStage.setTitle("Starting programe");
		primaryStage.setScene(scene0);
		primaryStage.show();
		UserLoginController.userSelectView(primaryStage);
	}
	
	public static void main(String args[]){
		launch(args);
	}
	
}

