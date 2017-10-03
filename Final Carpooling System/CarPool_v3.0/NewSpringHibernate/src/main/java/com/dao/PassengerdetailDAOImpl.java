package main.java.com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.model.Passengerdetail;

@Repository("passengerInter")
@Transactional
public class PassengerdetailDAOImpl implements PassengerDetailDAO {

	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public void registerDriver(Passengerdetail passenger) {
		try{
			sessionfactory.getCurrentSession().saveOrUpdate(passenger);
			
			}catch(Exception e){
				
				throw new RuntimeException(e.getMessage());
			}

	}

	@Override
	public Passengerdetail getPassengerDetail(String userID) {
		Passengerdetail passenger = new Passengerdetail();
		try{
			
			passenger =(Passengerdetail) sessionfactory.getCurrentSession().createQuery("FROM Passengerdetail where userid = '"+userID+"'").uniqueResult();
			if(passenger!=null)
				return passenger;
			else
				return null;
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Passengerdetail> getPassengerDetails() {
		return sessionfactory.getCurrentSession().createCriteria(Passengerdetail.class).list();
	}

}
