/**
Module Name: UserLoginController
Date Created: 2023-11-10
Created By: Sarah Flynn
Class manages direction from UserLogin View and sends
information to the User model.
Functions:
	login()
	selectLogin()
	userSelect()
**/
package project.controller;

import project.model.Librarian;
import project.model.Patron;
import project.model.User;
import project.views.LibrarianMainMenuView;
import project.views.EditProfileView;
import project.views.UserLoginView;
import project.views.UserMainMenuView;
import project.views.UserSelectView;
import java.io.IOException;
import javafx.stage.Stage;

public class UserLoginController {

    private static User model;
       
    public static void login(String username, String password, Stage stage) {
    	
    	try {
			model = User.userLogIn(username, password);
			if (model == null) {
				userSelect(stage);
			}
			else if (model instanceof Librarian) {
				
				if(model.getName().equals("Replace")) {
					EditProfileView.editProfileView(stage, model);
				}
				else if(!model.getName().equals("Replace")){
					LibrarianMainMenuView.librarianMainMenuView(stage, model);
				}
						
			}
			else if (model instanceof Patron) {
				UserMainMenuView.userMainMenuView(stage, model);
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

