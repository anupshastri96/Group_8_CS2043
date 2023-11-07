/**
Module Name: User
Date Created: 2023-11-04
Created By: Sarah Flynn
Abstract class for a user a librarian or a patron.
Functions:
	userLogIn()
	removeRecord()
	checkTempLibList()
	findUsername()
	getUserName()
	validate()
**/

package project;

import java.io.IOException;
//import java.util.Iterator;

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
	
	public static User userLogIn(String userIn, String pw) throws IOException{
		
		User userFound = new Patron(null, null,null); //USER_LIST.findUserName(userIn);
		if(userFound.validate(userIn, pw)) {
			return userFound;
		}
		else if(!userFound.validate(userIn, pw)) {
			Librarian newLib = Librarian.checkTempLibList(userIn, pw);
			if(newLib != null) {
				return newLib;
			}
			System.out.println("user name or password not valid");
		}
		return null;
	}
	
	
	
//	protected User findUsername(String username){
//		Iterator<User> userExist = USER_LIST.iterator();
//		while(userExist.hasNext()) {
//    		User userInList = userExist.next();
//    		if (userInList.getUserName().equals(username)) {
//        		return userInList;
//    		}
//		}
//		return null;
//	}
	
	public String getUserName(){
		return userName;
	}
	
	public boolean validate(String userIn, String pw){
		boolean validated = false;
		if(userIn.equals(userName) && pw.equals(password)) {
			validated = true;
		}
		else if(!userIn.equals(userName) || !pw.equals(password)){
			validated = false;
		}
		return validated;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s",userName, name, password);
	}
}
