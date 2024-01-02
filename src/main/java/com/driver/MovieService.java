package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public  void addMovieDirectorPair(Movie movie, Director director){
        movieRepository.addMovieDirectorPair(movie,director);
    }
    public Movie getMovieByName(String name){
        Movie movie =  movieRepository.getMovieByName(name);
        return movie;
    }
    public Director getDirectorByName(String name){
        Director director =  movieRepository.getDirectorByName(name);
        return director;
    }
    public List<Movie> getMoviesByDirectorName(String director){
        List<Movie> movieList = movieRepository.getMoviesByDirectorName(director);
        return movieList;
    }
    public List<Movie> findAllMovies(){
        List<Movie> movieList = movieRepository.findAllMovies();
        return movieList;
    }
    public void deleteDirectorByName(String name){
        movieRepository.deleteDirectorByName(name);
    }
    public  void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
