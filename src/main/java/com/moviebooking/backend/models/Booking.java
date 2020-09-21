package com.moviebooking.backend.models;

import java.util.Arrays;

import javax.validation.constraints.NotEmpty;

public class Booking {

	@NotEmpty(message = "Name cannot be empty.")
	String name;
	String mobNo;
	int bookingId;
	int userId;
	int movieId;
	int[] seats;
	int amount;
	PaymentStatus status_of_payment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int[] getSeats() {
		return seats;
	}

	public void setSeats(int[] seats) {
		this.seats = seats;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public PaymentStatus getStatus_of_payment() {
		return status_of_payment;
	}

	public void setStatus_of_payment(PaymentStatus status_of_payment) {
		this.status_of_payment = status_of_payment;
	}

	@Override
	public String toString() {
		return "Booking [name=" + name + ", mobNo=" + mobNo + ", bookingId=" + bookingId + ", userId=" + userId
				+ ", movieId=" + movieId + ", seats=" + Arrays.toString(seats) + ", amount=" + amount
				+ ", status_of_payment=" + status_of_payment + "]";
	}

}
