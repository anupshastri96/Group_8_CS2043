package project.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.list;

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

	public void getTopRecommended(List<Book> bookList){
		List<UserReviews> reviewedBooks = new ArrayList<>();
		for(Book book: bookList){
			for(RatingsReviews ratingReview : book.getRatingsReviews()){
				if(ratedBy.equals(ratingReview.getRatedBy())){
					reviewedBooks.add(new UserReviewed(book, ratingReview.getRating()));
				}
			}
		}
		Collections.sort(reviewedBooks);
		printRecommendations(ratedBy, reviewedBooks);
	}

	//r stands for recommendation
	private void printRecommendations(String userNameIn, List<Book.UserReviewedBook> rIn){//r stands for recommendation
		System.out.println("Hi " + userNameIn + ", here are some recommendations for you!");
		int count = 0;
		for(Book.UserReviewedBook r : rIn){
			if(count < 5){
				Book current = r.getBook();
				System.out.println("	Title: " + r.getTitle());
				System.out.println("	Author: " + r.getAuthor());
				System.out.println("	Genre: " + r.getGenre());
				System.out.println("	Rating: " + r.getRating());
				System.out.println("-------------------------------");
				count++;
			}else{
				break;
			}
		}
	}
}



