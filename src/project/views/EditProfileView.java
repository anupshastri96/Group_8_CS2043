//created by: kayla chapman

package project.views;

import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.controller.EditProfileController;
import project.model.User;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class EditProfileView{
    static Scene scene7;
    static TextField nameField, streetField, cityField, postCodeField, phoneField, newUsernameField, newPasswordField, rePasswordField;

    public static void editProfileView(Stage stage, User loggedInUser){

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

		Button saveChangesButton = new Button("Save Changes");
        Button logoutButton = new Button("Log Out");
		logoutButton.setOnAction(e -> Platform.exit());
				
		VBox layout7 = new VBox(20);
		layout7.setAlignment(Pos.CENTER);
		layout7.getChildren().addAll(nameLabel, nameField, streetLabel, streetField, cityLabel, cityField, provinceCombo, postCodeLabel, postCodeField, phoneLabel, phoneField, newUsernameLabel, newUsernameField, newPasswordLabel, newPasswordField, rePasswordLabel, rePasswordField, saveChangesButton, logoutButton);
	
		scene7 = new Scene(layout7, 450, 800);

        stage.setScene(scene7);
        stage.show();
        
        saveChangesButton.setOnAction(e -> 
        	{String username = newUsernameField.getText();
        		String name = nameField.getText();
        		String province;
        		if(provinceCombo.getValue() == null) {
        			province = "";
        		}
        		else {
        			province = provinceCombo.getValue().toString();
        		}
        		String address = streetField.getText().toString() + "," +  cityField.getText().toString() + "," + province + "," + postCodeField.getText().toString();
        		
        		int phone = 0;
        		if(phoneField.getText().toString().equals("")) {
        			phone = 0;
        		}
        		else {
        		 phone = Integer.parseInt(phoneField.getText());
        		}
        		String rePassword = rePasswordField.getText();
        		EditProfileController.updateUser(loggedInUser, stage, name, username, rePassword, address, phone); });
    }
}
