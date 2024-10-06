package com.example.ccp;

import java.util.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie,ObjectId>{
    
    Optional <Movie> findByImdbId(String imdbId);
}
