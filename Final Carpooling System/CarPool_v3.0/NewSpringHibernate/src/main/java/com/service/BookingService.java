package main.java.com.service;

import java.util.List;

import main.java.com.model.Booking;
import main.java.com.model.Passengerdetail;
import main.java.com.model.Trip;
import main.java.com.model.User;

public interface BookingService {
	
	void bookSeat(Booking booking,Passengerdetail passenger);
	
	boolean updateBookingDetails(Booking booking);
	
	boolean cancelBooking(String bookingID);
	
	boolean updateDriverRating(String bookingID, String tripID,String rating);
	
	boolean updatePassengerRating(String tripID, String bookingID,String rating);
	
	boolean approveBooking(String bookingID,String tripID);
	
	boolean denyBooking(String bookingID,String tripID);
	
	List<Booking> getAllBookings();
	

	public List<Booking> getAllBookings(Passengerdetail p);

	List<Booking> getAllBookings(Trip trip);
}
