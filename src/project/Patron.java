/**
Module Name: Patron
Date Created: 2023-11-04
Created By: Sarah Flynn
Class that creates a patron.
Functions:
	createPatron()
**/

package project.smf;

import java.io.IOException;
import java.util.Scanner;

public class Patron extends User{
	
	public Patron(String name, String userName, String pw) /* String address, String userName, String password, int phone */ {
		super(name, userName, pw);
		//this.address = address;
		//this.phone = phone;
	}
	
	public void createPatron(Scanner userInput)throws IOException {
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
		Patron newUser = new Patron(name, userName, pw);
		//add to userList
		System.out.println(newUser);
	}
}
