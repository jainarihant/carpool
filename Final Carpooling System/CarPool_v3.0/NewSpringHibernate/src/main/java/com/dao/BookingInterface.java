package main.java.com.dao;
import java.util.*;

import main.java.com.model.Booking;
import main.java.com.model.Passengerdetail;
import main.java.com.model.Trip;

public interface BookingInterface {

	void bookSeat(Booking booking,Passengerdetail passenger);
	
	boolean updateBookingDetails(Booking booking);
	
	boolean cancelBooking(String bookingID);
	
	boolean updateDriverRating(String bookingID, String tripID,String rating);
	
	boolean updatePassengerRating(String tripID, String bookingID,String rating);
	
	boolean approveBooking(String bookingID,String tripID);
	
	boolean denyBooking(String bookingID,String tripID);
	
	List<Booking> getAllBookings();
	
	List<Booking> getAllBookings(Trip trip);
	
	public List<Booking> getAllBookings(Passengerdetail p);
}
