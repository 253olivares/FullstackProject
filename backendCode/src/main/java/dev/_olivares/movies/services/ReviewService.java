package dev._olivares.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev._olivares.movies.objectClasses.Movie;
import dev._olivares.movies.objectClasses.Review;
import dev._olivares.movies.repositories.ReviewRepository;

// annotate as a service so spring knows what our object is
@Service
public class ReviewService {
    // auto incite our reviewRepository constructor and create the class
    @Autowired
    private ReviewRepository reviewRepository;

    // we create this template to run complex operations that are not going to be
    // possible in our ClassRepository (MovieRepository, ReviewRepository)
    @Autowired
    private MongoTemplate mongoTemplate;

    // create review method will be called whenever a user submits a review
    // when its called we will grab the review body and the imdbId the review is
    // being placed under
    public Review createReview(String reviewBody, String imdbId) {

        // Create a review instance and then insert that review into our database\

        // Review review = new Review(reviewBody);
        // reviewRepository.insert(review);
        // once our movie is taken care of in the database we need to now worry tying it
        // to a movie
        // we would want to do this buy passing the reviewId to our movieProperty
        // reviewIds
        // continue reading over at the mongoTemplate variable to learn more

        // this is an udpate to our previous defined methods and objects where we
        // created a review instance and then insert it into the database
        // instead of doing these 2 operations separately we want to do these methods
        // together at once to make sure we have an id when passing our review into our
        // database

        // combining our method like this ensures that the review exists inside the data
        // base before we add it to our movie review
        // and when we do it will have a personalId for the review since the insert will
        // return our review from the server
        Review review = reviewRepository.insert(new Review(reviewBody));

        // once we create our mongoTemplate we can call its custom query method
        // this a really extensive query method reliant on method chaining to provide
        // all the information necessary
        // for spring boot to create a update question that mongoDb will accept
        // first we are going to update our movie class
        mongoTemplate.update(Movie.class)
                // then we are going to find the object / item where our imbdId matches
                // once we find our match we will apply an update to the field we are looking
                // for
                // we want to create a new update instance and push to our reviewIds
                // the value we want to insert is our review
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                // .first is to take our resilts from its array since most databse queries will
                // return an array no matter how many items we search so we want the first
                // matching query
                .first();

        return review;
    }

}
