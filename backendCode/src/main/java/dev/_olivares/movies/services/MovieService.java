package dev._olivares.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev._olivares.movies.objectClasses.Movie;
import dev._olivares.movies.repositories.MovieRepository;

// Majority of our logic will occur within this class 
// our service utilizes our movieRepository class to talk to the server

// these annotations is for our framework to understand how to use this class
@Service
public class MovieService {

    // Autowired automatically injects movieRepository when we call this class late
    // so we dont have to do new movieRepository()

    // ex: @Autowired private MovieRepository movieRepository = private
    // MovieRepository movieRepository = new MovieRepository();
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        // our find all method comes from the MongoDBRepository that we extended into
        // our movie Repository

        // System.out.println(movieRepository.findAll().toString());
        return movieRepository.findAll();
    }

    // we are tell java that their might be instances where we are unable to return
    // anything in those cases
    // we are going to be accepting null as the return type
    // this is what optional is doing for our return type
    public Optional<Movie> singleMovie(String id) {

        return movieRepository.findMovieByImdbId(id);
    }
}
