//created by: kayla chapman

package project.views;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.model.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

public class UserMainMenuView{
    static Scene scene4;

    public static void userMainMenuView(Stage stage, User loggedInUser){

        Button checkoutButton = new Button("Check Out a Book");
        //checkoutButton.setOnAction(e -> CheckoutController.checkout(???)); // new controller
		Button ratingButton = new Button("Rate and Review a Book");
		//ratingButton.setOnAction(e -> RatingController.rate(???));// new controller
		Button currentCheckoutButton = new Button("Books Currently Checked Out");
		//currentCheckoutButton.setOnAction(e -> CurrentScheckoutController.currentlyCheckedOut(???));// new controller
		Button reservedButton = new Button("Books Reserved");
		//reservedButton.setOnAction(e -> ReservedController.currentlyReserved(???));// new controller
		Button recomendedButton = new Button("Recomended Books");
		//recomendedButton.setOnAction(e -> RecomendedController.recomended(???));// new controller
		Button editButton = new Button("Edit Profile");
		//editButton.setOnAction(e -> EditProfileView(stage, loggedInUser));
		VBox layout4 = new VBox(20);
		layout4.setAlignment(Pos.CENTER);
		layout4.getChildren().addAll(checkoutButton, ratingButton, currentCheckoutButton, reservedButton, recomendedButton, editButton);
		scene4 = new Scene(layout4, 450, 700);

        stage.setScene(scene4);
        stage.show();
    }
}
