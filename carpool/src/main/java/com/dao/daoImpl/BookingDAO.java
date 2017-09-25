package DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.daoInterfaces.*;
import model.*;
import utility.SessionUtil;

public class BookingDAO implements BookingInterface{

	
	@Override
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

	@Override
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

	@Override
	public String approveBooking(String bookingID, String tripID) {
			Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("update Booking set BookingStatus=:temp where TripID=:tripID and BookingID=:bookingID");
			query.setParameter("temp", "approved");
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
	
		return "Approved";
	}

	@Override
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
	
	@Override
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

	@Override
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

	@Override
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
