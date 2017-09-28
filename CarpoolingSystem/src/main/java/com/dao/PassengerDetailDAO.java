package com.dao;
import java.util.List;

import com.model.*;
public interface PassengerDetailDAO {
	
//	registering the passenger
	void registerPassenger(Passengerdetail passenger);
	
//	return all the registered passengers
	List<Passengerdetail> getPassengerDetails();
	
//	return only a particular Passenger
	List<Passengerdetail> getPassengerDetail(String userID);
	
//	Update passenger detail,Id proof
//	boolean updatePassengerDetails(Passengerdetail passenger); 		//function irrelevant
//
//
}
