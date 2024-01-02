package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    Set<Movie> movies;
    Set<Director> directors;
    Map<Director,List<Movie>> movieDirectorPair;
    MovieRepository(){
        movies = new HashSet<>();
        directors = new HashSet<>();
        movieDirectorPair = new HashMap<>();
    }
    public void addMovie(Movie movie){
        for(Movie mov : movies){
           if(mov.getName().equals(movie.getName()))
               return;
        }
        movies.add(movie);
    }
    public void addDirector(Director director){
        for(Director dir : directors){
            if(dir.getName().equals(director.getName()))
                return;
        }
        movieDirectorPair.put(director,new ArrayList<>());
        directors.add(director);
    }
    public  void addMovieDirectorPair(Movie movie, Director director){
        for(Director dir : movieDirectorPair.keySet()){
            if(dir.getName().equals(director.getName()))
                return;
        }
        List<Movie> movieList = movieDirectorPair.get(director);
        movieList.add(movie);
    }
    public Movie getMovieByName(String name){
        for(Movie mov : movies){
            if(mov.getName().equals(name)){
                return mov;
            }
        }
        return null;
    }
    public Director getDirectorByName(String name){
        for(Director dir : directors){
            if(dir.getName().equals(name))
                return dir;
        }
        return null;
    }
    public List<Movie> getMoviesByDirectorName(String name){
        Director director =null;
        for(Director dir : movieDirectorPair.keySet()){
            if(dir.getName().equals(name)){
                director=dir;
                break;
            }
        }
        List<Movie> movieList = movieDirectorPair.get(director);
        return movieList;
    }
    public List<Movie> findAllMovies(){
        return movies.stream().toList();
    }
    public void deleteDirectorByName(String name){
        for(Director dir : movieDirectorPair.keySet()){
            if(dir.getName().equals(name)){
                List<Movie> movieList=movieDirectorPair.get(dir);
                for(Movie movie : movieList){
                    movies.remove(movie);
                }
                movieDirectorPair.remove(dir);
                break;
            }
        }
    }
    public  void deleteAllDirectors(){
        for(Director dir : movieDirectorPair.keySet()){
            List<Movie> movieList=movieDirectorPair.get(dir);
            for(Movie movie : movieList){
                movies.remove(movie);
            }
            movieDirectorPair.remove(dir);
        }
    }
}
