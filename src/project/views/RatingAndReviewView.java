//created by: kayla chapman

package project.views;

//import project.controller.RatingAndReviewController; //im assuming it will be called that
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class RatingAndReviewView{
    static Scene scene6;
    static TextField ratingField, reviewField;

    public static void ratingAndReviewController(Stage stage){

        Label ratingLabel = new Label("Add Rating");
        ratingField = new TextField();
        Label reviewLabel = new Label("Add Review");
        reviewField = new TextField();
        Button submitButton = new Button("Submit");
        //submitButton.setOnAction(e -> RatingAndReviewController.submit(???)); // new controller

        Button logoutButton = new Button("Log Out");
		logoutButton.setOnAction(e -> Platform.exit());
        VBox layout6 = new VBox(20);
        layout6.setAlignment(Pos.CENTER);
        layout6.getChildren().addAll(ratingLabel, ratingField, reviewLabel, reviewField, submitButton, logoutButton);
        scene6 = new Scene(layout6, 400, 500);

        stage.setScene(scene6);
        stage.show();
    }
}
