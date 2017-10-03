package main.java.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.dao.CarDAOImpl;
import main.java.com.dao.CarInterfaceDAO;
import main.java.com.dao.DriverDetailDAO;
import main.java.com.model.Car;
@Service("carService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CarServiceImpl implements CarService{
	@Autowired
	private CarInterfaceDAO carInter= new CarDAOImpl();
	
	@Override
	public void registerCar(Car car) {
		carInter.registerCar(car);
		
	}

	@Override
	public List<Car> getAllCarDetails() {
		return carInter.getAllCarDetails();
	}

	@Override
	public List<Car> getAllCarDetails(String driverID) {
		List<Car> cars = carInter.getAllCarDetails(driverID);
		if(cars!=null)
			return cars;
		return null;
	}

	@Override
	public boolean deleteCar(String driverID) {
		// TODO Auto-generated method stub
		return carInter.deleteCar(driverID);
	}

	@Override
	public boolean deleteCar(Car car) {
		// TODO Auto-generated method stub
		return carInter.deleteCar(car);
	}

	@Override
	public Car getCarDetail(String carID) {
		System.out.println("Service : "+carID);
		return carInter.getCarDetail(carID);
		/*Car car = new Car();
		try{
			System.out.println("Service : "+carID);
		car = carInter.getCarDetail(carID);
		System.out.println("Service : "+carID);
		if(car!=null)
			return car;
		else
			return null;
		}catch(NullPointerException ne){
			throw new RuntimeException(ne.getMessage());
		}*/
	}

}
