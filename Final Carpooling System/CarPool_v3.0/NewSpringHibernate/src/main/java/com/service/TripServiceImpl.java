package main.java.com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import main.java.com.dao.*;
import main.java.com.model.*;

@Service("tripService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TripServiceImpl implements TripService {

	@Autowired
	private TripInterface tripInter;

	@Override
	public void createTrip(Trip trip) {
		tripInter.createTrip(trip);
		
	}


	@Override
	public boolean updateTripDetail(String tripID, Trip trip) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelTrip(String tripID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)	
	public List<Trip> serachTripByDestination(String destination,String type) {
		return tripInter.serachTripByDestination(destination,type);
	}

	@Override
	public List<Trip> serachTripBySource(String Source,Date date) {
		return tripInter.serachTripBySource(Source,date);
	}
	
	@Override
	public List<Trip> serachTripBySource(String Source,String type) {
		return tripInter.serachTripBySource(Source,type);
	}

	@Override
	public List<Trip> serachTripByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> serachTripByDateTime(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int seatsAvailable(int noOfSeats, String tripID) {
		return tripInter.seatsAvailable(noOfSeats, tripID);
	}

	@Override
	public Trip getTripById(String selectedTripId) {
		return tripInter.getTripById(selectedTripId);
	}

	@Override
	public List<Trip> getTripsCreatedByMe(String driverId) {
		return tripInter.getTripsCreatedByMe(driverId);
	}


	@Override
	public List<Trip> getAllTrips() {
		List<Trip> trips;
		trips = tripInter.getAllTrips();
		if(trips!=null)
			return trips;
		else
			return trips;
	}

	

}
