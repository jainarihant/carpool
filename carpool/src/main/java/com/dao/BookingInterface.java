package DAO.daoInterfaces;
import model.*;
import java.util.*;

public interface BookingInterface {

	void bookSeat(Booking booking,Passengerdetail passenger);
	
	boolean updateBookingDetails(Booking booking);
	
	boolean cancelBooking(String bookingID);
	
	boolean updateDriverRating(String bookingID, String tripID,String rating);
	
	boolean updatePassengerRating(String tripID, String bookingID,String rating);
	
	String approveBooking(String bookingID,String tripID);
	
	List<Booking> getAllBookings();
	
	List<Booking> getAllBookings(String tripID);
}
