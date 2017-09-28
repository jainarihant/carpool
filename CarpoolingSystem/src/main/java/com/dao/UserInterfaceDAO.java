package com.dao;

import java.util.List;

import com.model.*;
public interface UserInterfaceDAO {
//	for registering the user
	void registerUser(User user);
	
	List<User> getAllUsers();
	
	List<Trip> getTripDetails(String user_id);
	
	List <Booking> getBookingDetails(String user_id);
	
//	returns boolean value after successful login
	boolean login(String username,String passwd);
	
//	returns boolean value for successful matching of emailID in the database
	boolean forgotPasswd(String email);
	
//	accepts User object to update particular entry in User table
	boolean updateProfile(User user,String userID);
	
//	accept existing password of user to change the password
	boolean changePasswd(User user,String passwd);
	
	
	
}
