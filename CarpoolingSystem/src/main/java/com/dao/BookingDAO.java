package com.dao;

import java.util.*;

import com.model.*;

public interface BookingDAO {

	void bookSeat(Booking booking,Passengerdetail passenger);
	
	boolean updateBookingDetails(String bookingID,Booking booking);
	
	boolean cancelBooking(String bookingID);
	
	boolean updateDriverRating(String bookingID, String tripID,String rating);
	
	boolean updatePassengerRating(String tripID, String bookingID,String rating);
	
	boolean approveBooking(String bookingID,String tripID);
	
	boolean denyBooking(String bookingID,String tripID);
	
	List<Booking> getAllBookings();
	
	List<Booking> getAllBookings(String tripID);
}
