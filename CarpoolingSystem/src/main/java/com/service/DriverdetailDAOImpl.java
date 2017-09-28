package com.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.DriverDetailDAO;
import com.model.*;
import com.utility.SessionUtil;

public class DriverdetailDAOImpl implements DriverDetailDAO{

	
	public void registerDriver(Driverdetail driver) {
		Session session = SessionUtil.getSession();
		int cnt=1;
		//driver.setDriverID("D"+cnt+user.getUserID());
		
		try{
			session.getSessionFactory();
			session.beginTransaction();
			session.save(driver);
			session.getTransaction().commit();
			
			}catch(Exception e){
				
				throw new RuntimeException(e.getMessage());
			}finally{
				session.close();
			}
		
	}

	
	public List<Driverdetail> getDriverDetails() {
		Session session = SessionUtil.getSession();
		List<Driverdetail> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("FROM Driverdetail");
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

	
	public List<Driverdetail> getDriverDetails(String userID) {
		Session session = SessionUtil.getSession();
		List<Driverdetail> result;
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

	
//	public boolean updateDriverDetails(Driverdetail driver) {
//		// TODO Auto-generated method stub
//		return false;							//irrelevant functionality
//	}

}
