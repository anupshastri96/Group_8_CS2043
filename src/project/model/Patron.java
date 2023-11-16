/**
Module Name: Patron
Date Created: 2023-11-04
Created By: Sarah Flynn
Class that creates a patron.
Functions:
	createPatron()
**/

package project.model;

public class Patron extends User{
	
	public Patron(String name, String userName, String pw, String address, int phone) {
		super(name, userName, pw, address, phone);
	}
	
	public static Patron createPatron(String nameIn, String userName, String pw, String address, int phone) {
		
		Patron newUser = new Patron(nameIn, userName, pw, address, phone);
		Library.addUser(newUser);
		return newUser;
	}
	
}
