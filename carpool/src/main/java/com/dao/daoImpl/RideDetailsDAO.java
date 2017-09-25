package DAO;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import DAO.daoInterfaces.RidedetailInterface;
import model.Ridedetail;
import utility.SessionUtil;

public class RideDetailsDAO implements RidedetailInterface {
	//private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);
	

	@Override
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
			session.flush();
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Ridedetail> getAllRideDetails(String bookingID) {
		Session session = SessionUtil.getSession();
		List<Ridedetail> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("from Ridedetail where BookingID='"+bookingID+"'");
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
