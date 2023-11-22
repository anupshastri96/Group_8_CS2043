//created by: kayla chapman

package project.views;

import project.controller.MainMenuController;
import project.model.User;
import javafx.scene.layout.HBox;
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
    static TextField bookIdField, authorField, titleField, genreField, pubDateField, bookRemoveField, titleRemoveBookField, authorRemoveBookField;
    
    public static void librarianMainMenuView(Stage stage, User loggedInUser){

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
		
		HBox addBookBox = new HBox(8);
		addBookBox.setAlignment(Pos.CENTER);
		HBox addBookButton = new HBox();
		addBookButton.setAlignment(Pos.CENTER);
		HBox addBookLabel = new HBox(125);
		addBookLabel.setAlignment(Pos.CENTER);
		addBookLabel.getChildren().addAll(bookId, author, title, genre, pubDate);
		addBookBox.getChildren().addAll(bookIdField, authorField, titleField, genreField, pubDateField);
		addBookButton.getChildren().addAll(addButton);
		VBox bookLayout = new VBox(8);
		bookLayout.setAlignment(Pos.CENTER);
		String cssLayout = "-fx-border-color: blue;\n" +
                "-fx-border-insets: 3;\n" +
                "-fx-border-width: 2;\n" +
                "-fx-border-style: solid;\n";   
		bookLayout.setStyle(cssLayout);
		bookLayout.getChildren().addAll(addBookLabel, addBookBox, addBookButton);
		addButton.setOnAction(e -> MainMenuController.addBook(loggedInUser, stage, titleField.getText(), author.getText(), 
				genre.getText(), bookIdField.getText(), pubDateField.getText()));
    	
    	Button checkoutButton = new Button("Check Out a Book");
		//Text field to enter id number - can be done through main menu
		//checkoutButton.setOnAction(e -> CheckoutController.checkout(???)); 
		Button returnButton = new Button("Return a Book");
		//Text field to enter id number - can be done through main menu
		//returnButton.setOnAction(e -> ReturnController.return(???)); // new controller
		Button ratingButton = new Button("Rate and Review a Book");
		//ratingButton.setOnAction(e -> RatingController.rate(???));
		
		
		
		Button removeButton = new Button("Remove a Book from Inventory");
		
		Label removeBook = new Label("Book ID To Remove:");
		bookRemoveField = new TextField();
		Label titleRemoveBook = new Label("Title of Book to Remove:");
		titleRemoveBookField = new TextField();
		Label authorRemoveBook = new Label("Author of Book to Remove:");
		authorRemoveBookField = new TextField();
		
		HBox removeBookBox = new HBox(8);
		HBox removeBookButton = new HBox();
		removeBookButton.setAlignment(Pos.CENTER);
		removeBookBox.setAlignment(Pos.CENTER);
		removeBookBox.getChildren().addAll(removeBook, bookRemoveField, titleRemoveBook, titleRemoveBookField, 
				authorRemoveBook,authorRemoveBookField);
		removeBookButton.getChildren().addAll(removeButton);
		VBox removeBookLayout = new VBox(8);
		removeBookLayout.setAlignment(Pos.CENTER);
		removeBookLayout.setStyle(cssLayout);
		removeBookLayout.getChildren().addAll(removeBookButton, removeBookBox);
		removeButton.setOnAction(e -> MainMenuController.removeBook(loggedInUser, stage, bookRemoveField.getText(), 
				titleRemoveBookField.getText(),authorRemoveBookField.getText()));
		
		Button lookUpButton = new Button("Look Up a User");
		//lookUpButton.setOnAction(e -> //mainMenu controller -> prints user info); //new controller
		Button removeUserButton = new Button("Remove a User Profile");
		//maybe add a textfield for a user name then we won't need another view for this one.
		//removeUserButton.setOnAction(e -> //may be done in mainMenuController?);
		Button editButton = new Button("Edit Profile");
		editButton.setOnAction(e -> EditProfileView.editProfileView(stage, loggedInUser));
		Button logoutButton = new Button("Log Out");
		logoutButton.setOnAction(e -> Platform.exit());
		VBox layout5 = new VBox(15);
		layout5.setAlignment(Pos.CENTER);
		layout5.getChildren().addAll(checkoutButton,returnButton,ratingButton, bookLayout,
				removeBookLayout, lookUpButton, removeUserButton, editButton, logoutButton);
		scene5 = new Scene(layout5, 900, 700);

		stage.setScene(scene5);
		stage.show();

    }
}

