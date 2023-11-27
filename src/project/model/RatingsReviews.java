package project.model;

public class RatingsReviews {
	
	private int rating;
	private String review;
	private String ratedBy;
	
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
	
	public int getRating() {
		return rating;
	}
	
	public String getReview(){
		return review;
	}
	
	public String getRatedBy() {
		return ratedBy;
	}
}



