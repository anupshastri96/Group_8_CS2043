/**
Module Name: Library
Date Created: 2023-11-14
Created By: Sarah Flynn
Class represents a list of Users, Books in inventory, and Books on a wait list.
Functions:
	addUser()
	findUsername()
**/
package project.model;

import java.util.Iterator;
import java.util.ArrayList;

public class Library {
	private static final ArrayList<User> USER_LIST = new ArrayList<>();
	//private static final ArrayList<Book> BOOK_INVENTORY = new ArrayList<>();
	//private static final ArrayList<Book> WAIT_LIST = new ArrayList<>();
	
	public Library() {}
	
	public static void addUser(User userToAdd) {
		if(!findUsername(userToAdd.getUsername())) {
			USER_LIST.add(userToAdd);
		}
		else if(findUsername(userToAdd.getUsername())) {
			System.out.println("user already in list");
		}
	}
	
	public static boolean findUsername(String username){
		boolean userFound = false;
		Iterator<User> userExist = USER_LIST.iterator();
		while(userExist.hasNext()) {
    		User userInList = userExist.next();
    		if (userInList.getUsername().equals(username)) {
    			userFound = true;
    			return userFound;
    		}
		}
		return userFound;
	}
	
	public static User findUser(String username){
		Iterator<User> userExist = USER_LIST.iterator();
		while(userExist.hasNext()) {
    		User userInList = userExist.next();
    		if (userInList.getUsername().equals(username)) {
    			    			
    			return userInList;
    		}
		}
		return null;
	}
}
