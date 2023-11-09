import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import java.text.NumberFormat;

public class Login extends Application{
	Scene scene1,scene2,scene3;
	private TextField usernameField, passwordField;
	public void start(Stage primaryStage){
		primaryStage.setTitle("Login Page");

		Button userLoginButton = new Button("User Login");
		Button librarianLoginButton = new Button("Librarian Login");
		Button newUserButton = new Button("Create New User");
		userLoginButton.setOnAction(e -> primaryStage.setScene(scene2));
		librarianLoginButton.setOnAction(e -> primaryStage.setScene(scene2));
		newUserButton.setOnAction(e -> primaryStage.setScene(scene3));
		VBox layout1 = new VBox(20);
		layout1.setAlignment(Pos.CENTER);
		layout1.getChildren().addAll(userLoginButton, librarianLoginButton, newUserButton);
		scene1 = new Scene(layout1, 300, 250);
        
		Label usernameLabel = new Label("Enter User Name");
		usernameField = new TextField();
		Label passwordLabel = new Label("Enter Password");
		passwordField = new TextField();
		VBox layout2 = new VBox(10);
		layout2.setAlignment(Pos.CENTER);
		layout2.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField);
		scene2 = new Scene(layout2, 300, 250);
		
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}
			
		
		
		
		