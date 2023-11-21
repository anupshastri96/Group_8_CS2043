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
		Book newBook = new Book(titleIn, authorIn, genreIn, bookIdIn, publicationDateIn);
		Library.addBook(newBook);
		LibrarianMainMenuView.librarianMainMenuView(stage, loggedInUser);
	}
	
	public static void removeBook(User loggedInUser, Stage stage, String bookId) {
		Book.removeBook(bookId);
		LibrarianMainMenuView.librarianMainMenuView(stage, loggedInUser);
	}
}
