package DAO.daoInterfaces;

import java.util.List;

import model.*;

public interface CarInterface {
	
/*  it should accept DriverID and make the respective entries in the car table  * */	
	void registerCar(String driverID);						

/* accept the carID and update * */
	void updateCarDetail(String carID, Car car);			

/*	display the details of all the cars */
	List<Car> getAllCarDetails();
	
/* display all the details of cars for particular user */
	List<Car> getAllCarDetails(String driverID);
	
/* deletes the car details for selected car */
	boolean deleteCar(Car car);					// set DriverID to null, if Driver wants to delete particular car.						
	
}
