package dev._olivares.movies.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev._olivares.movies.objectClasses.Movie;

// Our repository is our data access layer
// this is the later where we get data from our server
// this is done by extending our mongoRepository 
// if we click on mongoRepository it comes we preMade methods that insert,save, findall, findOne data values in our data base
// since we provided our login keys it can login automatically and run select commands
// especially since mongo commands are all already predetermined so they are just translated to java in a way where java can pass the parameters needed

// this is for the repository
// Our framework will see this and know what to do with out movie repository
@Repository
// repositories will usually always be created as a interface
// Our mongo repository will take in movies and ObjectIds

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    // whenever we need custom search methods we need to type our methods within
    // here
    // most custom searches will just be passing custom search queries to mongodb

    // a cool feature of springBoot is the ability to search unique properties of
    // our database objects
    // Spring boot creates special search methods based on our properties provided
    // in our movies class

    // To My understanding this method is created as
    // find${classname}By${classproperty}

    Optional<Movie> findMovieByImdbId(String imdbId);
}
