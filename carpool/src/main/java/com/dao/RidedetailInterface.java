package DAO.daoInterfaces;
import java.util.List;
import model.*;

public interface RidedetailInterface {

	void generateRideDetails(Ridedetail ride);
	List<Ridedetail> getAllRideDetails();
	List<Ridedetail> getAllRideDetails(String bookingID);
	
}

