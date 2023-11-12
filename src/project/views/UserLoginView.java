package project.views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.controller.UserLoginController;

public class UserLoginView{
	static Scene scene2;
	private static TextField usernameField;
	private static TextField passwordField;
		 
	public static void userLoginView(Stage stage) {
				
		Label usernameLabel = new Label("Enter User Name");
		usernameField = new TextField();
		Label passwordLabel = new Label("Enter Password");
		passwordField = new TextField();
		Button loginButton = new Button("Login");
		
	    String user = usernameField.getText(); 
	    String pw = passwordField.getText();
	    
		loginButton.setOnAction(e -> UserLoginController.login(user, pw));//After login send to controller -> scene4
	    
	    
		VBox layout2 = new VBox(20);
		layout2.setAlignment(Pos.CENTER);
		layout2.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);
		scene2 = new Scene(layout2, 300, 250);
		
		stage.setScene(scene2);
		stage.show();
	}
		
}
