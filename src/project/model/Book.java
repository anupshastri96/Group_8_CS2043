package project.model;
import java.util.*;

public class Book implements Comparable<Book>{

	String title;
	String author;
	String genre;
	ArrayList<RatingsReviews> ratingsReviews;
	
	public Book(String titleIn, String authorIn, String genreIn) {
		title = titleIn;
		author = authorIn;
		genre = genreIn;
		ratingsReviews = new ArrayList<RatingsReviews>();
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
			return a.title.compareTo(book2.title);
		}
	}

	//Sorting by availabilty
	public static AvailabilityComparator implements Comparator<Book>{
		@Override
		public int compare(Book a, Book b){
			int i = Boolean.compare(a.isAvailable(), b.isAvailable()); //sort by availability
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
