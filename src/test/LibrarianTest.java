package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.model.Librarian;
import project.model.Patron;
import project.model.User;

class LibrarianTest {
	Librarian userLibrarian;
	Patron userPatron;
		
	@BeforeEach
	public void setUpTemLogIn() throws IOException {
		File TempUserTest = new File("TempUserTest");
		FileWriter fw = new FileWriter(TempUserTest, true);
		fw.write("Person1 tempPassword1\n");
		fw.write("\rPerson2 tempPassword2");
		fw.write("\rPerson3 tempPassword3");
		fw.write("\rPerson4 tempPassword4");
		fw.close();
		String[] updateAddress = new String[4];
		userLibrarian = new Librarian("UpdateUsername", "Update name", "Update password", updateAddress, 0);
		userPatron = new Patron("UpdateFields", "Update Username", "Update password", updateAddress, 0);
	}
	
	@AfterEach
	public void tearDown()throws IOException {
		FileWriter deleteData = new FileWriter("TempUserTest", false);
		deleteData.close();
	}
	
	
	@Test
	void testUsernameUpdateLib() {
		User.updateUsername(userLibrarian, "UserName Updated");
		assertTrue(userLibrarian.getUsername().equals("UserName Updated"));
		assertTrue(userLibrarian instanceof Librarian);
	}
	
	@Test
	void testUsernameUpdatePatron() {
		User.updateUsername(userPatron, "UserName Updated");
		assertTrue(userPatron.getUsername().equals("UserName Updated"));
		assertTrue(userPatron instanceof Patron);
	}
	
	@Test
	void testCheckTempListFirst()throws IOException{
		FileReader testFR = new FileReader("TempUserTest");
		BufferedReader testBR = new BufferedReader(testFR);
		String currentLine;
		boolean found = false;
		while((currentLine = testBR.readLine()) != null ){
			if (currentLine.equals("Person1 tempPassword1")) {
				found = true;
			}
		}
		testBR.close();
		assertTrue(found == false);
	}
	
	@Test
	void testCheckTempListLast()throws IOException{
		FileReader testFR = new FileReader("TempUserTest");
		BufferedReader testBR = new BufferedReader(testFR);
		String currentLine;
		boolean found = false;
		while((currentLine = testBR.readLine()) != null ){
			if (currentLine.equals("Person4 tempPassword4")) {
				found = true;
			}
		}
		testBR.close();
		assertTrue(found == false);
	}
	
	@Test
	void testCheckTempList2()throws IOException {
		FileReader testFR = new FileReader("TempUserTest");
		BufferedReader testBR = new BufferedReader(testFR);
		String currentLine;
		boolean found = false;
		while((currentLine = testBR.readLine()) != null ){
			if (currentLine.equals("Person2 tempPassword2")) {
				found = true;
			}
		}
		testBR.close();
		assertTrue(found == false);
	}
	
}
