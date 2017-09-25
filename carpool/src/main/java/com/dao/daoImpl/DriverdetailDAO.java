package DAO;
import java.util.List;

import org.hibernate.*;

import DAO.daoInterfaces.*;
import model.Driverdetail;
import utility.SessionUtil;
public class DriverdetailDAO implements DriverDetail{

		Session session = SessionUtil.getSession();
	@Override
	public void registerDriver(Driverdetail driver) {
		// TODO Auto-generated method stub
		try{
			session.getSessionFactory();
			session.beginTransaction();
			session.save(driver);
			session.getTransaction().commit();
			session.close();
			}catch(Exception e){
				
				throw new RuntimeException(e.getMessage());
			}finally{
				session.close();
			}
	}

	@Override
	public List<Driverdetail> getDriverDetails() {
		
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
			}
		return result;
	}


	@Override
	public Driverdetail getDriverDetail(String userID) {
		// TODO Auto-generated method stub
		session.getSessionFactory();
		
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
		
			Driverdetail driver = (Driverdetail)session.get(Driverdetail.class,userID);
			session.getTransaction().commit();
			return driver;
		}catch(HibernateException he)
		{
			if(tx!=null)
				tx.rollback();
			he.printStackTrace();
		}
		
		finally{
			session.close();
		}
		return null;
	}

	@Override
	public boolean updateDriverDetails(Driverdetail driver) {
		// TODO Auto-generated method stub
		return false;
	}

}

