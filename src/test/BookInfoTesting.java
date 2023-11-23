package test;

import static org.junit.Assert.*;

import java.time.ZonedDateTime;

import org.junit.Test;

import project.model.BookInfo;

public class BookInfoTesting {

    @Test
    public void testBookInfoAvailability() {
        BookInfo bookInfo = new BookInfo("123", "2023-01-01");
        assertTrue(bookInfo.getIsAvailable());
        
        bookInfo.checkedOut("User1");
        assertFalse(bookInfo.getIsAvailable());
        assertEquals(ZonedDateTime.now().plusDays(30).toLocalDate(), bookInfo.getDueDate().toLocalDate());
        assertEquals("User1", bookInfo.getCheckedOutBy());

        bookInfo.setIsAvailable();
        assertTrue(bookInfo.getIsAvailable());
        assertNull(bookInfo.getReservedUntil());
        assertNull(bookInfo.getReservedUser());
    }

    @Test
    public void testBookInfoSortingByDueDate() {
        BookInfo bookInfo1 = new BookInfo("123", "2023-01-01");
        BookInfo bookInfo2 = new BookInfo("456", "2023-02-01");
        ZonedDateTime pastDate = ZonedDateTime.now().minusDays(10);
        ZonedDateTime futureDate = ZonedDateTime.now().plusDays(10);		
        bookInfo1.updateDueDate(pastDate);
        bookInfo2.updateDueDate(futureDate);

        assertEquals(pastDate, bookInfo1.getDueDate());
        assertEquals(futureDate, bookInfo2.getDueDate());

        // Test sorting by due date
        assertTrue(bookInfo1.compareTo(bookInfo2) < 0);
    }
}
