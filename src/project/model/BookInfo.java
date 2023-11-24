package project.model;
import java.time.ZonedDateTime;
import java.util.*;

public class BookInfo implements Comparable<BookInfo>{

	String bookID;
	String publicationDate;
	boolean available;
	ZonedDateTime dueDate;
	ZonedDateTime reservedUntil;
	String reservedBy;
	String checkedOutBy;
	
	public BookInfo(String bookIDIn, String publicationDateIn) {
		bookID = bookIDIn;
		publicationDate = publicationDateIn;
		available = true; //assumes a new book is available by default
		dueDate = null;
		reservedUntil = null;
		reservedBy = null;
		checkedOutBy = null;
	}
	
	public String getBookID() {
		return bookID;
	}
	
	public void returnBook() {
		checkedOutBy = null;
		available = true;
		dueDate = null; 
	}
	
	public void checkedOut(String username) {
		checkedOutBy = username;
		available = false;
		dueDate = ZonedDateTime.now().plusDays(30); 
	}
	
	public void updateDueDate(ZonedDateTime dueDateIn) {
		dueDate = dueDateIn;
	}
	
	public void updateReservedUntil(ZonedDateTime reservedUntilIn) {
		reservedUntil = reservedUntilIn;
	}
	
	public ZonedDateTime getDueDate() {
		return dueDate;
	}
	
	public ZonedDateTime getReservedUntil() {
		return reservedUntil;
	}
	
	public void setIsAvailable() {
		available = true;
		dueDate = null;
		reservedUntil = null;
		reservedBy = null;
		checkedOutBy = null;
	}

	public void setIsReserved(ZonedDateTime dueDateIn, String userNameIn){
		reservedUntil = dueDateIn;
		reservedBy = userNameIn;
	}
	
	public boolean getIsAvailable() {
		return available;
	}

	public String getReservedUser(){
		return reservedBy;
	}
	
	public String getCheckedOutBy(){
		return checkedOutBy;
	}

	//sorts based on dueDate
	@Override
	public int compareTo(BookInfo other){
		if(this.dueDate == null && other.dueDate == null){
			return 0;
		}else if (this.dueDate == null){
			return 1;
		}else if (other.dueDate == null){
			return -1;
		}
		return this.dueDate.compareTo(other.dueDate);
	}
	//sort by user and then by dueDate if a user has multiple books checked out
	public static class UserBookComparator implements Comparator<BookInfo>{
		@Override
		public int compare(BookInfo a, BookInfo b){
			if(a.checkedOutBy == null && b.checkedOutBy == null){
				return 0;
			}else if(a.checkedOutBy == null){
				return -1;
			}else if(b.checkedOutBy == null){
				return -1;
			}

			int i = a.checkedOutBy.compareTo(b.checkedOutBy);
			if(i != 0){
				return i;
			}

			if(a.dueDate == null && b.dueDate == null){
				return 0;
			}else if(a.dueDate == null){
				return 1;
			}else if(b.dueDate == null){
				return -1;
			}
			return a.dueDate.compareTo(b.dueDate);
		}
	}
}

