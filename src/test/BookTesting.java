package test;

import static org.junit.Assert.*;
import org.junit.Test;

import project.model.Book;

import java.util.ArrayList;

public class BookTesting {

    @Test
    public void testBookAvgRating() {
        Book book = new Book("Title", "Author", "Genre");
        assertEquals(0.0, book.avgRating(), 0.001);

        book.addRating(5, "User1");
        assertEquals(5.0, book.avgRating(), 0.001);

        book.addRating(3, "User2");
        assertEquals(4.0, book.avgRating(), 0.001);

        // Test sorting by author
        Book book2 = new Book("Title2", "Author1", "Genre");
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book2);
        bookList.sort(new Book.AuthorComparator());
        assertEquals("Author1", bookList.get(0).author);
        assertEquals("Author", bookList.get(1).author);
    }
}
