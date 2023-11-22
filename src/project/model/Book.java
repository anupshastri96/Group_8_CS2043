package project.model;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Book implements Comparable<Book>{

	String title;
	String author;
	String genre;
	ArrayList<RatingsReviews> ratingsReviews = new ArrayList<>();
	private ArrayList<BookInfo> relatedInfo = new ArrayList<>();;
	
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
	
	public static BookInfo findBookInfo(Book book, String bookId){
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
		BookInfo infoToRemove = findBookInfo(bookToRemove, bookId);
		if(infoToRemove != null) {
			bookToRemove.relatedInfo.remove(infoToRemove);
		}
		if(bookToRemove.relatedInfo.size() == 0) {
			Library.removeFromInventory(bookToRemove);
		}
	}
	
	public void addRating(int ratingIn, String ratedByIn) {
		RatingsReviews ratingReview = new RatingsReviews(ratingIn, ratedByIn);
		ratingsReviews.add(ratingReview);
	}
	
	public void addReview(int ratingIn, String reviewIn, String ratedByIn) {
		RatingsReviews ratingReview = new RatingsReviews(ratingIn, reviewIn, ratedByIn);
		ratingsReviews.add(ratingReview);
	}
	
	public double avgRating() {
		if(ratingsReviews.isEmpty()) {
			return 0.0;
		}
		int totalRating = 0;
		for(RatingsReviews ratingReview : ratingsReviews) {
			totalRating += ratingReview.getRating();
		}
		return (double) totalRating/ratingsReviews.size();
	}

	public int getRatingByUser(String ratedBy){
		for(RatingsReviews ratingReview: ratingsReviews){
			if(ratedBy.equals(ratingReview.getRatedBy())){
				return ratingReview.getRating();
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
	
	//Sort automatically by title alphabetically
	@Override
	public int compareTo(Book other){
		return this.title.compareTo(other.title);
	}

	//Sorting by Author
	public static class AuthorComparator implements Comparator<Book>{
		@Override
		public int compare(Book a, Book b){
			if(a.author != null && b.author != null){
				return a.author.compareTo(b.author);
			}
			return a.title.compareTo(b.title);
		}
	}

	//Sorting by genre
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

	//Sorting by availabilty
	public static class AvailabilityComparator implements Comparator<Book>{
		@Override
		public int compare(Book a, Book b){
			int i = Boolean.compare(a.checkAvailability(a.title, b.author), b.checkAvailability(b.title, b.author)); //sort by availability
			if(i != 0){
				return i;
			}
			int j = a.author.compareTo(b.author); //if same sort by author
			if(j != 0){
				return j;
			}
			return a.title.compareTo(b.title); //if same sort by title
		}
	}

	public void printBook(){
		System.out.println("Title: " + title + " | Author: " + author + " | Genre: " + genre + " | Average Rating: " + avgRating());
	}

	public void printBookRating(){
		System.out.println("Ratings and Reviews for " + title + ":");
		for(RatingsReviews ratingReview : ratingsReviews){
			System.out.println("	Rating: " + ratingReview.getRating());
			System.out.println("	Review: " + ratingReview.getReview());
			System.out.println("	Rated By: " + ratingReview.getRatedBy());
			System.out.println("----------------------------------");
		}
	}
}		
