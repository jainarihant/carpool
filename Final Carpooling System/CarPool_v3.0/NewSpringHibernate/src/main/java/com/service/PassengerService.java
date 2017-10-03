package main.java.com.service;

import java.util.List;

import main.java.com.model.Passengerdetail;

public interface PassengerService {

void registerPassenger(Passengerdetail driver);
	
	Passengerdetail getPassengerDetail(String userID);
	
	List<Passengerdetail> getPassengerDetails();
}
