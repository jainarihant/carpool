package com.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.PassengerDetailDAO;
import com.model.*;
import com.utility.SessionUtil;
public class PassengerDAOImpl implements PassengerDetailDAO {

	

	
	public void registerPassenger(Passengerdetail passenger) {
		Session session = SessionUtil.getSession();
		int cnt=1;
		//passenger.setPassengerID("P"+cnt+user.getUserID());
		
		try{
			session.getSessionFactory();
			session.beginTransaction();
			session.save(passenger);
			session.getTransaction().commit();
			
			}catch(Exception e){
				
				throw new RuntimeException(e.getMessage());
			}finally{
				session.close();
			}
		
	}

	
	public List<Passengerdetail> getPassengerDetails() {
		Session session = SessionUtil.getSession();
		List<Passengerdetail> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("FROM Passengerdetail");
			result=query.list();
			
			session.getTransaction().commit();
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.close();
			}
		return result;
	}

	
	public List<Passengerdetail> getPassengerDetail(String userID) {
		Session session = SessionUtil.getSession();
		List<Passengerdetail> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("FROM Passengerdetail where userid = '"+userID+"'");
			result=query.list();
			
			session.getTransaction().commit();
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.close();
			}
		return result;
	}

	
//	public boolean updatePassengerDetails(Passengerdetail passenger) {
//		
//		return false;					// function not required
//	}
	
	

}
