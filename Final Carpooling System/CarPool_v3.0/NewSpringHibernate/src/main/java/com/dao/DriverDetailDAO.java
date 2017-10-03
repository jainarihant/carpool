package main.java.com.dao;

import java.util.List;

import main.java.com.model.*;
public interface DriverDetailDAO {
	
//	registering the driver 
	void registerDriver(Driverdetail driver);
	
//	return all the registered drivers
	List<Driverdetail> getDriverDetails();
	
//	return only a particular Driver
	Driverdetail getDriverDetails(String userID);
	
}
