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
		if (!name.trim().equals("")) {
			User.updateName(loggedInUser, name);
		}
		if (!newUsername.trim().equals("")) {
			User.updateUsername(loggedInUser, newUsername);
		}
		if (!rePassword.trim().equals("")) {
			User.updatePassword(loggedInUser, rePassword);
		}
		if (!address.trim().equals("")) {
			String[] newAddressArray = address.split(",");
			String[] oldAddressArray = loggedInUser.getAddress().split(",");
			String updatedAddress = "";
			for(int i = 0; i < newAddressArray.length; ++i) {
				System.out.println("Changed address:" + newAddressArray[i]);
				System.out.println("oldAddress : " + oldAddressArray[i]);
				System.out.println("newaddress : " + updatedAddress);
				
				if(newAddressArray[i].equals("")) {
					updatedAddress += oldAddressArray[i]+ ",";
				}
				else if(!newAddressArray[i].equals("")) {
					updatedAddress += newAddressArray[i] + ",";
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
