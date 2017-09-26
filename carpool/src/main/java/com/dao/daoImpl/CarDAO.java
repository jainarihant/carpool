package main.java.com.dao.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import DAO.daoInterfaces.CarInterface;
import model.Car;
import utility.SessionUtil;

public class CarDAO implements CarInterface {
	
	Session session = SessionUtil.getSession();
	@Override
	public void registerCar(Car car) {
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
		/*finally{
			session.close();	
		}*/
	}

	@Override
	public void updateCarDetail(String carID, Car car) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Car> getAllCarDetails() {
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
			}
		return result;	
	}

	@Override
	public List<Car> getAllCarDetails(String driverID){
		List<Car> result;
		try{
			session.getSessionFactory();
			session.beginTransaction();
			
			Query query=session.createQuery("from Car where DriverID='"+driverID+"'");
			result=query.list();
			
			//session.getTransaction().commit();
			//session.close();
			}catch(Exception e){
				//LOGGER.debug(e.getMessage());
				throw new RuntimeException(e.getMessage());
			}finally{
				session.close();
			}
		return result;
		
		}

	@Override
	public boolean deleteCar(String driverID) {

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
			}
		return false;
	}

}
