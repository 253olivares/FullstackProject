package dev._olivares.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
