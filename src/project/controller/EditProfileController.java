/**
Module Name: EditProfileController
Date Created: 2023-11-16
Created By: Sarah Flynn
Class manages and gives information from MainMenu and EditProfileView to update user information.
Functions:
	updateUser()
**/

package project.controller;

import javafx.stage.Stage;
import project.model.Librarian;
import project.model.Patron;
import project.model.User;
import project.views.LibrarianMainMenuView;
import project.views.UserMainMenuView;

public class EditProfileController {

	public static void updateUser(User loggedInUser, Stage stage, String name, String newUsername, String rePassword, String address, int phone) {
		if (!name.equals("")) {
			User.updateName(loggedInUser, name);
		}
		if (!newUsername.equals("")) {
			User.updateUsername(loggedInUser, newUsername);
		}
		if (!rePassword.equals("")) {
			User.updatePassword(loggedInUser, rePassword);
		}
		if (!address.equals("")) {
			//comma separated this will need a method to parse 
			//the information back into order without deleting information if left blank
			User.updateAddress(loggedInUser, newUsername);
		}
		if(phone != 0) {
			//if left blank what is passed, may need a default value
			User.updatePhone(loggedInUser, phone);
		}
		if(loggedInUser instanceof Patron) {
			System.out.println("Patron updated : " + loggedInUser);
			UserMainMenuView.userMainMenuView(stage, loggedInUser);
		}
		else if(loggedInUser instanceof Librarian) {
			System.out.println("Librarian updated : " + loggedInUser);
			LibrarianMainMenuView.librarianMainMenuView(stage, loggedInUser);
		}
	}
	
}
