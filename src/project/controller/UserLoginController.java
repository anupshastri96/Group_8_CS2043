package project.controller;

import project.model.User;
import project.views.UserLoginView;
import java.io.IOException;

import javafx.stage.Stage;

public class UserLoginController {

    private static User model;
    private static UserLoginView view;
    
    public static void login(String usernameField, String passwordField) {
    	
    	try {
			model = User.userLogIn(usernameField, passwordField);
		} catch (IOException e) {
			System.out.println("Username and password inccorrect");
			e.printStackTrace();
		}
    	System.out.println(model);
    	//user returned call next screen
    }
    
    public static void selectLogIn(Stage stage){
    	UserLoginView.userLoginView(stage);
    }

}

