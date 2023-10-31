package project.smf;

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

public class MainDriver {

	public static void main(String[] args) throws IOException {
		
		Scanner userInput = new Scanner(System.in);
		//Set Up New User -> call create user Method
		//using WorkID to identify a librarian
		User user = new User(null);
		user = user.createUser(userInput);		
		
		//Temporary password and username
		//Login -> return user or check tempUser list for librarian
		
		System.out.println("User Name: ");
		String varName = userInput.next();
		
		System.out.println("Password: ");
		String varPassword = userInput.next();
		
		
		User tempUser = new User(null);
		tempUser = tempUser.userLogIn(userInput, varName, varPassword);
		
		userInput.close();
	}

}
