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
import project.model.Librarian;
import project.model.Patron;
import project.model.User;
import project.views.LibrarianMainMenuView;
import project.views.UserMainMenuView;

public class MainMenuController {
		
	public static void addBook(User loggedInUser, Stage stage, String titleIn, String authorIn, String genreIn, String bookIdIn, String publicationDateIn) {
		Book.addNewBook(titleIn, authorIn, genreIn, bookIdIn, publicationDateIn);
		LibrarianMainMenuView.librarianMainMenuView(stage, loggedInUser);
	}
	
	public static void removeBook(User loggedInUser, Stage stage, String bookId, String author, String title) {
		Book.removeBook(bookId, author, title);
		LibrarianMainMenuView.librarianMainMenuView(stage, loggedInUser);
	}
	
	public static void checkOutABook(User loggedInUser, Stage stage, String bookId, String author, String title) {
		Book.checkOutBook(bookId, title, author, loggedInUser);
		if(loggedInUser instanceof Librarian) {
			LibrarianMainMenuView.librarianMainMenuView(stage, loggedInUser);
		}
		else if(loggedInUser instanceof Patron) {
			UserMainMenuView.userMainMenuView(stage, loggedInUser);
		}
	}
	
	public static void returnABook(User loggedInUser, Stage stage, String bookId, String author, String title) {
		Book.returnABook(bookId, title, author);
		if(loggedInUser instanceof Librarian) {
			LibrarianMainMenuView.librarianMainMenuView(stage, loggedInUser);
		}
		else if(loggedInUser instanceof Patron) {
			UserMainMenuView.userMainMenuView(stage, loggedInUser);
		}
	}
}
