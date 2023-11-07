/**
Module Name: Librarian
Date Created: 2023-11-04
Created By: Sarah Flynn
Class that creates a librarian.
Functions:
	createLibrarian()
	returnBook()
**/

package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Librarian extends User {
			
	public Librarian(String name, String userName, String pw) /* String address, String userName, String password, int phone */ {
		super(name, userName, pw);
		//this.address = address;
		//this.phone = phone;
	}
	
	public Librarian createLibrarian(String name, String userName, String pw){
		//parse string into name/userName/pw/phone number
//		this first check will need to be done before the information is passed to create		
//		while(!USER_LIST.findUserName(userName)) {
//			System.out.println("Username already exits create a unique username:");
//			return;
//		}
		Librarian newUser = new Librarian(name, userName, pw);
		//add to userList
		return newUser;
	}
	
	private static void removeRecord(String libUserFile, String tempLine)throws IOException {
		String temp = "temp.txt";
		File prevFile = new File(libUserFile);
		File newFile = new File(temp);
		
		String currentLine;
	
		FileWriter fw = new FileWriter(temp, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
	
		FileReader fr = new FileReader(libUserFile);
		BufferedReader br = new BufferedReader(fr);
	
		while((currentLine = br.readLine()) != null ){
			if (currentLine.equals(tempLine)) {
				currentLine = br.readLine();
			}
			pw.println(currentLine);
			
		}
		pw.flush();
		pw.close();
		fr.close();
		br.close();
		bw.close();
		fw.close();
		
		prevFile.delete();
		File dump = new File(libUserFile);
		newFile.renameTo(dump);	
	}
	
	public static Librarian checkTempLibList(String user, String pw) throws IOException {
		File tempFile = new File("TempUser");		
		BufferedReader tempR = new BufferedReader(new FileReader(tempFile));
		String tempLine = tempR.readLine();
		
		while (tempLine != null) {
			if (tempLine.equals(user + " " + pw)) {
				Librarian newLib = new Librarian(null,null,null);//call input screen for new user
				removeRecord("TempUser", tempLine);
				tempR.close();
				return newLib;
			}
			tempLine = tempR.readLine();
		}
		tempR.close();
		return null;
	}

}
