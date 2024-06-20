package dev._olivares.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
// lets app this is a restapi controller
@RestController
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	// get mapping tells java this is an end point
	// then we just enter our endpoint inside getMapping

	// now when we run out application we can create our end points in this file
	// @GetMapping("/")
	// public String apiRoot() {
	// // return what we want
	// return "Hello, World!";
	// }

	// code was only for testing
	@CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("/healthCheck")
	public ResponseEntity<String> returnServerHealth() {
		return new ResponseEntity<String>("Server is running!", HttpStatus.ACCEPTED);
	}
}
