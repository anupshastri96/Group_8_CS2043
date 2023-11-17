package test;

import static org.junit.Assert.*;
import org.junit.Test;

import project.model.RatingsReviews;

public class RatingsReviewsTesting {

    @Test
    public void testRatingsReviews() {
        RatingsReviews ratingReview = new RatingsReviews(4, "Good book", "User1");

        assertEquals(4, ratingReview.getRating());
        assertEquals("Good book", ratingReview.getReview());
        assertEquals("User1", ratingReview.getRatedBy());
    }
}