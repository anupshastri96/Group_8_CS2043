package project.smf;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Iterator;

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
	
	@Override
	public String toString() {
		return String.format("%s",isLibrarian);
	}

}
