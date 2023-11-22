/**
Module Name: MainMenuController
Date Created: 2023-11-16
Created By: Sarah Flynn
Class manages and gives information from MainMenu to other controllers.
Functions:
	updateUser()
	goToMainMenuView()
**/
package project.controller;

import javafx.stage.Stage;
import project.model.Book;
import project.model.Library;
import project.model.User;
import project.views.LibrarianMainMenuView;

public class MainMenuController {
		
	public static void addBook(User loggedInUser, Stage stage, String titleIn, String authorIn, String genreIn, String bookIdIn, String publicationDateIn) {
		Book.addNewBook(titleIn, authorIn, genreIn, bookIdIn, publicationDateIn);
		LibrarianMainMenuView.librarianMainMenuView(stage, loggedInUser);
	}
	
	public static void removeBook(User loggedInUser, Stage stage, String bookId, String author, String title) {
		Book.removeBook(bookId, author, title);
		LibrarianMainMenuView.librarianMainMenuView(stage, loggedInUser);
	}
}
