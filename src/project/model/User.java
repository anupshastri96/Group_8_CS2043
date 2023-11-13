/**
Module Name: User
Date Created: 2023-11-04
Created By: Sarah Flynn
Abstract class for a user a librarian or a patron.
Functions:
	userLogIn()
	findUsername()
	getUserName()
	getName()
	getPhone()
	validate()
	updateUsername()
	updateName()
	updatePassword()
	updateAddress()
	updatePhone()
**/

package project.model;

import java.io.IOException;
//import java.util.Iterator;

public abstract class User {
	
	private String name;
	private String userName;
	private String password;
	private String address;
	private int phone;
	
	public User(String name, String userName, String pw, String address, int phone) {
		this.name = name;
		this.userName = name;
		password = pw;
		this.address = address;
		this.phone = phone;
	}
	
	public static User userLogIn(String userIn, String pw) throws IOException{
		
		User userFound = new Patron(null, null,null, null, 0); //USER_LIST.findUserName(userIn);
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
	
	public String getUsername(){
		return userName;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPhone() {
		return phone;
	}
			
	public static void updateUsername(User toChange, String newUsername){
		toChange.userName = newUsername;
	}
	
	public static void updateName(User toChange, String newName){
		toChange.name = newName;
	}
	
	public static void updateAddress(User toChange, String newAddress){
		toChange.address = newAddress;
	}
	
	public static void updatePhone(User toChange, int newPhone){
		toChange.phone = newPhone;
	}
	
	public static void updatePassword(User toChange, String newPW) {
		toChange.password = newPW;
	}
	
	protected boolean validate(String userIn, String pw){
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
		return String.format("%s %s %s (%d)",userName, name, address, phone);
	}
}
