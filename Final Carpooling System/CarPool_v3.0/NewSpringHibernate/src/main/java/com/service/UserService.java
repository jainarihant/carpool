package main.java.com.service;

import java.util.List;

import main.java.com.model.*;

public interface UserService {
void registerUser(User user);
	
	List<User> getAllUsers();
	
	User login(String username,String passwd);
	
	User getUserDetail(String email);
	
	String confirmEmail(String email);
	
	List<Trip> getTripDetails(String user_id);
	
	List<Booking> getBookingDetails(String user_id);
}
