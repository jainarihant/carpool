package main.java.com.dao;

import java.util.List;

import main.java.com.model.*;

public interface CarInterfaceDAO {
	
/*  it should accept DriverID and make the respective entries in the car table  * */	
	void registerCar(Car car);									

/*	display the details of all the cars */
	List<Car> getAllCarDetails();
	
/* display all the details of cars for particular user */
	List<Car> getAllCarDetails(String driverID);
	
/* deletes the car details for particular DriverID */
	boolean deleteCar(String driverID);					
	/*	deletes the car details */
	boolean deleteCar(Car car);	
	
	Car getCarDetail(String carID);
}
