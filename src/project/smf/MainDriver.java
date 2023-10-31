package project.smf;

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

public class MainDriver {

	public static void main(String[] args) throws IOException {
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter your First Name: ");
		String fName = userInput.next();
		
		System.out.println("Enter your Last Name: ");
		String lName = userInput.next();
		
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
		userInput.close();
		r.close();
	}

}
