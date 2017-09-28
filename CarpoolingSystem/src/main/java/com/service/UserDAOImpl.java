package com.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.*;

import com.dao.UserInterfaceDAO;
import com.model.*;
import com.utility.SessionUtil;

public class UserDAOImpl implements UserInterfaceDAO {
	//private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);
	
	
	public void registerUser(User user) {									//working
		Session session = SessionUtil.getSession();
		try{
		session.getSessionFactory();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		}catch(Exception e){
			//LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}finally{
			session.flush();
			session.close();
		}
	}
	
	public boolean login(String username, String passwd) {					//working
		Session session = SessionUtil.getSession();
		Transaction tr = null;

		try{
			session.getSessionFactory();
			tr = session.beginTransaction();
			Query query = null;
			query = session.createQuery("FROM User where Username='"+username+"' and Password='"+passwd+"'");
			if(query!=null)
				return true;		
			
			session.getTransaction().commit();
			
		}
		catch(Exception e){
			//LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}finally{
			if(tr!=null) 
				tr.rollback();
			session.flush();
			session.close();
		}
		return false;
	}
	
	public boolean forgotPasswd(String email) {
		
		return false;
	}
	
	public boolean updateProfile(User user1,String userID) {			//working
		Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
		
			Query query=session.createQuery("from User where userID=:userID");
			query.setParameter("userID", userID);
			Iterator<User> it = query.iterate();
			while(it.hasNext()){
				User u = it.next();

				u.setFirstname(user1.getFirstname());
				u.setMiddlename(user1.getMiddlename());
				u.setLastname(user1.getLastname());
				u.setEmail(user1.getEmail());
				u.setUsername(user1.getUsername());
				u.setPassword(user1.getPassword());
				u.setPhoneNo(user1.getPhoneNo());
				
				session.saveOrUpdate(u);
				session.getTransaction().commit();
				return true;
				
			}
			//query.executeUpdate();
		   
			session.getTransaction().commit();
			}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				//session.flush();
				session.close();
			}
		return false;
	}
	
	public boolean changePasswd(User user, String passwd) {
		Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			//Query query = session.createQuery("from User");
			//List user_data = query.list();
			
			
			String uname = user.getUsername();
			Query query = session.createQuery("update User set Password = '"+passwd+"' where Username = :uname");
			query.setParameter("uname", uname);
		    query.executeUpdate();
			session.getTransaction().commit();
			
		}
		catch(Exception e){
			//LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}finally{
			session.close();
		}
			return false;
	}
	
	
	public List<User> getAllUsers() {										//working
		Session session = SessionUtil.getSession();
		List<User> user_data;
//		Transaction tr = null;
		try{
			session.getSessionFactory();
			/*tr =*/ session.beginTransaction();
			
			Query query = session.createQuery("from User");
			user_data = query.list();
//			if(!tr.wasCommitted())
//				tr.commit();
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				/*if(tr!=null)
					tr.rollback();*/
				session.flush(); session.close();
			}
		return user_data;
	}
	
	public List<Trip> getTripDetails(String user_id) {					//working
		Session session = SessionUtil.getSession();
		List<Trip> trip;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Trip where DriverID IN (SELECT driverID FROM Driverdetail where UserID = '"+user_id+"')");
			
			trip = query.list();
			
			session.getTransaction().commit();
			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.flush();
				session.close();
			}
		return trip;
	}
	
	public List<Booking> getBookingDetails(String user_id) {				//working
		Session session = SessionUtil.getSession();
		List <Booking> book;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Booking where PassengerID IN (SELECT passengerID FROM Passengerdetail where UserID = '"+user_id+"')");
			
			book = query.list();
			session.getTransaction().commit();			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.flush();
				session.close();
			}
		return book;
	}

}
