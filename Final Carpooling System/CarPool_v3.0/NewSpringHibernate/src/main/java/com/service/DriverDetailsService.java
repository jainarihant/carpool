package main.java.com.service;

import java.util.List;

import main.java.com.model.Driverdetail;

public interface DriverDetailsService {
	void registerDriver(Driverdetail driver);
	
//	return all the registered drivers
	List<Driverdetail> getDriverDetails();
	
//	return only a particular Driver
	Driverdetail getDriverDetails(String userID);
}
