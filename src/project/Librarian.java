/**
Module Name: Librarian
Date Created: 2023-11-04
Created By: Sarah Flynn
Class that creates a librarian.
Functions:
	createLibrarian()
	returnBook()
**/

package project.smf;

import java.io.IOException;
import java.util.Scanner;

public class Librarian extends User {
			
	public Librarian(String name, String userName, String pw) /* String address, String userName, String password, int phone */ {
		super(name, userName, pw);
		//this.address = address;
		//this.phone = phone;
	}
	
	public void createLibrarian(Scanner userInput)throws IOException{
		System.out.println("Create a username: ");
		String userName = userInput.next();
		//check for unique userName - userList();
		System.out.println("Create a password: ");
		String pw = userInput.next();
		System.out.println("Enter your First Name: ");
		String fName = userInput.next();
		System.out.println("Enter your Last Name: ");
		String lName = userInput.next();
	
		String name = fName + " " + lName;
		Librarian newUser = new Librarian(name, userName, pw);
		//add to userList
		System.out.println(newUser);
	}

}
