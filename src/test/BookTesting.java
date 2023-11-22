package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import project.model.Book;
import project.model.Library;

public class BookTesting {
	
	 @Test
	 public void testBookAvgRating() {
	  	Book book = new Book("Title", "Author", "Genre");
	   	Book book2 = new Book("Title2", "Author1", "Genre");
    	assertEquals(0.0, book.avgRating(), 0.001);
    	book.addRating(5, "User1");
    	assertEquals(5.0, book.avgRating(), 0.001);
    	book.addRating(3, "User2");
    	assertEquals(4.0, book.avgRating(), 0.001);
    }
	 
    @Test
	public void addBookToInventoryTest() {
    	Book.addNewBook("OneTitle", "One Author", "Sci-Fi", "bkID1", "2021-02-01");
    	Book.addNewBook("TwoTitle", "Two Author", "Non-Fiction", "bkID2", "2020-01-01");
    	Book.addNewBook("TwoTitle", "Two Author", "Non-Fiction", "bkID22", "2010-05-06");
		Book found = Library.findBook("OneTitle","One Author");
		Book found2 = Library.findBook("TwoTitle", "Two Author");
		assertEquals(found.getTitle(),"OneTitle");
		assertEquals(found.getRelatedInfo().size(),1);
		assertEquals(found2.getRelatedInfo().size(),2);
		assertEquals(Library.getInventory().size(),2);
	}
    
    @Test
	public void removeBookFromInventoryTest() {
    	Book.addNewBook("OneTitle", "One Author", "Sci-Fi", "bkID1", "2021-02-01");
    	Book.addNewBook("TwoTitle", "Two Author", "Non-Fiction", "bkID2", "2020-01-01");
    	Book.addNewBook("TwoTitle", "Two Author", "Non-Fiction", "bkID22", "2010-05-06");
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
    
//    @Test
//    public void testAuthorSort() { 
//    	Book book = new Book("Title", "Author", "Genre", "BKID1","2020-10-11");
//    	Book book2 = new Book("Title2", "NextAuthor", "Genre", "BKID2","2021-05-12");
//    	ArrayList<Book> bookList = new ArrayList<>();
//    	bookList.add(book);
//        bookList.add(book2);
//        bookList.sort(new Book.AuthorComparator());
//        assertEquals("Author", bookList.get(0).getAuthor());
//        assertEquals("NextAuthor", bookList.get(1).getAuthor());
//    }
}
