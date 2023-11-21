/**
Module Name: UserLoginView
Date Created: 2023-11-10
Created By: Kayla Chapman and Sarah Flynn
Class that shows the login user interface
Functions:
	userLoginView()
**/

package project.views;

import project.controller.UserLoginController;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserLoginView{
	static Scene scene2;
	private static TextField usernameField;
	private static TextField passwordField;
		 
	public static void userLoginView(Stage stage) {
				
		Label usernameLabel = new Label("Enter User Name");
		usernameField = new TextField();
		Label passwordLabel = new Label("Enter Password");
		passwordField = new TextField();
		Button loginButton = new Button("Login");
		
	    	    
		loginButton.setOnAction(e -> UserLoginController.login(usernameField.getText().toString(), passwordField.getText().toString(), stage));
		Button logoutButton = new Button("Log Out");
		logoutButton.setOnAction(e -> Platform.exit());
		VBox layout2 = new VBox(20);
		layout2.setAlignment(Pos.CENTER);
		layout2.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton, logoutButton);
		scene2 = new Scene(layout2, 300, 250);
		
		stage.setScene(scene2);
		stage.show();
	}
		
}
