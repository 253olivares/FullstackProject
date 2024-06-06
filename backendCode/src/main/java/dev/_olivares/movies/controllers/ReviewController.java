package dev._olivares.movies.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev._olivares.movies.objectClasses.Review;
import dev._olivares.movies.services.ReviewService;

// this creates an api enpoint for our backend that makes the call to the database
// by default this will point to our "/" endpoint
@RestController
// using our request mapping we can change our endpoint
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    // at localhost:8080/api/v1/reviews
    // call our getAllReviews method and return all our reviews from the database
    @GetMapping()
    public ResponseEntity<List<Review>> getAllReviews() {

        // try catch to return different http status depending on database
        try {
            // try contacting our data base
            List<Review> review = reviewService.allReviews();
            // if empty return a ResponseEntity saying no content found
            if (review.isEmpty() || review.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            // if found them return response entity with the list of reviews and a ok status
            return new ResponseEntity<List<Review>>(review, HttpStatus.OK);
        } catch (Exception e) {
            // otherwise if we run into an issue contacting the server
            // return a response entity of internal server error
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // at localhost:8080/api/v1/reviews/addReview
    // call our createReview which gets the following params from our body
    // it will get a reviewBody and imdb parameters
    @PostMapping("/addReview")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),
                HttpStatus.CREATED);
    }
}
