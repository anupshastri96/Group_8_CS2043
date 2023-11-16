package project.model;
import java.util.ArrayList;

public class Book {

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
	
	void addRating(int ratingIn, String ratedByIn) {
		RatingsReviews ratingReview = new RatingsReviews(ratingIn, ratedByIn);
		ratingsReviews.add(ratingReview);
	}
	
	void addReview(int ratingIn, String reviewIn, String ratedByIn) {
		RatingsReviews ratingReview = new RatingsReviews(ratingIn, reviewIn, ratedByIn);
		ratingsReviews.add(ratingReview);
	}
	
	double avgRating() {
		if(ratingsReviews.isEmpty()) {
			return 0.0;
		}
		int totalRating = 0;
		for(RatingsReviews ratingReview : ratingsReviews) {
			totalRating += ratingReview.getRating();
		}
		return (double) totalRating/ratingsReviews.size();
	}

}
