package test;

import static org.junit.Assert.*;
import org.junit.Test;
import project.model.Book;
import java.util.ArrayList;

public class BookTesting {
		
    @Test
    public void testBookAvgRating() {
    	Book book = new Book("Title", "Author", "Genre", "BKID1","2020-10-11");
    	Book book2 = new Book("Title2", "Author1", "Genre", "BKID2","2021-05-12");

    	assertEquals(0.0, book.avgRating(), 0.001);
    	book.addRating(5, "User1");
    	assertEquals(5.0, book.avgRating(), 0.001);
    	book.addRating(3, "User2");
    	assertEquals(4.0, book.avgRating(), 0.001);
    }
    
    @Test
    public void testAuthorSort() { 
    	Book book = new Book("Title", "Author", "Genre", "BKID1","2020-10-11");
    	Book book2 = new Book("Title2", "NextAuthor", "Genre", "BKID2","2021-05-12");
    	ArrayList<Book> bookList = new ArrayList<>();
    	bookList.add(book);
        bookList.add(book2);
        bookList.sort(new Book.AuthorComparator());
        assertEquals("Author", bookList.get(0).getAuthor());
        assertEquals("NextAuthor", bookList.get(1).getAuthor());
    }
}
