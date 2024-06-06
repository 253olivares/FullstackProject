package dev._olivares.movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// here we will write our rest API controllers

// RestController sets up our api and tells the backend this is where we will begin to create our apis
@RestController
// override our map so it does not map to "localhost:8080/"
// this will override our map to "localhost:8080/api/v1/movies"
@RequestMapping("/api/v1/movies")
public class MovieController {
    // start creating our api
    // this will be our default
    // here when the user access "/api/v1/movies" it will direct to the following
    @GetMapping
    public ResponseEntity<String> allMovies() {
        // we are returning a response entity instead of a string so that our front end
        // section of the application
        // can recieve a http request
        // the body is our conTent that will be passed
        // later on in the project it will be passing our json data
        return new ResponseEntity<String>("All Movies!", HttpStatus.OK);
    }
}
