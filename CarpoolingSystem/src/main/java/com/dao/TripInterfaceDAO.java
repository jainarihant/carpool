package com.dao;

import java.util.*;

import com.model.*;
public interface TripInterfaceDAO {

//	for regular trip
	void createTrip(Trip trip,String carID);	
	
//	for frequent trip
	void createTrip(Trip trip,String carID,String frequency);
	
//	update trip detail
	boolean updateTripDetail(String tripID,Trip trip);
	
//	cancel trip
	boolean cancelTrip(String tripID);
	
//	search trip by destination
	List<Trip> serachTripByDestination(String destination);
	
	List<Trip> serachTripBySource(String Source);

	List<Trip> serachTripByType(String type);
	
	List<Trip> serachTripByDateTime(java.util.Date date);
	
	int seatsAvailable(int noOfSeats,String tripID);
}
