package com.service;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dao.TripInterfaceDAO;
import com.model.*;
import com.utility.SessionUtil;
public class TripDAOImpl implements TripInterfaceDAO {

	
	public void createTrip(Trip trip, String carID) {
		Session session = SessionUtil.getSession();
		trip.setCarID(carID);
		trip.setFrequency(null);
		
		try{
		session.getSessionFactory();
		session.beginTransaction();
		session.save(trip);
		session.getTransaction().commit();
		
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			session.flush();
			session.close();
		}
	}

	
	public void createTrip(Trip trip, String carID, String frequency) {
		Session session = SessionUtil.getSession();
		trip.setCarID(carID);
		//trip.setdr
		//trip.setDriverdetail(driver);
		trip.setFrequency(frequency);
		try{
			session.getSessionFactory();
			session.beginTransaction();
			session.save(trip);
			session.getTransaction().commit();
			}
			catch(Exception e){
				throw new RuntimeException(e);
			}finally{
				session.close();
			}

	}

	
	public boolean updateTripDetail(String tripID, Trip trip) {
		Session session = SessionUtil.getSession();
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
//			Query query=session.createSQLQuery("update Trip set startpoint='"+startP+"'"+",set destpoint='"+endP+"'"
//					+ ",set meetingpoints='"+meetP+"'"+",set datetime='"+date+"'"+",set frequency='"+freq+"'" 
//					+",set enddate='"+endD+"'"+",set spotsavailable='"+spotA+"'"
//					+"where TripID='"+tripID+"'");
			Query query=session.createQuery("from Trip where TripID=:tripID");
			query.setParameter("tripID", tripID);
			Iterator<Trip> it = query.iterate();
			while(it.hasNext()){
				Trip p = it.next();
				p.setStartPoint(trip.getStartPoint());
				p.setDestPoint(trip.getDestPoint());
				p.setMeetingPoints(trip.getMeetingPoints());
				p.setDateTime(trip.getDateTime());
				p.setFrequency(trip.getFrequency());
				p.setEndDate(trip.getEndDate());
				p.setSpotsAvailable(trip.getSpotsAvailable());
				session.saveOrUpdate(p);
			}
			//query.executeUpdate();
		   
			session.getTransaction().commit();
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				//session.flush();
				session.close();
			}
		return true;
	}

	
	public boolean cancelTrip(String tripID) {
		Session session = SessionUtil.getSession();
		try{
			
			session.getSessionFactory();
			session.beginTransaction();
			Query query = session.createQuery("DELETE FROM Trip where TripID='"+tripID+"'");
			//query.setParameter("tripID", tripID);
			query.executeUpdate();
			session.getTransaction().commit();
			
		}catch(HibernateException he){
			throw new HibernateException(he.getMessage());
		}finally{
			session.close();
		}
		return true;
	}

	
	public List<Trip> serachTripByDestination(String destination) {
		Session session = SessionUtil.getSession();
		List<Trip> result;
	try{
		session.getSessionFactory();
		session.beginTransaction();
		Query query = session.createQuery("FROM Trip where destPoint=:destPoint");
		query.setParameter("destPoint", destination);
		result=query.list();
		session.getTransaction().commit();
		
	}catch(HibernateException he){
		throw new HibernateException(he.getMessage());
	}finally{
		session.close();
	}
	return result;
	}

	
	public List<Trip> serachTripBySource(String Source) {
		Session session = SessionUtil.getSession();
		List<Trip> result;
	try{
		session.getSessionFactory();
		session.beginTransaction();
		Query query = session.createQuery("FROM Trip where startPoint='"+Source+"'");
		//query.setParameter("startPoint", startPoint);
		result=query.list();
		session.getTransaction().commit();
	}catch(HibernateException e){
		throw new HibernateException(e.getMessage());
	}finally{
		session.close();
	}
	return result;
	}

	
	public List<Trip> serachTripByType(String type) {
		Session session = SessionUtil.getSession();
		List<Trip> result;
		if(type.toLowerCase()=="frequent"){
			try{
				session.getSessionFactory();
				session.beginTransaction();
				Query query = session.createQuery("FROM Trip where tripID like 'FT%'");
				result=query.list();
				session.getTransaction().commit();
			}catch(HibernateException he){
				throw new HibernateException(he.getMessage());
			}finally{
				session.flush();
				session.close();
			}
			return result;
			}
		else{
			try{
				session.getSessionFactory();
				session.beginTransaction();
				Query query = session.createQuery("FROM Trip where tripID not like 'FT%'");
				result=query.list();
				session.getTransaction().commit();
			}catch(HibernateException he){
				throw new HibernateException(he.getMessage());
			}finally{
				session.flush();
				session.close();
			}
			return result;
		}
	}

	
	public List<Trip> serachTripByDateTime(java.util.Date dateTime) {
			Session session = SessionUtil.getSession();
			List<Trip> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			Query query = session.createQuery("FROM Trip where dateTime=:dateTime");
			query.setParameter("dateTime", dateTime);
			result=query.list();
			session.getTransaction().commit();
		}catch(HibernateException he){
			throw new HibernateException(he.getMessage());
		}finally{
			session.flush();
			session.close();
		}
		return result;
	}

	
	public int seatsAvailable(int noOfSeats, String tripID) {
		Session session = SessionUtil.getSession();
		int availableSeats = 0;
		try{
		session.getSessionFactory();
		session.beginTransaction();
		Query query=session.createQuery("from Trip where TripID=:tripID");
		query.setParameter("tripID", tripID);
		Iterator<Trip> it = query.iterate();
		while(it.hasNext()){
			Trip p = it.next();
			availableSeats=p.getSpotsAvailable()-noOfSeats;
			p.setSpotsAvailable(availableSeats);
			session.saveOrUpdate(p);
			session.getTransaction().commit();
		}
		}catch(HibernateException he){
			throw new HibernateException(he.getMessage());
		}finally {
			session.flush();
			session.close();
		}
		return availableSeats;
	}

}
