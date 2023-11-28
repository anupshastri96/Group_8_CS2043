package project.model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Book implements Comparable<Book>{

	String title;
	String author;
	String genre;
	ArrayList<RatingsReviews> ratingsReviews = new ArrayList<>();
	ArrayList<BookInfo> relatedInfo = new ArrayList<>();
	
	public Book(String titleIn, String authorIn, String genreIn) {
		title = titleIn;
		author = authorIn;
		genre = genreIn;
	}
	
	public static void addNewBook(String titleIn, String authorIn, String genreIn, String bookIdIn, String publicationDateIn) {
		Book bookCheck = Library.findBook(titleIn, authorIn);
		if(bookCheck != null) {
			BookInfo newInfo= new BookInfo(bookIdIn, publicationDateIn);
			bookCheck.relatedInfo.add(newInfo);
			}
		else if(bookCheck == null){
			Book newBook = new Book(titleIn, authorIn, genreIn);
			BookInfo newInfo= new BookInfo(bookIdIn, publicationDateIn);
			newBook.relatedInfo.add(newInfo);
			Library.addBook(newBook);
		}
	}
	
	public static void checkOutBook(String bookId, String title, String author, User loggedInUser) {
		Book bookToCheckOut = Library.findBook(title, author);
		BookInfo info = bookToCheckOut.findBookInfo(bookToCheckOut, bookId);
		if(info.available) {
			info.checkedOut(loggedInUser.getUsername());
		}
	}
	
	public static void returnABook(String bookId, String title, String author) {
		Book bookToReturn = Library.findBook(title, author);
		BookInfo info = bookToReturn.findBookInfo(bookToReturn, bookId);
		if(!info.available) {
			info.returnBook();
		}
	}
	
	public boolean checkAvailability(String title, String author) {
		boolean found = false;
		Iterator<BookInfo> infoExist = getRelatedInfo().iterator();
		while(infoExist.hasNext()){
			BookInfo current = infoExist.next();
			if(current.available){
				found = true;
				return found;
			}
		}
		return found;
	}
	
	public BookInfo findBookInfo(Book book, String bookId){
		Iterator<BookInfo> infoExist = book.relatedInfo.iterator();
		while(infoExist.hasNext()){
			BookInfo current = infoExist.next();
			if(current.getBookID().equals(bookId)){
				return current;
			}
		}
		return null;
	}
	
	public static void removeBook(String bookId, String title, String author) {
		Book bookToRemove = Library.findBook(title, author);
		BookInfo infoToRemove = bookToRemove.findBookInfo(bookToRemove, bookId);
		if(infoToRemove != null) {
			bookToRemove.relatedInfo.remove(infoToRemove);
		}
		if(bookToRemove.relatedInfo.size() == 0) {
			Library.removeFromInventory(bookToRemove);
		}
	}
	
	public void addRating(int ratingIn, String ratedByIn, String title, String author) {
		Book bookToRate = Library.findBook(title, author);
		RatingsReviews newRating = new RatingsReviews(ratingIn, ratedByIn);
		bookToRate.ratingsReviews.add(newRating);
	}
		
	
	public void addReview(int ratingIn, String reviewIn, String ratedByIn, String title, String author) {
		Book bookToRev = Library.findBook(title, author);
		RatingsReviews ratingReview = new RatingsReviews(ratingIn, reviewIn, ratedByIn);
		bookToRev.ratingsReviews.add(ratingReview);
	}
	
	public float avgRating() {
		int totalRating = 0;
		float avg = 0;
		Iterator<RatingsReviews> nextRev = ratingsReviews.iterator();
		while(nextRev.hasNext()) {
			RatingsReviews current = nextRev.next();
			totalRating += current.getRating();
		}
		if(ratingsReviews.size() == 0) {
			avg = -1;
		}
		else if (ratingsReviews.size() > 0) {
			avg = (float)totalRating/ratingsReviews.size();
		}
		return avg;
	}

	public int getRatingByUser(String ratedBy){
		Iterator<RatingsReviews> nextRev = ratingsReviews.iterator();
		while(nextRev.hasNext()) {
			RatingsReviews current = nextRev.next();
			if(ratedBy.equals(current.getRatedBy())){
				return current.getRating();
			}
		}
		return -1;
	}

	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	public String getGenre(){
		return genre;
	}
	
	public ArrayList<BookInfo> getRelatedInfo(){
		return relatedInfo;
	}

	public ArrayList<RatingsReviews> getRatingReviews(){
		return ratingsReviews;
	}
	
	public void printBook(){
		String printRating = "";
		Float avgRating = avgRating();
		if(avgRating < 0 ) {
			printRating = "Rating: No rating";  
		}
		else if (avgRating >= 0) {
			printRating = "Rating: " + avgRating;
		}
		System.out.println("Title: " + title + " | Author: " + author + " | Genre: " + genre + " | Average " + printRating);
	}

	public void printBookRating(){
		String printRating = "";
		System.out.println("Ratings and Reviews for " + title + ":");
		for(RatingsReviews ratingReview : ratingsReviews){
		Float avgRating = avgRating();
		if(avgRating < 0 ) {
			printRating = "     Rating: No rating";  
		}
		else if (avgRating >= 0) {
			printRating = "     Rating: " + avgRating;
		}
			System.out.println(printRating);
			System.out.println("	Review: " + ratingReview.getReview());
			System.out.println("	Rated By: " + ratingReview.getRatedBy());
			System.out.println("----------------------------------");
		}
	}
			
	@Override
	public int compareTo(Book other){
		return this.title.compareTo(other.title);
	}
	
	public static class AuthorComparator implements Comparator<Book>{
		@Override
		public int compare(Book a, Book b){
			if(a.author != null && b.author != null){
				return a.author.compareTo(b.author);
			}
			return a.title.compareTo(b.title);
		}
	}
		
	public static class GenreComparator implements Comparator<Book>{
		@Override
		public int compare(Book a, Book b){
			if(a.genre != null && b.genre != null){
				if(a.genre.equals(b.genre)){
					return a.title.compareTo(b.title);
				}
				return a.genre.compareTo(b.genre);
			}
			return a.title.compareTo(b.title);
		}
	}

	public static class AvailabilityComparator implements Comparator<Book>{
		@Override
		public int compare(Book a, Book b){
			int i = Boolean.compare(a.checkAvailability(a.title, b.author), b.checkAvailability(b.title, b.author)); //sort by availability
			if(i != 0){
				return i;
			}
			int j = a.author.compareTo(b.author); 
			if(j != 0){
				return j;
			}
			return a.title.compareTo(b.title); 
		}
	}
	
	public static class RatingsComparator implements Comparator<Book>{
		
		@Override
		public int compare(Book a, Book b) {
			if(a.avgRating() > b.avgRating()) {
				return -1;
			}
			else if(a.avgRating() < b.avgRating()) {
				return 1;
			}
			return 0;			
		}
	}
}
