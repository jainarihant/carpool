package com.dao;

import java.util.List;

import com.model.*;
public interface DriverDetailDAO {
	
//	registering the driver 
	void registerDriver(Driverdetail driver);
	
//	return all the registered drivers
	List<Driverdetail> getDriverDetails();
	
//	return only a particular Driver
	List<Driverdetail> getDriverDetails(String userID);
	
//	Update driver detail, license issue_date and expiry_date
//	boolean updateDriverDetails(Driverdetail driver);  //irrelevant functionality
}
