package com.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.CarInterfaceDAO;
import com.model.*;
import com.utility.SessionUtil;

public class CarDAOImpl implements CarInterfaceDAO {
	
//	Session session = SessionUtil.getSession();

	
	public void registerCar(Car car) {
		Session session = SessionUtil.getSession();
		Transaction tr=null;
		try{
			tr=session.beginTransaction();
			session.save(car);
			session.getTransaction().commit();
		}catch(HibernateException he){
			if(tr!=null)
				tr.rollback();
			he.printStackTrace();
		}
		finally{
			session.flush();
			session.close();	
		}
	}


	
	public List<Car> getAllCarDetails() {
		Session session = SessionUtil.getSession();
		List<Car> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("from Car");
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

	
	public List<Car> getAllCarDetails(String driverID) {
		Session session = SessionUtil.getSession();
		List<Car> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("from Car where DriverID='"+driverID+"'");
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

	
	public boolean deleteCar(String driverID) {
			Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
			Query query=session.createQuery("delete from Car where DriverID='"+driverID+"'");
			query.executeUpdate();
			session.getTransaction().commit();
			//session.close();
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.flush();
				session.close();
			}
		return true;
	}

	
	
	public boolean deleteCar(Car car){
		Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
			session.delete(car);
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
	
	
//	public void updateCarDetail(String carID, Car car) {    //irrelevant functionalitys
//		
//
//	}
	
	
}
