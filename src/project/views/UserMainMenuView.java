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

public class UserMainMenuView{
    static Scene scene4;
    static TextField bookField, titleBookField, authorBookField;
    
    public static void userMainMenuView(Stage stage, User loggedInUser){
  
		Button currentCheckoutButton = new Button("Books Currently Checked Out");
		//currentCheckoutButton.setOnAction(e -> MainMenuController.getBooksCheckedOut(stage, loggedInUser) ); //print list in terminal for now
		Button reservedButton = new Button("Books Reserved");
		//reservedButton.setOnAction(e -> //mainmenucontroller print list in terminal for now));
		Button recomendedButton = new Button("Recomended Books");
		//recomendedButton.setOnAction(e ->//mainmenucontroller print list in terminal for now));
		
		Label book = new Label("Book ID:");
		bookField = new TextField();
		Label titleBook = new Label("Title:");
		titleBookField = new TextField();
		Label authorBook = new Label("Author:");
		authorBookField = new TextField();
		Button checkoutButton = new Button("Check Out a Book");
        Button ratingButton = new Button("Rate and Review a Book");
		
        HBox bookBox = new HBox(8);
		HBox bookButton = new HBox(5);
		bookButton.setAlignment(Pos.CENTER);
		bookBox.setAlignment(Pos.CENTER);
		bookBox.getChildren().addAll(book, bookField, titleBook, titleBookField, 
				authorBook, authorBookField);
		bookButton.getChildren().addAll(checkoutButton, ratingButton);
		VBox bookLayout = new VBox(8);
		bookLayout.setAlignment(Pos.CENTER);
		String cssLayout = "-fx-background-color:skyblue, derive(skyblue, 25%), derive(skyblue, 50%), derive(skyblue, 75%); \n" +
				"-fx-background-insets: 5, 10, 20, 30;\n" +
				"-fx-border-color: grey;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: solid;\n"; 
		bookLayout.setStyle(cssLayout);
		bookLayout.getChildren().addAll(bookBox, bookButton);
		
		checkoutButton.setOnAction(e -> MainMenuController.checkOutABook(loggedInUser, stage, bookField.getText(), 
				titleBookField.getText(),authorBookField.getText()));
		ratingButton.setOnAction(e -> RatingAndReviewView.ratingAndReviewView(loggedInUser, stage));
		
		Button editButton = new Button("Edit Profile");
		editButton.setOnAction(e -> EditProfileView.editProfileView(stage, loggedInUser));
		
		Button logoutButton = new Button("Log Out");
		logoutButton.setOnAction(e -> Platform.exit());
		
		VBox layout4 = new VBox(20);
		layout4.setAlignment(Pos.CENTER);
		layout4.getChildren().addAll(bookLayout, currentCheckoutButton, reservedButton, recomendedButton, editButton, logoutButton);
		scene4 = new Scene(layout4, 700, 700);

        stage.setScene(scene4);
        stage.show();
    }
}
