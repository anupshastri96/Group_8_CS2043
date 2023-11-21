//created by: kayla chapman

package project.views;

import project.controller.MainMenuController;
import project.model.User;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.application.Platform;

public class LibrarianMainMenuView{
    static Scene scene5;
    static TextField bookIdField, authorField, titleField, genreField, pubDateField, bookRemoveField;
    
    public static void librarianMainMenuView(Stage stage, User loggedInUser){

		Button checkoutButton = new Button("Check Out a Book");
		//Text field to enter id number - can be done through main menu
		//checkoutButton.setOnAction(e -> CheckoutController.checkout(???)); 
		Button returnButton = new Button("Return a Book");
		//Text field to enter id number - can be done through main menu
		//returnButton.setOnAction(e -> ReturnController.return(???)); // new controller
		Button ratingButton = new Button("Rate and Review a Book");
		//ratingButton.setOnAction(e -> RatingController.rate(???));
		Button addButton = new Button("Add a Book to the Inventory");
		Label bookId = new Label("Book ID:");
		bookIdField = new TextField();
		Label author = new Label("Author:");
		authorField = new TextField();
		Label title = new Label("Title:");
		titleField = new TextField();
		Label genre = new Label("Genre:");
		genreField = new TextField();
		Label pubDate = new Label("Publication Date:");
		pubDateField = new TextField();
		addButton.setOnAction(e -> MainMenuController.addBook(loggedInUser, stage, titleField.getText(), author.getText(), 
				genre.getText(), bookIdField.getText(), pubDateField.getText()));
		Button removeButton = new Button("Remove a Book from Inventory");
		Label removeBook = new Label("Book ID To Remove:");
		bookRemoveField = new TextField();
		removeButton.setOnAction(e -> MainMenuController.removeBook(loggedInUser, stage, bookIdField.getText()));
		Button lookUpButton = new Button("Look Up a User");
		//lookUpButton.setOnAction(e -> //mainMenu controller -> prints user info); //new controller
		Button removeUserButton = new Button("Remove a User Profile");
		//maybe add a textfield for a user name then we won't need another view for this one.
		//removeUserButton.setOnAction(e -> //may be done in mainMenuController?);
		Button editButton = new Button("Edit Profile");
		editButton.setOnAction(e -> EditProfileView.editProfileView(stage, loggedInUser));
		Button logoutButton = new Button("Log Out");
		logoutButton.setOnAction(e -> Platform.exit());
		VBox layout5 = new VBox(20);
		layout5.setAlignment(Pos.CENTER);
		layout5.getChildren().addAll(checkoutButton,returnButton,ratingButton,
				addButton,bookId,bookIdField,author,authorField,title,titleField,genre,genreField, pubDate, pubDateField,
				removeButton, removeBook, bookRemoveField, lookUpButton, removeUserButton, editButton, logoutButton);
		scene5 = new Scene(layout5, 450, 1000);

		stage.setScene(scene5);
		stage.show();

    }
}

