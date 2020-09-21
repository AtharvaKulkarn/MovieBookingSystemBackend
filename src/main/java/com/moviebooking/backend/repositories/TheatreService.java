package com.moviebooking.backend.repositories;

import java.util.List;

import com.moviebooking.backend.models.Movie;

public interface TheatreService {
	
	public String addMovie(Movie movie);
	
	public Movie getMovie(Integer movieId);
	
	public List<Movie> getAllMovies();
	
	public String updateMovie(Movie movie);

}
