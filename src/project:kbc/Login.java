import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
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
	public void start(Stage primaryStage){
		primaryStage.setTitle("Login page");
		
		Button loginButton = new Button("Login");
		loginButton.setOnAction(this::processLoginRequest);
		
		Button newUserButton = new Button("Create new user");
		newUserButton.setOnAction(this::processCreateRequest);
		
		FlowPane pane = new FlowPane(loginButton, newUserButton);
			pane.setAlignment(Pos.CENTER);
			pane.setHgap(10);
			pane.setVgap(20);
		
		Scene scene = new Scene(pane, 225, 350);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
			
		
		
		
		