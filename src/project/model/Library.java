/**
Module Name: Library
Date Created: 2023-11-14
Created By: Sarah Flynn
Class represents a list of Users, Books in inventory, and Books on a wait list.
Functions:
	addUser()
	findUsername() : boolean
	findUser(): User
	removeFromInventory()
	findBook(): Book
	printBookList()
	addBook()
	getInventory()
	printListByTitle()
	printListByAuthor()
	printListByGenre()
	printListByAvailability()
	getTopRecommendedBooks()
	printRecommendations()
**/
package project.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;

public class Library {
	private static final ArrayList<User> USER_LIST = new ArrayList<>();
	public static final ArrayList<Book> BOOK_INVENTORY = new ArrayList<>();
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
			
	public static void removeFromInventory(Book book) {
		BOOK_INVENTORY.remove(book);
	}

	//Julia
	public static Book findBook(String title, String author){
		Iterator<Book> bookExist = BOOK_INVENTORY.iterator();
		while(bookExist.hasNext()){
			Book current = bookExist.next();
			if(current.getTitle().equals(title) && current.getAuthor().equals(author)){
				return current;
			}
		}
		return null;
	}
	
	public static void printBookList(){
		Iterator<Book> bookExist = BOOK_INVENTORY.iterator();
		Book current;
		while(bookExist.hasNext()){
			current = bookExist.next();
			current.printBook();
		}
	}

	public static void addBook(Book bookIn){
		BOOK_INVENTORY.add(bookIn);
	}
	
	public static ArrayList<Book> getInventory() {
		return BOOK_INVENTORY;
	}

	public static void printListByTitle(){
		Collections.sort(BOOK_INVENTORY);
		printBookList();
	}
	
	public static void printListByAuthor(){
		Collections.sort(BOOK_INVENTORY, new Book.AuthorComparator());
		printBookList();
	}
	
	public static void printListByGenre(){
		Collections.sort(BOOK_INVENTORY, new Book.GenreComparator());
		printBookList();
	}
	
	public static void printListByAvailability(){
		Collections.sort(BOOK_INVENTORY, new Book.AvailabilityComparator());
		printBookList();
	}	
	
	public static void getTopRecommendedBooks(String ratedBy){
		
		ArrayList<Book> reviewedBooks = new ArrayList<>();
		Iterator<Book> nextBook = BOOK_INVENTORY.iterator();
		while(nextBook.hasNext()) {
			Book current = nextBook.next();
			if(current.avgRating() >= 0){
				reviewedBooks.add(current);
			}
		}
		Collections.sort(reviewedBooks, new Book.RatingsComparator());
		printRecommendations(ratedBy, reviewedBooks);
	}

	public static void printRecommendations(String userNameIn, ArrayList<Book> rIn){//r stands for recommendation
		System.out.println("\nHi " + userNameIn + ", here are some recommendations for you!");
		Iterator<Book> nextBook = BOOK_INVENTORY.iterator();
		Book r;
		while(nextBook.hasNext()) {
			r = nextBook.next();
				System.out.println("	Title: " + r.getTitle());
				System.out.println("	Author: " + r.getAuthor());
				System.out.println("	Genre: " + r.getGenre());
				System.out.println("	Rating: " + r.avgRating());
				System.out.println("-------------------------------");
		}
	}
}
