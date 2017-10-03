package main.java.com.service;

import java.util.List;

import main.java.com.model.Car;

public interface CarService {
	/*  it should accept DriverID and make the respective entries in the car table  * */	
	void registerCar(Car car);									

/*	display the details of all the cars */
	List<Car> getAllCarDetails();
	
/* display all the details of cars for particular user */
	List<Car> getAllCarDetails(String driverID);
	
/* deletes the car details for particular DriverID */
	boolean deleteCar(String driverID);					// set DriverID to null, if Driver wants to delete particular car.						

/*	deletes the car details */
	boolean deleteCar(Car car);	
	
	Car getCarDetail(String CarID);
}
