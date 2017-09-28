package service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.model.Booking;
import com.model.Trip;
import com.model.User;
import com.service.UserDAOImpl;

;
public class TestUser {

	public static void main(String[] args) {
		User user = new User();
		user.setUserID("U3mithun17");
		user.setFirstname("Mithun");
		user.setLastname("Vasanth");
		user.setUsername("mithun1");
		user.setPassword("mithin1");
		user.setEmail("mithun.vasanth@gamil.com");
		user.setPhoneNo("0987654321");
		
		UserDAOImpl userdao = new UserDAOImpl();
		//userdao.registerUser(user);						//working	
		
		System.out.println(userdao.login("charmi1","charmi1"));
		
		System.out.println(userdao.changePasswd(user,"mithun17"));
		
		List<User> blist = userdao.getAllUsers();		//working
		Iterator<User> i=blist.iterator();
		while(i.hasNext())
		{
		User u=new User();
		u=(User)i.next();
		System.out.println(u.getUserID());
		System.out.println(u.getFirstname());
		System.out.println(u.getLastname());
		}
		System.out.println("**************************************************************");
		
		List<Booking> blist1 = userdao.getBookingDetails("U52");		//working
		Iterator<Booking> i1=blist1.iterator();
		while(i1.hasNext())
		{
			Booking u=new Booking();
		u=(Booking)i1.next();
		System.out.println(u.getBookingID());
		System.out.println(u.getBookingStatus());
		System.out.println(u.getSpotsReserved());
		}
		System.out.println("**************************************************************");
		
		List<Trip> blist2 = userdao.getTripDetails("U6arihant");		//working
		Iterator<Trip> i2=blist2.iterator();
		while(i2.hasNext())
		{
			Trip u=new Trip();
		u=(Trip)i2.next();
		System.out.println(u.getTripID());
		System.out.println(u.getCarID());
		System.out.println(u.getSpotsAvailable());
		}
		System.out.println("**************************************************************");
		

		
		User user1 = new User();
		user1.setUserID("U7prat");
		user1.setFirstname("Pratik");
		user1.setMiddlename("A");
		user1.setLastname("Jagtap");
		user1.setUsername("prat118");
		user1.setPassword("prat118");
		user1.setEmail("pratik.jagtap@atos.net");
		user1.setPhoneNo("8308350019");
		
		//System.out.println(userdao.updateProfile(user1,"U7prat"));
		
	}	
}
