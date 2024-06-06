package dev._olivares.movies.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev._olivares.movies.objectClasses.Review;

// telling spring this is a repository
// I believe this is what Spring uses to create our custom search params 
// such as searching by unique params
// by taking our class we pass in manogRepository and reading its unique properties and using its name
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
