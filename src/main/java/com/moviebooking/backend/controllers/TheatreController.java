package com.moviebooking.backend.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.backend.models.Movie;
import com.moviebooking.backend.repositories.TheatreService;

@RestController
public class TheatreController {
	
	@Autowired
	private TheatreService bms;
	
	@PostMapping("/addMovie")
	public ResponseEntity<String> addMovie(@RequestBody @Valid Movie movie){
		String response = null;
		try {
			response = bms.addMovie(movie); 
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/updateMovie")
	public ResponseEntity<String> updateMovie(@RequestBody @Valid Movie movie){
		String response = null;
		try {
			response = bms.updateMovie(movie);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getMovieById")
	public ResponseEntity<Movie> getMovies(@RequestParam(required=true) Integer movieId){
		
		try {
			return new ResponseEntity<>( bms.getMovie(movieId),HttpStatus.OK);
		} catch(NullPointerException e){
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAllMovies")
	public ResponseEntity<List<Movie>> getAllMovies(){
		
		try {
			List<Movie> list = bms.getAllMovies();
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}

}
