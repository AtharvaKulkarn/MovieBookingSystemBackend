package com.moviebooking.backend.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.backend.models.Booking;
import com.moviebooking.backend.repositories.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/bookMovie")
	public ResponseEntity<String> bookMovie(@RequestBody @Valid Booking book) {

		String response = null;
		try {
			// Hit third party api with given booking id AND SPECIFY the timeout as 2 min for your request, if they gave success then continue
			// else remove request

			//Hardcoded so that we can insert dummy data
			String res = "Success";
			if (res.equals("Success")) {
				response = bookingService.makeBooking(book);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			response = "your request could not be processed.";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
