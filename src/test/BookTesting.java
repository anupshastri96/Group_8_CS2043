package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.model.Book;
import project.model.BookInfo;
import project.model.Library;
import project.model.Patron;

public class BookTesting {
	@BeforeEach
	public void addTheseBooks() {
		Book.addNewBook("OneTitle", "One Author", "Sci-Fi", "bkID1", "2021-02-01");
		Book.addNewBook("TwoTitle", "Two Author", "Non-Fiction", "bkID2", "2020-01-01");
		Book.addNewBook("TwoTitle", "Two Author", "Non-Fiction", "bkID22", "2010-05-06");
		
	}
	
	@AfterEach
	public void clearList() {
		Library.BOOK_INVENTORY.clear();
	}
	
	@Test
	public void testBookAvgRating() {
		Book found = Library.findBook("OneTitle","One Author");
	  	found.addRating(0, "User2", "OneTitle", "One Author");
	  	assertEquals(found.avgRating(), 0);
	  	found.addRating(5, "User1", "OneTitle", "One Author");
	  	assertEquals(found.avgRating(), 2.5);
	  	found.addRating(2, "User3", "OneTitle", "One Author");
	  	assertEquals(found.avgRating(), 2.3333332538604736);
    }
	 
    @Test
	public void addBookToInventoryTest() {
		Book found = Library.findBook("OneTitle","One Author");
		Book found2 = Library.findBook("TwoTitle", "Two Author");
		assertEquals(found.getTitle(),"OneTitle");
		assertEquals(found.getRelatedInfo().size(),1);
		assertEquals(found2.getRelatedInfo().size(),2);
		assertEquals(Library.getInventory().size(),2);
	}
    
    @Test
	public void removeBookFromInventoryTest() {
		Book found = Library.findBook("OneTitle","One Author");
		Book found2 = Library.findBook("TwoTitle", "Two Author");
		Book.removeBook("bkID1", "OneTitle", "One Author");
		found = Library.findBook("OneTitle","One Author");
		assertEquals(found,null);
		assertEquals(Library.getInventory().size(),1);
		assertEquals(found2.getRelatedInfo().size(),2);
		Book.removeBook("bkID2", "TwoTitle", "Two Author");
		assertEquals(Library.getInventory().size(),1);
		assertEquals(found2.getRelatedInfo().size(),1);
		Book.removeBook("bkID22", "TwoTitle", "Two Author");
		assertEquals(Library.getInventory().size(),0);
	}
    
    @Test
    public void testCheckOut() {
    	String[] updateAddress = new String[4];
		Patron userPatron = new Patron("NewUser", "User1", "password", updateAddress, 0);
		Book bookTest1 = Library.findBook("OneTitle", "One Author");
		Book.checkOutBook("bkID1", "OneTitle", "One Author", userPatron);
    	BookInfo testInfo1 = bookTest1.findBookInfo(bookTest1, "bkID1");

    	boolean test = testInfo1.getIsAvailable();
		assertFalse(test);
        assertEquals("User1", testInfo1.getCheckedOutBy());
    }
        
    @Test
    public void testAuthorSort() { 
        Library.getInventory().sort(new Book.AuthorComparator());
        assertEquals("One Author", Library.getInventory().get(0).getAuthor());
        assertEquals("Two Author", Library.getInventory().get(1).getAuthor());
    }
    
    @Test
    public void testGetTopRecommededBooks() {
		Book.addNewBook("ThreeTitle", "AThree Author", "Non-Fiction", "bkID3", "2010-03-03");
		Book.addNewBook("FourTitle", "ZFour Author", "Non-Fiction", "bkID4", "2010-04-04");
		Book.addNewBook("FiveTitle", "Five Author", "Non-Fiction", "bkID5", "2010-05-05");
		String[] updateAddress = new String[4];
		Patron userPatron = new Patron("NewUser", "User1", "password", updateAddress, 0);
		Book.checkOutBook("bkID1", "OneTitle", "One Author", userPatron);
		Book book1 = Library.findBook("OneTitle", "One Author");
		//BookInfo info1 = book1.findBookInfo(book1, "bkID1");
		Book book2 = Library.findBook("TwoTitle", "Two Author");
		//BookInfo info2 = book1.findBookInfo(book2, "bkID2");
		Book book3 = Library.findBook("ThreeTitle", "AThree Author");
		//BookInfo info3 = book1.findBookInfo(book3, "bkID3");
		Book book4 = Library.findBook("FourTitle", "ZFour Author");
		//BookInfo info4 = book4.findBookInfo(book4, "bkID4");
		
		book1.addRating(5, "User1","OneTitle", "One Author");
		book1.addRating(5, "User2","OneTitle", "One Author");
		book1.addRating(4, "User3","OneTitle", "One Author");
		book1.addRating(3, "User4","OneTitle", "One Author");
		
		book2.addRating(2, "User1","TwoTitle", "Two Author");
		book2.addRating(2, "User2","TwoTitle", "Two Author");
		book2.addRating(2, "User3","TwoTitle", "Two Author");
		book2.addRating(3, "User4","TwoTitle", "Two Author");
		
		book3.addRating(0, "User1","ThreeTitle", "AThree Author");
		book3.addRating(1, "User2","ThreeTitle", "AThree Author");
		book3.addRating(1, "User3","ThreeTitle", "AThree Author");
		book3.addRating(1, "User4","ThreeTitle", "AThree Author");
		
		book4.addRating(5, "User1","FourTitle", "ZFour Author");
		book4.addRating(5, "User2","FourTitle", "ZFour Author");
		book4.addRating(5, "User3","FourTitle", "ZFour Author");
		book4.addRating(5, "User4","FourTitle", "ZFour Author");
		System.out.println("\nBooks listed by Title: ");
    	Library.printListByTitle();
    	System.out.println("\nBooks listed by Author: ");
    	Library.printListByAuthor();
    	System.out.println("\nBooks listed by Genre: ");
    	Library.printListByGenre();
    	System.out.println("\nBooks listed by Availability: ");
    	Library.printListByAvailability();
    	Library.getTopRecommendedBooks("User2");
    	assertEquals(Library.getInventory().size(),5);
    	
    }
}
