package project.model;
import java.util.*;

public class BookInfo implements Comparable<BookInfo>{

	String bookID;
	String publicationDate;
	boolean available;
	String dueDate;
	String reservedUntil;
	String userName;
	
	public BookInfo(String bookIDIn, String publicationDateIn) {
		bookID = bookIDIn;
		publicationDate = publicationDateIn;
		available = true; //assumes a new book is available by default
		dueDate = null;
		reservedUntil = null;
		userName = null;
	}
	
	public void updateDueDate(String dueDateIn) {
		dueDate = dueDateIn;
	}
	
	public void updateReservedUntil(String reservedUntilIn) {
		reservedUntil = reservedUntilIn;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	
	public String getReservedUntil() {
		return reservedUntil;
	}
	
	public void setIsAvailable() {
		available = true;
		dueDate = null;
		reservedUntil = null;
		userName = null;
	}

	public void setIsReserved(String dueDateIn, String userNameIn){
		available = false;
		dueDate = dueDateIn;
		reservedUntil = dueDateIn;
		userName = userNameIn;
	}
	
	public boolean getIsAvailable() {
		return available;
	}

	public String getReservedUser(){
		return userName;
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
	public static class userBookComparator implements Comparator<BookInfo>{
		@Override
		public int compare(BookInfo a, BookInfo b){
			if(a.userName == null && b.userName == null){
				return 0;
			}else if(a.userName == null){
				return -1;
			}else if(b.userName == null){
				return -1;
			}

			int i = a.userName.compareTo(b.userName);
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

