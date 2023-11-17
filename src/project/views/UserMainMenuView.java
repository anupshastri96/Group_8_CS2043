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

public class UserMainMenuView{
    static Scene scene4;
    static TextField ratingBookField;
    
    public static void userMainMenuView(Stage stage, User loggedInUser){

        Button checkoutButton = new Button("Check Out a Book");
        //Text field to enter id number - can be done through main menu
        //checkoutButton.setOnAction(e -> CheckoutController.checkout(???)); 
		
        Button ratingButton = new Button("Rate and Review a Book");
        Label bookId = new Label("Book ID:");
		ratingBookField = new TextField();
		ratingButton.setOnAction(e -> MainMenuController.getBookToReview(stage, loggedInUser, ratingBookField.getText()));
		
		Button currentCheckoutButton = new Button("Books Currently Checked Out");
		//currentCheckoutButton.setOnAction(e -> MainMenuController.getBooksCheckedOut(stage, loggedInUser) ); //print list in terminal for now
		
		Button reservedButton = new Button("Books Reserved");
		//reservedButton.setOnAction(e -> //mainmenucontroller print list in terminal for now));
		
		Button recomendedButton = new Button("Recomended Books");
		//recomendedButton.setOnAction(e ->//mainmenucontroller print list in terminal for now));
		
		Button editButton = new Button("Edit Profile");
		editButton.setOnAction(e -> EditProfileView.editProfileView(stage, loggedInUser));
		
		Button logoutButton = new Button("Log Out");
		logoutButton.setOnAction(e -> Platform.exit());
		VBox layout4 = new VBox(20);
		layout4.setAlignment(Pos.CENTER);
		layout4.getChildren().addAll(checkoutButton, bookId, ratingBookField, ratingButton, currentCheckoutButton, reservedButton, recomendedButton, editButton, logoutButton);
		scene4 = new Scene(layout4, 450, 700);

        stage.setScene(scene4);
        stage.show();
    }
}
