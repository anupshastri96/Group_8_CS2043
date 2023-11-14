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
	
	public static void addUser(User usertoAdd) {
		if(findUsername(usertoAdd.getUsername())) {
			USER_LIST.add(usertoAdd);
		}
		else if(!findUsername(usertoAdd.getUsername())) {
			System.out.println("user already in list");
		}
	}
	
	public static boolean findUsername(String username){
		boolean userAlreadyExists = false;
		Iterator<User> userExist = Library.USER_LIST.iterator();
		while(userExist.hasNext()) {
    		User userInList = userExist.next();
    		if (userInList.getUsername().equals(username)) {
    			userAlreadyExists = true;
        	return userAlreadyExists;
    		}
		}
		return userAlreadyExists;
	}
}
