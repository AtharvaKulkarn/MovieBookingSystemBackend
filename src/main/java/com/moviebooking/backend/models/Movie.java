package com.moviebooking.backend.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Movie {
	
	@NotNull(message="MovieId cannot be null.")
	int movieId; 
	@NotEmpty(message="MovieName cannot be empty.")
	String movieName;
	@NotEmpty(message="MovieStatus cannot be empty.")
    MovieStatus movieStatus;
    
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public MovieStatus getMovieStatus() {
		return movieStatus;
	}
	public void setMovieStatus(MovieStatus movieStatus) {
		this.movieStatus = movieStatus;
	}
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieStatus="
				+ movieStatus + "]";
	}

}
