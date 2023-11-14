package project.controller;

import javafx.stage.Stage;
import project.model.Library;
import project.model.Patron;
import project.model.User;
import project.views.NewUserView;

public class NewUserController {
	
	private static User model;
		
	public static void createUser(Stage stage, String name, String newUsername, String rePassword, String address, int phone) {
		if(!Library.findUsername(newUsername)) {
			model = Patron.createPatron(name, newUsername, rePassword, address, phone);
			
			Library.addUser(model);
		}
		else if(Library.findUsername(newUsername)) {
			goBackNewUserView(stage);
		}
	}
	
	public static void goBackNewUserView(Stage stage) {
    	NewUserView.newUserView(stage);
    }
  
}
