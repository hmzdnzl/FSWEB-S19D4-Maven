package com.workintech.s19d1.service;

import java.util.List;

import com.workintech.s19d1.entity.Movie;

public interface MovieService {
public List<Movie> findAll();
public Movie findById(long id);
public Movie save(Movie movie);
public Movie update(long id, Movie movie);
	public void deleteById(long id);
}
