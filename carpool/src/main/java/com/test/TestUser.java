package tests;

import model.*;
import java.util.*;

import java.util.List;

import DAO.*;
import javassist.bytecode.Descriptor.Iterator;
public class TestUser {

	public static void main(String[] args) {
		User user = new User();
		user.setUserID("U4akshay");
		user.setFirstname("Akshay");
		user.setLastname("Jagtap");
		user.setUsername("akjagz");
		user.setPassword("akjagz");
		user.setEmail("akjagz@gmail.com");
		user.setPhoneNo("8793388836");
		
		UserDAO userdao = new UserDAO();
		
		//*******for registration of user:-
		//userdao.registerUser(user);
		
		//*******for displaying list of users:-
		/*List<User> user_data = userdao.getAllUsers();
		java.util.Iterator<User> i = user_data.iterator();
		while(i.hasNext()){
			User u = new User();
			u = (User)i.next();
			System.out.println(u.getFirstname()+" "+u.getPassword()+" "+u.getLastname()+" "+u.getPhoneNo()+" "+u.getEmail()+" "+u.getUserID());
		}*/
		
		//*******for changing user password:-
		//userdao.changePasswd(user, "anjali");
		
//		******* verifying login credentials :-
//		boolean b=userdao.login(user,"akjagz","akjag");
//		System.out.println(b);
		
		
		//*******Forgot password :-
		//userdao.forgotPasswd(user, "arihant");
		
	
		User user1 = new User();
		user1.setUserID("U4akshay");
		user1.setFirstname("Akshay");
		user1.setLastname("Jagtap");
		user1.setUsername("akjagz");
		user1.setPassword("akjagz");
		user1.setEmail("akjagz@gmail.com");
		user1.setPhoneNo("8308350106");
	
		//*******Update query:-
		//userdao.updateProfile(user1, "U2siri");
		
		//********Update user data:-
		userdao.updateProfile(user1, "U4akshay");
		
		/*
		List<Trip> trip = userdao.getTripDetails("U1anjali");
		java.util.Iterator<Trip> i = trip.iterator();
		while(i.hasNext()){
			Trip t=new Trip();
			t = (Trip) i.next();
			System.out.println(t.getCarID());	
		}
		System.out.println("**********");
		List<Booking> book = userdao.getBookingDetails("U2siri");
		java.util.Iterator<Booking> i1 = book.iterator();
		while(i1.hasNext()){
			Booking b = new Booking();
			b = (Booking)i1.next();
			System.out.println(b.getBookingID());
		
	}	 */
		/*
		List<User> user_data = userdao.getPassengerDriver();
		java.util.Iterator<User> i = user_data.iterator();
		while(i.hasNext()){
			User u = new User();
			u = (User)i.next();
			System.out.println(u.getFirstname()+" "+u.getUserID());
		}
		*/
	}
	}
