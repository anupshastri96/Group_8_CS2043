//created by: kayla chapman

package project.views;

import project.controller.newUserController; //im assuming it will be called that
import javafx.application.Application;
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


public class NewUserView{
    static Scene scene3;
    static TextField nameField, streetField, cityField, postCodeField, phoneField, newUsernameField, newPasswordField, rePasswordField;

    public static void newUserView(Stage stage){

        Label nameLabel = new Label("Name:");
		nameField = new TextField();
		Label streetLabel = new Label("Street:");
		streetField = new TextField();
		Label cityLabel = new Label("City:");
		cityField = new TextField();
		ComboBox<String> provinceCombo = new ComboBox<String>();
		ObservableList<String> provinceBox = provinceCombo.getItems();
		provinceCombo.setPromptText("Province:");
		provinceBox.add("AB");
		provinceBox.add("BC");
		provinceBox.add("MB");
		provinceBox.add("NB");
		provinceBox.add("NL");
		provinceBox.add("NS");
		provinceBox.add("NT");
		provinceBox.add("NU");
		provinceBox.add("ON");
		provinceBox.add("PE");
		provinceBox.add("QC");
		provinceBox.add("SK");
		provinceBox.add("YT");
		Label postCodeLabel = new Label("Postal Code:");
		postCodeField = new TextField();
		Label phoneLabel = new Label("Phone:");
		phoneField = new TextField();
		Label newUsernameLabel = new Label("User Name:");
		newUsernameField = new TextField();
		Label newPasswordLabel = new Label("Password:");
		newPasswordField = new TextField();
		Label rePasswordLabel = new Label("Re-enter Password:");
		rePasswordField = new TextField();
		Button signUpButton = new Button("Sign up");
		//signUpButton.setOnAction(this::processSignUpRequest);
		signUpButton.setOnAction(e -> SignUpComtroller.signUp(scene)); //thi will have to be a new controller
		VBox layout3 = new VBox(20);
		layout3.setAlignment(Pos.CENTER);
		layout3.getChildren().addAll(nameLabel, nameField, streetLabel, streetField, cityLabel, cityField, provinceCombo, postCodeLabel, postCodeField, phoneLabel, phoneField, newUsernameLabel, newUsernameField, newPasswordLabel, newPasswordField, rePasswordLabel, rePasswordField, signUpButton);
		scene3 = new Scene(layout3, 450, 700);

        stage.setScene(scene3);
        stage.show();
    }
}