package main.java.com.dao;

import java.util.List;

import main.java.com.model.Passengerdetail;

public interface PassengerDetailDAO {

	void registerDriver(Passengerdetail driver);
	
	Passengerdetail getPassengerDetail(String userID);
	
	List<Passengerdetail> getPassengerDetails();
}
