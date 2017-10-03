package main.java.com.service;

import java.util.Date;
import java.util.List;

import main.java.com.model.Booking;
import main.java.com.model.Passengerdetail;
import main.java.com.model.Trip;
import main.java.com.model.User;

public interface TripService {
	
//	for regular trip
	void createTrip(Trip trip);	
	
	List<Trip> getAllTrips();
	
//	update trip detail
	boolean updateTripDetail(String tripID,Trip trip);
	
//	cancel trip
	boolean cancelTrip(String tripID);
	
//	search trip by destination
	List<Trip> serachTripByDestination(String destination,String type);
	

	List<Trip> serachTripByType(String type);
	
	List<Trip> serachTripByDateTime(java.util.Date date);
	
	int seatsAvailable(int noOfSeats,String tripID);

	List<Trip> serachTripBySource(String Source, Date date);
	public List<Trip> serachTripBySource(String source,String type);

	Trip getTripById(String selectedTripId);

	List<Trip> getTripsCreatedByMe(String driverId); 
}
