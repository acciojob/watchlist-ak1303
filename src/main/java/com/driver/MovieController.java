package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity("Movie Added Successfully",HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity("Director Added Successfully",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam Movie movie, @RequestParam Director director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity("Movie director Pair added Successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
       Movie movie =  movieService.getMovieByName(name);
       return new ResponseEntity(movie,HttpStatus.OK);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director =  movieService.getDirectorByName(name);
        return new ResponseEntity(director,HttpStatus.OK);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable String director){
        List<Movie> movieList = movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(movieList,HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> movieList = movieService.findAllMovies();
        return new ResponseEntity(movieList,HttpStatus.OK);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity("Director and its movie deleted from database",HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/delete-all-directors")
    public  ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity("All director with their movies deleted from database",HttpStatus.NO_CONTENT);
    }
}
