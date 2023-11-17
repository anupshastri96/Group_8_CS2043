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

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;

public class Library {
	private static final ArrayList<User> USER_LIST = new ArrayList<>();
	private static final ArrayList<Book> BOOK_INVENTORY = new ArrayList<>();
	//private static final ArrayList<Book> WAIT_LIST = new ArrayList<>();
	
	public Library() {}
	
	public static void addUser(User userToAdd) {
		if(!findUsername(userToAdd.getUsername())) {
			USER_LIST.add(userToAdd);
		}
		else if(findUsername(userToAdd.getUsername())) {
			System.out.println("User already in list");
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

	//Julia
	public static Book findBook(String title, String author){
		Iterator<Book> bookExist = BOOK_INVENTORY.iterator();
		while(bookExist.hasNext()){
			Book current = bookExist.next();
			if(current.getTitle().equals(title)){
				if(current.getAuthor().equals(author)){
					return current;
				}
			}
		}
		return null;
	}

	public static void addBook(Book bookIn){
			BOOK_INVENTORY.add(bookIn);
	}

	public static void printListByTitle(){
		Collections.sort(BOOK_INVENTORY);
		//printBookList(BOOK_INVENTORY);
	}
	
	public static void printListByAuthor(){
		Collections.sort(BOOK_INVENTORY, new Book.AuthorComparator());
		//printBookList(BOOK_INVENTORY);
	}
	
	public static void printListByGenre(){
		Collections.sort(BOOK_INVENTORY, new Book.GenreComparator());
		//printBookList(BOOK_INVENTORY);
	}
	
	public static void printListByAvailability(){
		Collections.sort(BOOK_INVENTORY, new Book.AvailabilityComparator());
		//printBookList(BOOK_INVENTORY);
	}	
}
