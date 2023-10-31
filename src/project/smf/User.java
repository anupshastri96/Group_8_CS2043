package project.smf;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Iterator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class User {
	
	//private ArrayList<Book> userBooks = new ArrayList<>();
	//private ArrayList<Book> reserved = new ArrayList<>();
	private String name;
	//private String address;
	//private String userName;
	//private String password;
	//private int phone;
	private boolean isLibrarian = false;
	private int userID = 10;
	private final int USERID;
	
	public User(String name) /* String address, String userName, String password, int phone */ {
		this.name = name;
		//this.userName = userName;
		//this.password = password;
		//this.address = address;
		//this.phone = phone;
		USERID = userID;
		userID++;
	}
	
	public void setIsLibrarian() {
		isLibrarian = true;
	}
	
	public User createUser(Scanner userInput)throws IOException {
		
		System.out.println("Enter your First Name: ");
		String fName = userInput.next();
		System.out.println("Enter your Last Name: ");
		String lName = userInput.next();
		//address, phone etc.
		String name = fName + " " + lName;
		User newUser = new User(name);
				
		System.out.println("Enter work identification number: ");
		int workID = userInput.nextInt();
		File file = new File("librarianWorkIDList.txt");		
		BufferedReader r = new BufferedReader(new FileReader(file));
		String line = r.readLine();
		
		while (line != null) {
			if (line.equals(lName + ", " + fName + " " + workID)) { 
				newUser.setIsLibrarian(); 
				System.out.println(newUser);
			}
			line = r.readLine(); 
		}
		
		System.out.println(newUser);
		
		r.close();
		return newUser;
	}
	
	public User userLogIn(Scanner userInput, String userName, String password) throws IOException {
		User tempUser = new User(null);
		//getUser + go to MainMenu
		//if User not found ->
		File tempFile = new File("TempUser.txt");		
		BufferedReader tempR = new BufferedReader(new FileReader(tempFile));
		String tempLine = tempR.readLine();

		while (tempLine != null) {
			if (tempLine.equals(userName + " " + password)) { 
				//call create user method		
				User newUser = tempUser.createUser(userInput);
				newUser.setIsLibrarian();
				System.out.println(newUser);
				//remove temporary userName and password from file
			}
			tempLine = tempR.readLine();
			//if(tempUser = !found in UserList or librarian List)
			System.out.println("user is not in Librarian List");
			//else{
			//user not found -> prompt : go to create a new user 
		}
		tempR.close();
		return tempUser;
	}
	
	@Override
	public String toString() {
		return String.format("%s%s",name,isLibrarian);
	}

}
