package DAO.daoInterfaces;

import model.*;
public interface UserInterface {
//	for registering the user
	void registerUser(User user);
	
//	returns boolean value after successful login
	boolean login(String username,String passwd);
	
//	returns boolean value for successful matching of emailID in the database
	boolean forgotPasswd(String email);
	
//	accepts User object to update particular entry in User table
	void updateProfile(User user);
	
//	accept existing password of user to change the password
	boolean changePasswd(String passwd,String uname);
	
	User getUserDetails(String uname);
	
}
