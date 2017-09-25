package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;

import DAO.daoInterfaces.UserInterface;
import model.*;
import utility.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAO implements UserInterface {
	//private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);
	Session session = SessionUtil.getSession();
	@Override
	public void registerUser(User user) {
		int cnt=1; 
		String email; 
		String[] emailPart = null;
		if(user.getUsername()==null)				// check for username initially, if null set to emailID
			user.setUsername(user.getEmail());
		else{
			 email = user.getEmail();							//
			 emailPart = email.split("@");
			System.out.println(emailPart[0]);
		}
//		generate UserID in the form of "U+(count++)+(part of EmailID before @)
		user.setUserID("U"+cnt+emailPart[0]);
		cnt++;
		
		try{
		session.getSessionFactory();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		}catch(Exception e){
			//LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}
	@Override
	public boolean login(User user, String username, String passwd) {
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			String uname = user.getUsername();
			String pwd = user.getPassword();
			
			if(uname == username && pwd == passwd)			
				return true;
			
			
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			//LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		return false;
	}
		
	@Override
	public boolean forgotPasswd(User user, String passwd) {
		try{
			session.getSessionFactory();
			session.beginTransaction();			
			
			String user_email = user.getEmail();
			Query query = session.createQuery("update User set Password = '"+passwd+"' where Username = :user_email");
			query.setParameter("email", user_email);
		    query.executeUpdate();
			
		    session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			//LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		return false;
	}
	/*@Override
	public void updateProfile(User user, String UserID) {
		
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			//String user_id = user.getUserID();
			String first_name = user.getFirstname();
			String middle_name = user.getMiddlename();
			String last_name = user.getLastname();
			String user_name = user.getUsername();
			String password = user.getPassword();
			String email = user.getEmail();
			String phone_no = user.getPhoneNo();
			
			Query query = session.createQuery("UPDATE User set Firstname = '"+first_name+"', Middlename = '"+middle_name+"',Lastname = '"+last_name+"', Username = '"+user_name+"', Password = '"+password+"',Email='"+email+"', PhoneNo = '"+phone_no+"' where UserID = '"+UserID+"' ");
		    query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
	}*/
	@Override
	public boolean changePasswd(User user, String passwd) {
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
			session.close();
		}
		catch(Exception e){
			//LOGGER.debug(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
			return false;
	}
	@Override
	public List<User> getAllUsers() {
		List<User> user_data;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query = session.createQuery("from User");
			user_data = query.list();
			
			session.getTransaction().commit();
			session.close();
			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
		return user_data;
	}
	
	public List<Trip> getTripDetails(String user_id){
		List<Trip> trip;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Trip where DriverID IN (SELECT driverID FROM Driverdetail where UserID = '"+user_id+"')");
			
			trip = query.list();
			
			session.getTransaction().commit();
			session.close();
			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
		return trip;
	}
	
	
	public List <Booking> getBookingDetails(String user_id){
		List <Booking> book;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query = session.createQuery("FROM Booking where PassengerID IN (SELECT passengerID FROM Passengerdetail where UserID = '"+user_id+"')");
			
			book = query.list();
			
			session.getTransaction().commit();
			session.close();
			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
		return book;
	}
	
	/*
	public List<User> getPassengerDriver() {
		List<User> user_data;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			Query query;
			//Query query = session.createQuery("from User WHERE EXISTS (select UserID from Passengerdetail) AND EXISTS (select userID from Driverdetail)");
			List<User> user=null;
			user =  session.createQuery("Select UserID from Passengerdetail").list();
			Iterator it = user.iterator();
			List<String> list_userid = new ArrayList<String>();
			while(it.hasNext()){
				User newuser = new User();
				newuser = (User) it.next();
				String user_id = newuser.getUserID();
				list_userid.add(user_id);
			}
			user = session.createQuery("Select UserID from Driverdetail where UserID in ("+list_userid+")").list();
			Iterator it1 = user.iterator();
			List<String> list_userid1 = new ArrayList<String>();
			while(it1.hasNext()){
				User newuser = new User();
				newuser = (User) it1.next();
				String user_id = newuser.getUserID();
				list_userid1.add(user_id);
			}
			query = session.createQuery("from User WHERE UserID in ("+list_userid1+")");
			user_data = query.list();
			
			session.getTransaction().commit();
			session.close();
			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
		return user_data;
	}
	*/
	
	@Override
	public void updateProfile(User user, String userID){
		Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
		
			Query query=session.createQuery("from User where userID=:userID");
			query.setParameter("userID", userID);
			Iterator<User> it = query.iterate();
			while(it.hasNext()){
				User u = it.next();
				u.setFirstname(user.getFirstname());
				u.setMiddlename(user.getMiddlename());
				u.setLastname(user.getLastname());
				u.setEmail(user.getEmail());
				u.setUsername(user.getUsername());
				u.setPassword(user.getPassword());
				u.setPhoneNo(user.getPhoneNo());
				
				session.saveOrUpdate(u);
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
	}
	
	

}
