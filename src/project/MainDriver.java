package project;

import java.io.IOException;
import java.util.Scanner;


public class MainDriver {

	public static void main(String[] args) throws IOException {
	       
		Scanner userInput = new Scanner(System.in);
				
		System.out.println("username: ");
		String varName = userInput.next();
		
		System.out.println("Password: ");
		String varPassword = userInput.next();
		
		User.userLogIn(varName, varPassword);	
		
		userInput.close();
	}
}
