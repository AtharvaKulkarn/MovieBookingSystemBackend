package com.moviebooking.backend.repositories;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moviebooking.backend.models.Booking;
import com.moviebooking.backend.models.Movie;
import com.moviebooking.backend.models.MovieStatus;
import com.moviebooking.backend.models.PaymentStatus;

@Component
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	private TheatreService theatreService;

	HashMap<String,Booking> bookingHash = new HashMap<>();
	
	@Override
	public synchronized String makeBooking(Booking book) {
		
		Movie movie = theatreService.getMovie(book.getMovieId());
		
		if(movie.getMovieStatus()==MovieStatus.Movie_Available && !bookingHash.containsKey(book.getName()) &&
				checkSeatAvailability(book.getSeats()) && book.getStatus_of_payment().equals(PaymentStatus.PAID)) {
			
			bookingHash.put(book.getName(), book);
			return "Seats booked!";
		} 
		return "Seats are not available!";
		
	}
	private boolean checkSeatAvailability(int[] seats) {
		
		if(seats.length > 6) {
			return false;
		}
		
		Iterator<Entry<String, Booking>> itr = bookingHash.entrySet().iterator(); 
		HashSet<Integer> hashSet = new HashSet<>();
		
		while(itr.hasNext()) {
			Map.Entry map = (Entry) itr.next();
			Booking bok = (Booking) map.getValue();
			int[] bookedArray = bok.getSeats();
			
			for(int i=0;i<bookedArray.length;i++) {
				hashSet.add(bookedArray[i]);
			}
			
			for(int i=0;i<seats.length;i++) {
				if(hashSet.contains(seats[i])) {
					return false;
				}
			}
		}
	
		return true;
	}

}
