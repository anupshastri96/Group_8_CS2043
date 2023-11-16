package project.model;
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
	}

	public void setIsReserved(String dueDateIn){
		available = true;
		dueDate = dueDateIn;
	}
	
	public boolean getIsAvailable() {
		return available;
	}

}
