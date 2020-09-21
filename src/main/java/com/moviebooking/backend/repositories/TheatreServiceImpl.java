package com.moviebooking.backend.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.moviebooking.backend.models.Movie;
import com.moviebooking.backend.models.MovieStatus;

@Component
public class TheatreServiceImpl implements TheatreService {

	HashMap<Integer, Movie> hash = new HashMap<>();

	@Override
	public String addMovie(Movie movie) {

		if (!hash.containsKey(movie.getMovieId())) {
			hash.put(movie.getMovieId(), movie);
			return "Movie added!";
		}

		return "Movie already present";
	}

	@Override
	public Movie getMovie(Integer movieId) {
		if(hash.containsKey(movieId)) {
			return hash.get(movieId);
		}
		return null;
	}
	
	@Override
	public List<Movie> getAllMovies(){
		List<Movie> list = new ArrayList<>();
		
		Iterator<Entry<Integer, Movie>> itr = hash.entrySet().iterator(); 
		while(itr.hasNext()) {
			Map.Entry map = (Entry) itr.next();
			list.add((Movie) map.getValue());
		}
		
		return list;
	}
	
	@Override
	public String updateMovie(Movie movie) {
		
		int id = movie.getMovieId();
		MovieStatus status = movie.getMovieStatus();
		if(hash.containsKey(id)) {
			hash.get(id).setMovieStatus(status);
			return "Movie updated!";
		}
		return "Movie not present!";
	}

}
