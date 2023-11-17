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

	public static void updateUser(User loggedInUser, Stage stage, String name, String newUsername, String rePassword, String[] address, int phone) {
		if(!name.trim().equals("")) {
			User.updateName(loggedInUser, name);
		}
		if(!newUsername.trim().equals("")) {
			User.updateUsername(loggedInUser, newUsername);
		}
		if(!rePassword.trim().equals("")) {
			User.updatePassword(loggedInUser, rePassword);
		}
		if(address.length != 0) {
			String[] oldAddressArray = loggedInUser.getAddress();
			String[] updatedAddress = new String[4];
			
			for(int i = 0; i < address.length; ++i) {				
				if(address[i].equals("")) {
					updatedAddress[i] = oldAddressArray[i];
				}
				else if(!address[i].equals(",")) {
					updatedAddress[i] = address[i];
				}
			}
			User.updateAddress(loggedInUser, updatedAddress);
		}
		if(phone != 0) {
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
