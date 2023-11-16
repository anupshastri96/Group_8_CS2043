package project.model;
import java.util.ArrayList;
public class RatingsReviews {
	
	int rating;
	String review;
	String ratedBy;
	
	public RatingsReviews(int ratingIn, String reviewIn, String ratedByIn) {
		rating = ratingIn;
		review = reviewIn;
		ratedBy = ratedByIn;  
	}
	
	public RatingsReviews(int ratingIn, String ratedByIn) {
		rating = ratingIn;
		ratedBy = ratedByIn;  
		review = "";
	}
	
	int getRating() {
		return rating;
	}
	
	String getReview(){
		return review;
	}
	
	String getRatedBy() {
		return ratedBy;
	}
}
