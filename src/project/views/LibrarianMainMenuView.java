//created by: kayla chapman

package project.views;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.model.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

public class LibrarianMainMenuView{
    static Scene scene5;

    public static void librarianMainMenuView(Stage stage, User loggedInUser){

		Button checkoutButton = new Button("Check Out a Book");
		//checkoutButton.setOnAction(e -> CheckoutController.checkout(???)); 
		Button returnButton = new Button("Return a Book");
		//returnButton.setOnAction(e -> ReturnController.return(???)); // new controller
		Button ratingButton = new Button("Rate and Review a Book");
		//ratingButton.setOnAction(e -> RatingController.rate(???));
		Button addButton = new Button("Add a Book to the Inventory");
		//addButton.setOnAction(e -> AddBookController.add(???)); //new controller
		Button removeButton = new Button("Remove a Book from Inventory");
		//removeButton.setOnAction(e -> RemoveBookController.removeBook(???)); //new controller
		Button lookUpButton = new Button("Look Up a User");
		//lookUpButton.setOnAction(e -> LookUpUserController.lookUp(???)); //new controller
		Button removeUserButton = new Button("Remove a User Profile");
		//removeUserButton.setOnAction(e -> RemoveUserController.removeUser(???)); //new controller
		Button editButton = new Button("Edit Profile");
		//editButton.setOnAction(e -> EditController.edit(???));
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

