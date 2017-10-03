package main.java.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.dao.BookingInterface;

import main.java.com.model.Booking;
import main.java.com.model.Passengerdetail;
import main.java.com.model.Trip;
import main.java.com.model.User;


@Service("bookingService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingInterface bookingInter;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void bookSeat(Booking booking, Passengerdetail passenger) {
		bookingInter.bookSeat(booking, passenger);
		
	}

	@Override
	public boolean updateBookingDetails(Booking booking) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelBooking(String bookingID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDriverRating(String bookingID, String tripID, String rating) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean updatePassengerRating(String tripID, String bookingID, String rating) {
		return bookingInter.updatePassengerRating(tripID, bookingID, rating);
	}

	@Override
	public boolean approveBooking(String bookingID, String tripID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean denyBooking(String bookingID, String tripID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingInter.getAllBookings();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public List<Booking> getAllBookings(Trip trip) {
		return bookingInter.getAllBookings(trip);
	}

	@Override
	public List<Booking> getAllBookings(Passengerdetail p) {
		return bookingInter.getAllBookings(p);
	}

	

	
	
	

}
