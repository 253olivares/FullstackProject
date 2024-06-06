package dev._olivares.movies.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev._olivares.movies.objectClasses.Movie;
import dev._olivares.movies.services.MovieService;

// THIS IS OUR CONTROLLER LAYER
// RESPONSIBILITIES
// getting the request for the user
// returning the request from our user

// our controller will not do anything else only sending and returning requests
// at most it will provide different http requests depending on the server feedback

// here we will write our rest API controllers

// RestController sets up our api and tells the backend this is where we will begin to create our apis
@RestController
// override our map so it does not map to "localhost:8080/"
// this will override our map to "localhost:8080/api/v1/movies"
@RequestMapping("/api/v1/movies")
public class MovieController {

    // just like in our service with our repository
    // our movie service be automatically be injected by our framework upon call
    // time
    // gets rid of the need to instantiate new MovieService() by ourself
    @Autowired
    private MovieService movieService;

    // start creating our api
    // this will be our default
    // here when the user access "/api/v1/movies" it will direct to the following
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        // we are returning a response entity instead of a string so that our front end
        // section of the application
        // can recieve a http request
        // the body is our conTent that will be passed
        // later on in the project it will be passing our json data
        // return new ResponseEntity<String>("All Movies!",HttpStatus.OK);

        // We are changing our previous response entity
        // instead of returning a string we are changin it to return our list of movies
        // to this do this we are changing our return type as well as the body section
        // of our method
        // instead of returning a string it will now return the return of the allmovies
        // method in movie service
        // return new ResponseEntity<List<Movie>>(movieService.allMovies(),
        // HttpStatus.OK);
        // Going to take everything for before and wrap it in a try catch

        try {
            // try to get all our movies
            List<Movie> list = movieService.allMovies();
            // if our list is empty or size is 0 return http status no content
            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            // otherwise return our content
            return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
        } catch (Exception e) {
            // otherwise
            // if an issue to ran into and we dont know what it is display interal server
            // error
            System.out.println("Server error: " + e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getSingleMovie(@PathVariable String imdbId) {
        try {

            // get our movie from parameter passed and then check below if our object exists
            // or not
            Optional<Movie> movie = movieService.singleMovie(imdbId);

            // return response entity with our movie if the movie exists
            // Otherwise return no content warning
            return movie.isPresent()
                    ? new ResponseEntity<Movie>(movie.get(), HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
