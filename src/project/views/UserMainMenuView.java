//created by: kayla chapman

package project.views;

import project.controller.UserMainMenuController; //im assuming it will be called that
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

public class UserMainMenuView{
    static Scene scene4;

    public static void userMainMenuView(Stage stage){

        Button checkoutButton = new Button("Check Out a Book");
        checkoutButton.setOnAction(e -> CheckoutController.checkout(???)); // new controller
		Button ratingButton = newButton("Rate and Review a Book");
		ratingButton.setOnAction(e -> RatingController.rate(???));// new controller
		Button currentCheckoutButton = new Button("Books Currently Checked Out");
		currentCheckoutButton.setOnAction(e -> CurrentScheckoutController.currentlyCheckedOut(???));// new controller
		Button reservedButton = new Button("Books Reserved");
		reservedButton.setOnAction(e -> ReservedController.currentlyReserved(???));// new controller
		Button recomendedButton = new Button("Recomended Books");
		recomendedButton.setOnAction(e -> RecomendedController.recomended(???));// new controller
		Button editButton = new Button("Edit Profile");
		Button logoutButton = new Button("Log Out");
		logoutButton.setOnAction(e -> Platform.exit());
		VBox layout4 = new VBox(20);
		layout4.setAlignment(Pos.CENTER);
		layout4.getChildren().addAll(checkoutButton, ratingButton, currentCheckoutButton, reservedButton, recomendedButton, editButton, logoutButton);
		scene4 = new Scene(layout4, 450, 700);

        stage.setScene(scene4);
        stage.show();
    }
