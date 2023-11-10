
public class BookInfo {

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
	}
	
	void updateDueDate(String dueDateIn) {
		dueDate = dueDateIn;
	}
	
	void updateReservedUntil(String reservedUntilIn) {
		reservedUntil = reservedUntilIn;
	}
	
	String getDueDate() {
		return dueDate;
	}
	
	String getReservedUntil() {
		return reservedUntil;
	}
	
	void setIsAvailable() {
		available = true;
	}
	
	boolean getIsAvailable() {
		return available;
	}

}