package com.example.ccp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MovieController {
    
    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.allMovies(),HttpStatus.OK);
    }


    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovieByImdb(@PathVariable String imdbId){
           return new ResponseEntity<>(movieService.movieByImdbId(imdbId),HttpStatus.OK);
    }
}
