package main.java.com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.model.Booking;
import main.java.com.model.Trip;
import main.java.com.model.User;

@Repository("userInter")
@Transactional
public class UserDAOImpl implements UserInterface{

	@Autowired
	private SessionFactory sessionfactory;
	public void registerUser(User user) {
		try{
		sessionfactory.getCurrentSession().saveOrUpdate(user);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		try{
		return sessionfactory.getCurrentSession().createCriteria(User.class).list();
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trip> getTripDetails(String user_id) {
		List<Trip> trips;
		try{
			trips = sessionfactory.getCurrentSession().createQuery("FROM Trip where "
					+ "DriverID IN (SELECT driverID FROM Driverdetail where UserID = '"+user_id+"')").list();
			if(trips!=null)
				return trips;
			else
				return null;
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getBookingDetails(String user_id) {
		List<Booking> bookings;
		try{
			bookings = sessionfactory.getCurrentSession().createQuery("FROM Booking where "
					+ "PassengerID IN (SELECT passengerID FROM Passengerdetail where UserID = '"+user_id+"')").list();
			if(bookings!=null)
				return bookings;
			else
				return null;
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public User login(String email, String passwd) {
		User user=new User();
		user =(User) sessionfactory.getCurrentSession().createQuery("FROM User where email='"+email+"' and Password='"+passwd+"'").uniqueResult();
		if(null!=user)
			return user;
		else
			return null;
	}

	@Override
	public boolean forgotPasswd(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean updateProfile(User user, String userID) {
		sessionfactory.getCurrentSession().update(User.class,userID);
		return false;
	}

	@Override
	public boolean changePasswd(User user, String passwd) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public User getUserDetail(String email) {
		try{
		return (User) sessionfactory.getCurrentSession().createQuery("from User where email='"+email+"'"); 
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}

}
