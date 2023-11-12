/**
Module Name: UserSelectView
Date Created: 2023-11-10
Created By: Kayla Chapman and Sarah Flynn
Class allows the user to select create a user or login.
Functions:
	userSelectView()
**/
package project.views;

import project.controller.UserLoginController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class UserSelectView{
	static Scene scene1;
			 
	public static void userSelectView(Stage stage) {
				
		stage.setTitle("Login Page");
		Button userLoginButton = new Button("User Login");
		Button newUserButton = new Button("Create New User");
		userLoginButton.setOnAction(e -> UserLoginController.selectLogIn(stage));
		//newUserButton.setOnAction(e -> primaryStage.setScene(scene3));// send to controller -> call scene3
		
		VBox layout1 = new VBox(20);
		layout1.setAlignment(Pos.CENTER);
		layout1.getChildren().addAll(userLoginButton, newUserButton);
		scene1 = new Scene(layout1, 300, 250);
       
		stage.setScene(scene1);
		stage.show();
	}
		
}