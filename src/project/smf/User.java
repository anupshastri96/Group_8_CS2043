/**
Module Name: User
Date Created: 2023-11-04
Created By: Sarah Flynn
Abstract class for a user a librarian or a patron.
Functions:
	userLogIn()
	userExists()
**/

package project.smf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public abstract class User {
	
	private String name;
	private String userName;
	private String password;
	//private String address;
	//private int phone;
	
	public User(String name, String userName, String pw)/* String address, int phone */{
		this.name = name;
		this.userName = name;
		password = pw;
		//this.address = address;
		//this.phone = phone;
	}
	
	public static void userLogIn(Scanner userInput, String userName, String password) throws IOException{
		//getUser fromList + go to MainMenu
		//if User not found ->
		File tempFile = new File("TempUser.txt");		
		BufferedReader tempR = new BufferedReader(new FileReader(tempFile));
		String tempLine = tempR.readLine();
		
		while (tempLine != null) {
			if (tempLine.equals(userName + " " + password)) { 	
				Librarian newLib = new Librarian(null, null, null);
				newLib.createLibrarian(userInput);
				System.out.println(newLib);
				//remove temporary userName and password fromfile
			}
			tempLine = tempR.readLine();
			//if(tempUser = !found in UserList or librarian List)
			//System.out.println("temp password not valid");
			//else{
			//user not found -> prompt : go to create a new user 
			Patron newUser = new Patron(null, null, null);
			newUser.createPatron(userInput);
			System.out.println(newUser);
		}
		tempR.close();
	}
	
	@Override
	public String toString() {
		return String.format("%s %s",userName, name, password);
	}
}
