//created by: kayla chapman

package project;

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

public class LoginView extends Application{
	Scene scene1,scene2,scene3;
	private TextField usernameField, passwordField, nameField, streetField, cityField, postCodeField, phoneField, newUsernameField, newPasswordField, rePasswordField;
	public void start(Stage primaryStage){
		primaryStage.setTitle("Login Page");
		
		Button userLoginButton = new Button("User Login");
		//Button librarianLoginButton = new Button("Librarian Login");
		Button newUserButton = new Button("Create New User");
		userLoginButton.setOnAction(e -> primaryStage.setScene(scene2));
		//librarianLoginButton.setOnAction(e -> primaryStage.setScene(scene2));
		newUserButton.setOnAction(e -> primaryStage.setScene(scene3));
		VBox layout1 = new VBox(20);
		layout1.setAlignment(Pos.CENTER);
		layout1.getChildren().addAll(userLoginButton /*librarianLoginButton*/, newUserButton);
		scene1 = new Scene(layout1, 300, 250);
        
		Label usernameLabel = new Label("Enter User Name");
		usernameField = new TextField();
		Label passwordLabel = new Label("Enter Password");
		passwordField = new TextField();
		Button loginButton = new Button("Login");
		loginButton.setOnAction(this::processLoginRequest);
        /*if(usernamefield.gettext() &&  passwordField.gettext() == user.getusername() && user.getpassword){ 
			loginButton.setOnAction(e -> primaryStage.setScene(scene4));
		}
		if(usernamemfield.gettext() && passwordfield.gettext() == librarian.getusername && librarian.getpassword){
			loginButton.setOnAction(e -> primaryStage.setScene(scene5));
		}*/
		VBox layout2 = new VBox(20);
		layout2.setAlignment(Pos.CENTER);
		layout2.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField);
		scene2 = new Scene(layout2, 300, 250);
		
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
		signUpButton.setOnAction(this::processSignUpRequest);
		signUpButton.setOnAction(e -> primaryStage.setScene(scene2));
		VBox layout3 = new VBox(20);
		layout3.setAlignment(Pos.CENTER);
		layout3.getChildren().addAll(nameLabel, nameField, streetLabel, streetField, cityLabel, cityField, provinceCombo, postCodeLabel, postCodeField, phoneLabel, phoneField, newUsernameLabel, newUsernameField, newPasswordLabel, newPasswordField, rePasswordLabel, rePasswordField, signUpButton);
		scene3 = new Scene(layout3, 450, 700);
		
		Button checkoutButton = new Button("Check Out a Book");
        checkoutButton.setOnAction(this::processCheckoutRequest);
		Button ratingButton = newButton("Rate and Review a Book");
		ratingButton.setOnAction(this::processRatingRequest);
		Button currentCheckoutButton = new Button("Books Currently Checked Out");
		currentCheckoutButton.setOnAction(this::processCurrentOutRequest);
		Button reservedButton = new Button("Books Reserved");
		reservedButton.setOnAction(this::processReservedRequest);
		Button recomendedButton = new Button("Recomended Books");
		recomendedButton.setOnAction(this::processRecomendedRequest);
		Button editButton = new Button("Edit Profile");
		editButton.setOnAction(e -> primaryStage.setScene(scene3));
		VBox layout4 = new VBox(20);
		layout4.setAlignment(Pos.CENTER);
		layout4.getChildren().addAll(checkoutButton, ratingButton, currentCheckoutButton, reservedButton, recomendedButton, editButton);
		scene4 = new Scene(layout4, 450, 700);

		checkoutButton = new Button("Check Out a Book");
		checkoutButton.setOnAction(this::processCheckoutRequest);
		Button returnButton = new Button("Return a Book");
		returnButton.setOnAction(this::processReturnRequest);
		ratingButton = new Button("Rate and Review a Book");
		ratingButton.setOnAction(this::processRatingRequest);
		Button addButton = new Button("Add a Book to the Inventory");
		addButton.setOnAction(this::processAddRequest);
		Button removeButton = new Button("Remove a Book from Inventory");
		removeButton.setOnAction(this::processRemoveRequest);
		Button lookUpButton = new Button("Look Up a User");
		lookUpButton.setOnAction(this::processLookUpRequest);
		Button removeUserButton = new Button("Remove a User Profile");
		removeUserButton.setOnAction(this::processRemoveUserRequest);
		editButton = new Button("Edit Profile");
		editButton.setOnAction(e -> primaryStage.setScene(scene3));
		VBox layout5 = new VBox(20);
		layout5.setAlignment(Pos.CENTER);
		layout5.getChildren().addAll(checkoutButton,returnButton,ratingButton,addButton,removeButton,lookUpButton,removeUserButton,editButton);
		scene5 = new Scene(layout5, 450, 700);

		primaryStage.setScene(scene1);
		primaryStage.show();
	}
    public void processLoginRequest(ActionEvent event){

	}

	public void processSignUpRequest(ActionEvent event){

	}

	public void processCheckoutRequest(ActionEvent event){

	}

	public void processRatingRequest(ActionEvent event){

	}

	public void processCurrentOutRequest(ActionEvent event){

	}

	public void processReservedRequest(ActionEvent event){

	}

	public void processRecomendedRequest(ActionEvent event){

	}

	public void processReturnRequest(ActionEvent event){

	}

	public void processAddRequest(ActionEvent event){

	}

	public void processRemoveRequest(ActionEvent event){

	}

	public void processLookUpRequest(ActionEvent event){

	}

	public void processRemoveUserRequest(ActionEvent event){

	}
}