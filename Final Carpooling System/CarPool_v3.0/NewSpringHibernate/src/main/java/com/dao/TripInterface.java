package main.java.com.dao;
import java.util.*;

import main.java.com.model.Trip;

public interface TripInterface {

//	for regular trip
	void createTrip(Trip trip);	
	
	List<Trip> getAllTrips();
	
//	update trip detail
	boolean updateTripDetail(String tripID,Trip trip);
	
//	cancel trip
	boolean cancelTrip(String tripID);
	
//	search trip by destination
	List<Trip> serachTripByDestination(String destination,String type);
	
	List<Trip> serachTripBySource(String Source,Date date);
	List<Trip> serachTripBySource(String source,String type); 

	List<Trip> serachTripByType(String type);
	
	List<Trip> serachTripByDateTime(java.util.Date date);
	
	int seatsAvailable(int noOfSeats,String tripID);

	Trip getTripById(String selectedTripId);

	List<Trip> getTripsCreatedByMe(String driverId);
}
