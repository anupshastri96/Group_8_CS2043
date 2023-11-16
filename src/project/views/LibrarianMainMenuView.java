//created by: kayla chapman

package project.views;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.model.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.application.Platform;

public class LibrarianMainMenuView{
    static Scene scene5;

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
		//Text field to enter a bookID number can remove the book from the main menu controller and we won't need another view.
		//addButton.setOnAction(e -> MainMenuCotroller.addBook(bookToAddField.getText())); main menu controller
		Button removeButton = new Button("Remove a Book from Inventory");
		//Text field to enter a bookID number can remove the book from the main menu controller and we won't need another view.
		//removeButton.setOnAction(e -> MainMenuController.removeBook(???)); main menu controller
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
		layout5.getChildren().addAll(checkoutButton,returnButton,ratingButton,addButton,removeButton,lookUpButton,removeUserButton,editButton, logoutButton);
		scene5 = new Scene(layout5, 450, 700);

		stage.setScene(scene5);
		stage.show();

    }
}

