package com.workintech.s19d1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MovieController {
private MovieService movieService;

public MovieController(MovieService movieService) {
    this.movieService = movieService;
}

@GetMapping("/movies")
public List<Movie> allMovies() {
    return movieService.findAll();
}

@GetMapping("/movies/{id}")
public Movie findMovieById(@PathVariable long id) {
    return movieService.findById(id);
}

 @PostMapping("/movies")
    public void createMovieAndActor(@RequestBody MovieActorRequest request) {
        Movie movie = request.getMovie();
        Actor actor = request.getActor();       
        movie.getActors().add(actor);
        actor.getMovies().add(movie);      
        movieService.save(movie);
    }

      @PutMapping("/movies/{id}")
    public Movie updateActor(@PathVariable long id, @RequestBody Movie movie) {
       Movie movieUpdated = findMovieById(id);
    movieUpdated.setName(movie.getName());
    movieUpdated.setDirectorName(movie.getDirectorName());
    movieUpdated.setRating(movie.getRating());
    movieUpdated.setReleaseDate(movie.getReleaseDate());
    movieUpdated.setActors(movie.getActors());
return movieService.save(movieUpdated);      
    }

@DeleteMapping("/movies/{id}")
public Movie deletMovie(@PathVariable long id) {
    return movieService.findById(id);
}

}
