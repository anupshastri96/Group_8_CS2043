package test;

import static org.junit.Assert.*;
import org.junit.Test;

import project.model.BookInfo;

public class BookInfoTesting {

    @Test
    public void testBookInfoAvailability() {
        BookInfo bookInfo = new BookInfo("123", "2023-01-01");
        assertTrue(bookInfo.getIsAvailable());

        bookInfo.setIsReserved("2023-02-01", "User1");
        assertFalse(bookInfo.getIsAvailable());
        assertEquals("2023-02-01", bookInfo.getReservedUntil());
        assertEquals("User1", bookInfo.getReservedUser());

        bookInfo.setIsAvailable();
        assertTrue(bookInfo.getIsAvailable());
        assertNull(bookInfo.getReservedUntil());
        assertNull(bookInfo.getReservedUser());
    }

    @Test
    public void testBookInfoSortingByDueDate() {
        BookInfo bookInfo1 = new BookInfo("123", "2023-01-01");
        BookInfo bookInfo2 = new BookInfo("456", "2023-02-01");

        bookInfo1.updateDueDate("2023-03-01");
        bookInfo2.updateDueDate("2023-02-15");

        assertEquals("2023-03-01", bookInfo1.getDueDate());
        assertEquals("2023-02-15", bookInfo2.getDueDate());

        // Test sorting by due date
        assertTrue(bookInfo1.compareTo(bookInfo2) > 0);
    }
}
