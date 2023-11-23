/**
Module Name: Librarian
Date Created: 2023-11-04
Created By: Sarah Flynn
Class that creates a librarian.
Functions:
	createLibrarian()
	removeRecord()
	checkTempLibList()
**/

package project.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import project.controller.EditProfileController;

public class Librarian extends User {
			
	public Librarian(String name, String userName, String pw, String[] address, int phone) {
		super(name, userName, pw, address, phone);
	}
	
	public Librarian createLibrarian(String name, String userName, String pw, String[] address, int phone){

		Librarian newUser = new Librarian(name, userName, pw, address, phone);
		Library.addUser(newUser);
		return newUser;
	}
	
	private static void removeRecord(String libUserFile, String tempLine)throws IOException {
		String temp = "temp";
		File prevFile = new File(libUserFile);
		File newFile = new File(temp);

		String currentLine;
		
		FileWriter fw = new FileWriter(newFile, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		FileReader fr = new FileReader(libUserFile);
		BufferedReader br = new BufferedReader(fr);
	
		while((currentLine = br.readLine()) != null ){
			if (currentLine.equals(tempLine)) {
				currentLine = br.readLine();
			}
			if(currentLine != null) {
				pw.println(currentLine);		
			}
		}
		br.close();
		pw.close();
		
		
		prevFile.delete();
		File dump = new File(libUserFile);
		newFile.renameTo(dump);
	}
	
	public static Librarian checkTempLibList(String user, String pw) throws IOException {
		File tempFile = new File("TempUserTest");
		FileReader reader = new FileReader(tempFile);
		BufferedReader tempR = new BufferedReader(reader);
		String tempLine;
		
		while ((tempLine = tempR.readLine()) != null ) {
		
			if (tempLine.equals(user + " " + pw)) {
				String[] tempAddress = new String[] {"street", "City", "PC"};
				Librarian newLib = new Librarian("Replace", user, pw, tempAddress, 0);
				tempR.close();
				removeRecord("TempUserTest", tempLine);
				return newLib;
			}
			tempLine = tempR.readLine();
		}
		tempR.close();
		return null;
	}

}
