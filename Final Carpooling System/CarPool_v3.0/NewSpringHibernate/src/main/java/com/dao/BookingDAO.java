package main.java.com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.model.Booking;
import main.java.com.model.Passengerdetail;
import main.java.com.model.Trip;
import main.java.com.model.User;


@Repository("bookingInter")
@Transactional
public class BookingDAO implements BookingInterface{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void bookSeat(Booking booking,Passengerdetail passenger) {
				 
		sessionfactory.getCurrentSession().saveOrUpdate(booking);		
		
	}

	@Override
	public boolean updateBookingDetails(Booking booking) {
		
		return false;
	}

	@Override
	public boolean cancelBooking(String bookingID) {
		
		return false;
	}

	

	@Override
	public boolean approveBooking(String bookingID, String tripID) {
			
		return true;
	}
	
	@Override
	public boolean denyBooking(String bookingID, String tripID) {
		
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Booking> getAllBookings() {

		return sessionfactory.getCurrentSession().createCriteria(Booking.class).list();
	}
	

	@SuppressWarnings("unchecked")
	public List<Booking> getAllBookings(Passengerdetail p) {
		
		return sessionfactory.getCurrentSession().createCriteria(Booking.class).
				add( Restrictions.eq("passengerdetail",p)).list();
	}

	@SuppressWarnings("unchecked")
	public List<Booking> getAllBookings(Trip trip) {
		
	
		Query query=sessionfactory.getCurrentSession().createQuery("from Booking where TripID='"+trip.getTripID()+"'");
		
		return query.list();
	}
	
	@Override
	public boolean updateDriverRating(String bookingID, String tripID, String rating) {
		
		return true;
	}

	@Override
	public boolean updatePassengerRating(String tripID, String bookingID, String rating) {
		Query query=sessionfactory.getCurrentSession().createQuery("update Booking set RatingForPassenger='"+rating+"'  where TripID='"+tripID+"' and BookingID='"+bookingID+"'");
		query.executeUpdate();
		return true;		
	}


}
