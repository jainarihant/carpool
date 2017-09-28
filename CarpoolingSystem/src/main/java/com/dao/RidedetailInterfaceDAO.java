package com.dao;
import java.util.List;

import com.model.*;

public interface RidedetailInterfaceDAO {

	void generateRideDetails(Ridedetail ride);
	
	List<Ridedetail> getAllRideDetails();
	
	List<Ridedetail> getAllRideDetails(String BookingID);
	
}
