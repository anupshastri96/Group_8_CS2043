package project.views;

import project.controller.UserLoginController;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class StartScreen extends Application{
	
	Scene scene1;
	//private Stage primaryStage;
	
	@Override
	public void start(final Stage primaryStage){
				
		primaryStage.setTitle("Login Page");
		Button userLoginButton = new Button("User Login");
		Button newUserButton = new Button("Create New User");
		userLoginButton.setOnAction(e -> UserLoginController.selectLogIn(primaryStage));
		//newUserButton.setOnAction(e -> primaryStage.setScene(scene3));// send to controller -> call scene3
		
		VBox layout1 = new VBox(20);
		layout1.setAlignment(Pos.CENTER);
		layout1.getChildren().addAll(userLoginButton, newUserButton);
		scene1 = new Scene(layout1, 300, 250);
       
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	
	public static void main(String args[]){
		launch(args);
	}
	
}

