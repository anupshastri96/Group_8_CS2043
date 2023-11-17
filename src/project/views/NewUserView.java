//created by: kayla chapman

package project.views;

import project.controller.NewUserController;
import javafx.scene.control.ComboBox;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

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
		phoneField.setTextFormatter(new TextFormatter<>(new IntegerStringConverter()));
		phoneField.textProperty().addListener((obs,oldv,newv) -> {
		    try {
		        phoneField.getTextFormatter().getValueConverter().fromString(newv);
		        phoneField.setBorder(null);
		    } catch (NumberFormatException e) {
		        phoneField.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(3), new BorderWidths(2), new Insets(-2))));
		    }
		});
		
		Label newUsernameLabel = new Label("User Name:");
		newUsernameField = new TextField();
		Label newPasswordLabel = new Label("Password:");
		newPasswordField = new TextField();
		Label rePasswordLabel = new Label("Re-enter Password:");
		rePasswordField = new TextField();
	
		Button signUpButton = new Button("Sign up");
		Button logoutButton = new Button("Log Out");
		logoutButton.setOnAction(e -> Platform.exit());

		VBox layout3 = new VBox(20);
		layout3.setAlignment(Pos.CENTER);
		layout3.getChildren().addAll(nameLabel, nameField, streetLabel, streetField, cityLabel, cityField, provinceCombo, postCodeLabel, postCodeField, phoneLabel, phoneField, newUsernameLabel, newUsernameField, newPasswordLabel, newPasswordField, rePasswordLabel, rePasswordField, signUpButton, logoutButton);
		scene3 = new Scene(layout3, 450, 800);

		stage.setScene(scene3);
		stage.show();
        
		signUpButton.setOnAction(e -> 
		{	
			String name = nameField.getText().toString();
			String[] address = getAddress(streetField.getText().toString(), cityField.getText().toString(), provinceCombo.getValue().toString(), postCodeField.getText().toString());
			int phone = Integer.parseInt(phoneField.getText());
			String username = newUsernameField.getText().toString();
			String rePassword = rePasswordField.getText().toString();
			NewUserController.createUser(stage, name, username, rePassword, address, phone); }
		);
    }
    
    private static String[] getAddress(String street, String city, String prov, String postCode) {
		String[] addressArray = new String[4];
		addressArray[0] = street;
		addressArray[1] = city;
		addressArray[2] = prov;
		addressArray[3] = postCode;
		return addressArray;
	}
}