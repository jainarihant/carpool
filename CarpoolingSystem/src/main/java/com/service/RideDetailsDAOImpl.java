package com.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.RidedetailInterfaceDAO;
import com.model.*;
import com.utility.SessionUtil;

public class RideDetailsDAOImpl implements RidedetailInterfaceDAO {

//	Session session = SessionUtil.getSession();
	
	
	public void generateRideDetails(Ridedetail ride) {
		Session session = SessionUtil.getSession();
		Transaction tr = null;
		try{
			session.getSessionFactory();
			tr = session.beginTransaction();
			session.save(ride);
			session.getTransaction().commit();
		}catch(HibernateException he){
			if(tr!=null)
				tr.rollback();
			he.printStackTrace();
		}finally{
			session.close();
		}
	}

	
	public List<Ridedetail> getAllRideDetails() {
		Session session = SessionUtil.getSession();
		List<Ridedetail> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("from Ridedetail");
			result=query.list();
			
			session.getTransaction().commit();
			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally {
				session.flush();
				session.close();
			}
		return result;
	}

	
	public List<Ridedetail> getAllRideDetails(String BookingID) {
		Session session = SessionUtil.getSession();
		List<Ridedetail> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("from Ridedetail where BookingID='"+BookingID+"'");
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

}
