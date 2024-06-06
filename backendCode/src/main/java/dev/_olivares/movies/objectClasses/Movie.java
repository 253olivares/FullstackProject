package dev._olivares.movies.objectClasses;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// annotations
// This is our documents object
// this will hold each of our movies when we pull our data down from the data base
// to get started we need to create a field for each property of a movie
@Document(collection = "Movies")
// import Data
// comes from lombok
// takes care of creating our getters and setters for our project so we dont
// have to type it one by one
@Data
// another dependency created to help streamline the process
// all args contructor creates a constructor fo our class
// this constructor takes in our all our private properties and sets them
@AllArgsConstructor
// creates another constructors that takes no arguments
@NoArgsConstructor
public class Movie {

    // annotate our id with id so that our program knows that this is our unique
    // identifier
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    // this is an annotation writer that tells spring to only store our id
    // Our reviews themselves afterwards will be stored in a separate collection
    // We can do more research on this process by looking into
    //
    // ManualReferenceRelationships
    // *need to look into this for more information*
    // pretty much our data base will now create a bridge between our reviews
    // collections and movies collection

    // A DocumentReference allows referencing entities in MongoDB using a flexible
    // schema. While the goal is the same as when using DBRef, the store
    // representation is different. The reference can be anything, a single value,
    // an entire Document, basically everything that can be stored in MongoDB. By
    // default, the mapping layer will use the referenced entities id value for
    // storage and retrieval.
    // Documentation Link:
    // https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/core/mapping/DocumentReference.html
    @DocumentReference
    private List<Review> reviewIds;

}
