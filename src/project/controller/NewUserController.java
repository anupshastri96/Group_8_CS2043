/**
Module Name: NewUserController
Date Created: 2023-11-14
Created By: Sarah Flynn
Class manages and gives information from NewUserView to create a new user.
Functions:
	createUser()
	goBackNewUserView()
**/
package project.controller;

import javafx.stage.Stage;
import project.model.Library;
import project.model.Patron;
import project.views.NewUserView;
import project.views.UserMainMenuView;

public class NewUserController {
	
	private static Patron patronModel;
		
	public static void createUser(Stage stage, String name, String newUsername, String rePassword, String address, int phone) {
		if(!Library.findUsername(newUsername)) {
			patronModel = Patron.createPatron(name, newUsername, rePassword, address, phone);
			System.out.println("New Patron created: \n" + patronModel);
			UserMainMenuView.userMainMenuView(stage, patronModel);
		}
		else if(Library.findUsername(newUsername)) {
			goBackNewUserView(stage);
			System.out.println("Username already being used");
		}
	}
	
	public static void goBackNewUserView(Stage stage) {
    	NewUserView.newUserView(stage);
    }
  
}
