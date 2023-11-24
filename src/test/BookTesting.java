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
	  	Book book = new Book("Title", "Author", "Genre");
    	assertEquals(0.0, book.avgRating(), 0.001);
    	book.addRating(5, "User1");
    	assertEquals(5.0, book.avgRating(), 0.001);
    	book.addRating(3, "User2");
    	assertEquals(4.0, book.avgRating(), 0.001);
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
		Book.checkOutBook("bkID1", "OneTitle", "One Author", userPatron);
		Book bookTest1 = Library.findBook("OneTitle", "One Author");
    	BookInfo testInfo1 = Book.findBookInfo(bookTest1, "bkID1");

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
}
