package dev._olivares.movies;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// annotations
@Document(collection = "reviews")
// just like before import a dependency that creates our projects getters and
// setters
@Data
// import dependency that creates a constructor for our project that
// automatically sets all our properties
//
@AllArgsConstructor
// dependecy that makes a constructor with no args
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String body;
}
