package DAO.daoInterfaces;
import java.sql.Date;
import java.util.*;

import model.*;
public interface TripInterface {

//	for regular trip
	void createTrip(Trip trip,String carID);	
	
//	for frequent trip
	void createTrip(Trip trip,String carID,String frequency);
	
//	update trip detail
	void updateTripDetail(String tripID,Trip trip);
	
//	cancel trip
	boolean cancelTrip(String tripID);
	
//	search trip by destination
	List<Trip> serachTripByDestination(String destPoint);
	
	List<Trip> serachTripBySource(String Source);

	List<Trip> serachTripByType(String type);
	
	List<Trip> serachTripByDateTime(Date date);
	
	int seatsAvailable(int noOfSeats,String tripID);
}
