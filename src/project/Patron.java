/**
Module Name: Patron
Date Created: 2023-11-04
Created By: Sarah Flynn
Class that creates a patron.
Functions:
	createPatron()
**/

package project;

public class Patron extends User{
	
	public Patron(String name, String userName, String pw, String address, int phone) {
		super(name, userName, pw, address, phone);
	}
	
	public User createPatron(String fName, String lName, String userName, String pw, String address, int phone) {
//		this first check will need to be done before the information is passed to create		
//		while(!USER_LIST.findUserName(userName)) {
//			System.out.println("Username already exits create a unique username:");
//			return;
//		}
		
		String name = fName + " " + lName;
		Patron newUser = new Patron(name, userName, pw, address, phone);
		//add to userList
		return newUser;
	}
}
