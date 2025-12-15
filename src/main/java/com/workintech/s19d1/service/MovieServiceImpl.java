package com.workintech.s19d1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
       return movieRepository.findAll();
    }

  @Override
public Movie findById(long id) {
    return movieRepository.findById(id)
        .orElseThrow(() -> new ApiException("Movie is not found with id: " + id, HttpStatus.NOT_FOUND));
}
    @Override
    public Movie save(Movie movie) {
    return movieRepository.save(movie);    
    }

    @Override
    public Movie update(long id, Movie movie) {
         Movie foundMovie = findById(id);
        if (foundMovie == null) {
            return null;
        }
        foundMovie.setName(movie.getName());
        foundMovie.setDirectorName(movie.getDirectorName());
        foundMovie.setRating(movie.getRating());
        foundMovie.setReleaseDate(movie.getReleaseDate());
        
        return movieRepository.save(foundMovie);
    }

    @Override
    public void deleteById(long id) {
        movieRepository.deleteById(id);
    }

}
