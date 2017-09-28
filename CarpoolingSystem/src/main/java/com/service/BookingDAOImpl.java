package com.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.BookingDAO;
import com.model.*;
import com.utility.SessionUtil;


public class BookingDAOImpl implements BookingDAO{

	
	public void bookSeat(Booking booking,Passengerdetail passenger) {
		Session session = SessionUtil.getSession();		 
		booking.setBookingID("B2"+passenger.getPassengerID());
		//count++;
		
		try{
			session.getSessionFactory();
			session.beginTransaction();
			session.save(booking);
			session.getTransaction().commit();
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.flush();
				session.close();
			}
		//return 1;
	}

	
	public boolean updateBookingDetails(String bookingID,Booking booking) {
		Session session = SessionUtil.getSession();	
		try{
			session.getSessionFactory();
			session.beginTransaction();
			Query query=session.createQuery("from Booking where bookingID=:bookingID");
			query.setParameter("bookingID", bookingID);
			Iterator<Booking> it = query.iterate();
			while(it.hasNext()){
				Booking p = it.next();
				p.setBookingStatus(booking.getBookingStatus());
				p.setDepartDateTime(booking.getDepartDateTime());
				p.setPassengerdetail(booking.getPassengerdetail());
				p.setRatingForDriver(booking.getRatingForDriver());
				p.setRatingForPassenger(booking.getRatingForPassenger());
				p.setSpotsReserved(booking.getSpotsReserved());
				p.setRidedetails(booking.getRidedetails());
				p.setTrip(booking.getTrip());
				session.saveOrUpdate(p);
			}
			//query.executeUpdate();
		   
			session.getTransaction().commit();
		}catch(Exception e){
			//LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}finally{
			session.flush();
			session.close();
		}
		return false;
	}

	
	public boolean cancelBooking(String bookingID) {
		Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query = session.createQuery("DELETE FROM Booking where bookingid=:bookingID");
			query.setParameter("bookingID", bookingID);
		    query.executeUpdate();
			
			session.getTransaction().commit();

			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.flush();
				session.close();
			}
		return false;
	}

	

	
	public boolean approveBooking(String bookingID, String tripID) {
			Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("update Booking set BookingStatus=:temp where TripID=:tripID and BookingID=:bookingID");
			query.setParameter("temp", "Approved");
			query.setParameter("tripID", tripID);
			query.setParameter("bookingID", bookingID);
			query.executeUpdate();
		    
			session.getTransaction().commit();
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.flush();
				session.close();
			}
	
		return true;
	}
	
	
	public boolean denyBooking(String bookingID, String tripID) {
			Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("update Booking set BookingStatus=:temp where TripID=:tripID and BookingID=:bookingID");
			query.setParameter("temp", "Denied");
			query.setParameter("tripID", tripID);
			query.setParameter("bookingID", bookingID);
			query.executeUpdate();
		    
			session.getTransaction().commit();
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.flush();
				session.close();
			}
	
		return true;
	}

	
	public List<Booking> getAllBookings() {
		Session session = SessionUtil.getSession();
		List<Booking> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("from Booking");
			result=query.list();
			
			session.getTransaction().commit();
			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.flush();
				session.close();
			}
		return result;
	}

	
	public List<Booking> getAllBookings(String tripID) {
		Session session = SessionUtil.getSession();
		List<Booking> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("from Booking where TripID='"+tripID+"'");
			//query.setParameter("tripID",tripID);
			result=query.list();
			
			session.getTransaction().commit();

			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.flush();
				session.close();
			}
		return result;
	}

	
	public boolean updateDriverRating(String bookingID, String tripID, String rating) {
		Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("update Booking set RatingForDriver=:rating  where TripID=:tripID and BookingID=:bookingID");
			query.setParameter("rating", rating);
			query.setParameter("tripID", tripID);
			query.setParameter("bookingID", bookingID);
			query.executeUpdate();
		    
			session.getTransaction().commit();
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.flush();
				session.close();
			}
		return true;
	}

	
	public boolean updatePassengerRating(String tripID, String bookingID, String rating) {
		Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("update Booking set RatingForPassenger=:rating  where TripID=:tripID and BookingID=:bookingID");
			query.setParameter("rating", rating);
			query.setParameter("tripID", tripID);
			query.setParameter("bookingID", bookingID);
			query.executeUpdate();
		    
			session.getTransaction().commit();

			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.flush();
				session.close();
			}
		return false;
	}

}
