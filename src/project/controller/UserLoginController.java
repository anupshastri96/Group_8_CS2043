package project.controller;

import project.model.Librarian;
import project.model.Patron;
import project.model.User;
import project.views.UserLoginView;
import project.views.UserSelectView;
import java.io.IOException;
import javafx.stage.Stage;

public class UserLoginController {

    private static User model;
    private static UserLoginView view;
    
    public static void login(String usernameField, String passwordField, Stage stage) {
    	
    	try {
			model = User.userLogIn(usernameField, passwordField);
			if (model == null) {
				userSelect(stage);
			}
			else if (model instanceof Librarian) {
				//go to librarian main menu
			}
			else if (model instanceof Patron) {
				//go to Patron main menu
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.out.println(model);
    }
    
    public static void selectLogIn(Stage stage){
    	UserLoginView.userLoginView(stage);
    }
    
    public static void userSelect(Stage stage) {
    	UserSelectView.userSelectView(stage);
    }

}

