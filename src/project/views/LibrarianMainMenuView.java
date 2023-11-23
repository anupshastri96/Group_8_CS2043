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
    static TextField bookIdField, authorField, titleField, genreField, pubDateField, bookField, 
    titleBookField, authorBookField, bookCheckField, titleCheckField;
    
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
		String cssLayout = "-fx-background-color:skyblue, derive(skyblue, 25%), derive(skyblue, 50%), derive(skyblue, 75%); \n" +
				"-fx-background-insets: 5, 10, 20, 30;\n" +
				"-fx-border-color: grey;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: solid;\n";   
		bookLayout.setStyle(cssLayout);
		bookLayout.getChildren().addAll(addBookLabel, addBookBox, addBookButton);
		addButton.setOnAction(e -> MainMenuController.addBook(loggedInUser, stage, titleField.getText(), author.getText(), 
				genre.getText(), bookIdField.getText(), pubDateField.getText()));
		
		Button lookUpButton = new Button("Look Up a User");
		//lookUpButton.setOnAction(e -> //mainMenu controller -> prints user info); //new controller
		Button removeUserButton = new Button("Remove a User Profile");
		//maybe add a textfield for a user name then we won't need another view for this one.
		//removeUserButton.setOnAction(e -> //may be done in mainMenuController?);
		Button editButton = new Button("Edit Profile");
		editButton.setOnAction(e -> EditProfileView.editProfileView(stage, loggedInUser));
    	
		Button ratingButton = new Button("Rate and Review a Book");
		//ratingButton.setOnAction(e -> RatingController.rate(???));
		
		Button returnButton = new Button("Return a Book");
		Button checkoutButton = new Button("Check Out a Book");
		Button removeButton = new Button("Remove a Book from Inventory");
		
		Label book = new Label("Book ID:");
		bookField = new TextField();
		Label titleBook = new Label("Title:");
		titleBookField = new TextField();
		Label authorBook = new Label("Author:");
		authorBookField = new TextField();
		
		HBox bookBox = new HBox(8);
		HBox bookButton = new HBox(5);
		bookButton.setAlignment(Pos.CENTER);
		bookBox.setAlignment(Pos.CENTER);
		bookBox.getChildren().addAll(book, bookField, titleBook, titleBookField, 
				authorBook, authorBookField);
		bookButton.getChildren().addAll(removeButton, checkoutButton, returnButton, ratingButton);
		VBox bookLayout1 = new VBox(8);
		bookLayout1.setAlignment(Pos.CENTER);
		bookLayout1.setStyle(cssLayout);
		bookLayout1.getChildren().addAll(bookBox, bookButton);
		
		removeButton.setOnAction(e -> MainMenuController.removeBook(loggedInUser, stage, bookField.getText(), 
				titleBookField.getText(),authorBookField.getText()));
    	checkoutButton.setOnAction(e -> MainMenuController.checkOutABook(loggedInUser, stage, bookField.getText(), 
				titleBookField.getText(),authorBookField.getText()));
		returnButton.setOnAction(e -> MainMenuController.returnABook(loggedInUser, stage, bookField.getText(), 
				titleBookField.getText(),authorBookField.getText()));
		
		
		Button logoutButton = new Button("Log Out");
		logoutButton.setOnAction(e -> Platform.exit());
		VBox layout5 = new VBox(15);
		layout5.setAlignment(Pos.CENTER);
		layout5.getChildren().addAll(bookLayout1,bookLayout, lookUpButton, removeUserButton, editButton, logoutButton);
		scene5 = new Scene(layout5, 900, 700);

		stage.setScene(scene5);
		stage.show();

    }
}

