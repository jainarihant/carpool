package main.java.com.dao;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.model.*;

@Repository
@Transactional
public class DriverdetailDAOImpl implements DriverDetailDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	public void registerDriver(Driverdetail driver) {		
		try{
			sessionfactory.getCurrentSession().saveOrUpdate(driver);
			
			}catch(Exception e){
				
				throw new RuntimeException(e.getMessage());
			}
		
	}

	
	@SuppressWarnings("unchecked")
	public List<Driverdetail> getDriverDetails() {
		return sessionfactory.getCurrentSession().createCriteria(Driverdetail.class).list();
	}

	
	public Driverdetail getDriverDetails(String userID) {
		Driverdetail driver = new Driverdetail();
		try{
			
			driver =(Driverdetail) sessionfactory.getCurrentSession().createQuery("FROM Driverdetail where userid = '"+userID+"'").uniqueResult();
			if(driver!=null)
				return driver;
			else
				return null;
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
	}

	

}
