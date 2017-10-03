package main.java.com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.model.Car;


@Repository("carInter")
@Transactional
public class CarDAOImpl implements CarInterfaceDAO {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public void registerCar(Car car) {;
		try{
			sessionfactory.getCurrentSession().save(car);
		}catch(HibernateException he){
			he.printStackTrace();
		}
	}


	@Override
	public List<Car> getAllCarDetails() {
		List<Car> result;
		try{
			Query query=sessionfactory.getCurrentSession().createQuery("from Car");
			result=query.list();
			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
		return result;
	}

	@Override
	public List<Car> getAllCarDetails(String driverID) {
		List<Car> result;
		try{
			Query query=sessionfactory.getCurrentSession().createQuery("from Car where DriverID='"+driverID+"'");
			result=query.list();
			
			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
		return result;
	}

	@Override
	public boolean deleteCar(String driverID) {
		try{
			Query query=sessionfactory.getCurrentSession().createQuery("delete from Car where DriverID='"+driverID+"'");
			query.executeUpdate();
			//session.close();
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
		return true;
	}

	
	@Override
	public boolean deleteCar(Car car){
		try{
			sessionfactory.getCurrentSession().delete(car);
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
		return false;
	}


	@Override
	public Car getCarDetail(String carID) {
		Car car = new Car();
		try{
			System.out.println("DAO : "+carID);
			car = (Car) sessionfactory.getCurrentSession().createQuery("FROM Car where carID='"+carID+"'").uniqueResult();
			if(car!=null)
				return car;
			else
				return null;			
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}
	}
	
//	@Override
//	public void updateCarDetail(String carID, Car car) {
//		
//
//	}
	
	
}
