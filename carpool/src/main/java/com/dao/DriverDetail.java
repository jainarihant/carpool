package DAO.daoInterfaces;

import java.util.List;

import model.*;
public interface DriverDetail {
	
//	registering the driver 
	void registerDriver(Driverdetail driver, User user);
	
//	return all the registered drivers
	List<Driverdetail> getDriverDetails();
	
//	return only a particular Driver
	Driverdetail getDriverDetail(User user);
	
//	Update driver detail, license issue_date and expiry_date
	boolean updateDriverDetails(Driverdetail driver);
	
	Driverdetail getDriverDetail(String driverID);
}
