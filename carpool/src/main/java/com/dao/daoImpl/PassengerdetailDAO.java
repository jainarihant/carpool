package DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.daoInterfaces.PassengerDetail;
import model.Passengerdetail;
import model.User;
import utility.SessionUtil;

public class PassengerdetailDAO implements PassengerDetail {
	Session session= SessionUtil.getSession();
	@Override
	public void registerPassenger(Passengerdetail passenger) {
		
		int cnt=1;
		//passenger.setPassengerID("P"+cnt+user.getUserID());
		
		try{
			session.getSessionFactory();
			session.beginTransaction();
			session.save(passenger);
			session.getTransaction().commit();
			session.close();
			}catch(Exception e){
				
				throw new RuntimeException(e.getMessage());
			}
		}
	@Override
	public List<Passengerdetail> getPassengerDetails() {
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
			}
		return result;
	}


	@Override
	public List<Passengerdetail> getPassengerDetail(String userID) {
		List<Passengerdetail> result=null;
		session.getSessionFactory();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("from Passengerdetail where UserID='"+userID+"'");
			Passengerdetail passenger = (Passengerdetail)session.get(Passengerdetail.class,userID);
			result=query.list();
			session.getTransaction().commit();
		}catch(HibernateException he)
		{
			if(tx!=null)
				tx.rollback();
			he.printStackTrace();
		}
		
		finally{
			session.close();
		}
		return result;
	}

	@Override
	public boolean updatePassengerDetails(Passengerdetail passenger) {
		// TODO Auto-generated method stub
		return false;
	}

}
