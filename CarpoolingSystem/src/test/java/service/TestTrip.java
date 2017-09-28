package service;

import java.util.*;

import com.model.Driverdetail;
import com.model.Trip;
import com.model.User;
import com.service.TripDAOImpl;

public class TestTrip {

	public static void main(String[] args) {
		User user = new User();
		user.setUserID("U6arihant");
		user.setFirstname("Arihant");
		user.setLastname("Jain");
		user.setUsername("arihant1");
		user.setPassword("arihant1");
		user.setEmail("arihant.jain@gmail.com");
		user.setPhoneNo("0987654321");
		
		Driverdetail driver = new Driverdetail();
		driver.setUser(user);
		System.out.println(driver.getUser().getUserID());
		driver.setDriverID("D4"+user.getUserID());
		driver.setLicenceNO("helo12");
		Date date1 = new Date("24/09/2017"); 
		driver.setLic_expiryDate(date1);
		driver.setLic_issueDate(date1);
		
		Trip trip = new Trip();
		trip.setStartPoint("chennaiji");
		trip.setDestPoint("banagaloreji");
		trip.setMeetingPoints("hyderabad,panaji");
		trip.setDateTime(date1);
		//trip.setFrequency("One time");
		trip.setEndDate(date1);
		trip.setSpotsAvailable(3);
		trip.setEndDate(null);
		trip.setTripID("FT3"+driver.getDriverID());
		trip.setDriverdetail(driver);
		TripDAOImpl tripdao = new TripDAOImpl();
		//tripdao.createTrip(trip, "C4D4U6arihant");
		
		//tripdao.createTrip(trip, "C4D4U6arihant","Daily");
		
		//tripdao.updateTripDetail("T2"+driver.getDriverID(), trip);
		
		
 
		//System.out.println("Seats available : "+ tripdao.seatsAvailable(1, "T2"+driver.getDriverID()));
		
		List<Trip> tlist = tripdao.serachTripByType("frequent");		//List of all Passengers
		Iterator<Trip> n=tlist.iterator();
		while(n.hasNext())
		{
			Trip p=new Trip();
		p=(Trip)n.next();
		System.out.println(p.getTripID());
		System.out.println(p.getStartPoint());
		System.out.println(p.getDestPoint());
		}
		System.out.println("**************************************************************");
		
		/*List<Trip> dtlist = tripdao.serachTripByDateTime((java.util.Date) new Date("2018-12-09 00:00:00"));		//List 
		Iterator<Trip> m=dtlist.iterator();
		while(m.hasNext())
		{
			Trip p=new Trip();
		p=(Trip)m.next();
		System.out.println(p.getTripID());
		System.out.println(p.getStartPoint());
		System.out.println(p.getDestPoint());
		}
		System.out.println("**************************************************************");*/
		
		
		//System.out.println(tripdao.cancelTrip("T1D4U6arihant"));
		
		List<Trip> stlist = tripdao.serachTripBySource("chennaiji");		//List 
		Iterator<Trip> m=stlist.iterator();
		while(m.hasNext())
		{
			Trip p=new Trip();
		p=(Trip)m.next();
		System.out.println(p.getTripID());
		System.out.println(p.getStartPoint());
		System.out.println(p.getDestPoint());
		}
		System.out.println("**************************************************************");
		
		
		
//		List<Trip> arr=tripdao.serachTripByDestination("banagalore");
		List<Trip> dtlist = tripdao.serachTripByDestination("banagaloreji");		//List 
		Iterator<Trip> l=dtlist.iterator();
		while(l.hasNext())
		{
			Trip p=new Trip();
		p=(Trip)l.next();
		System.out.println(p.getTripID());
		System.out.println(p.getStartPoint());
		System.out.println(p.getDestPoint());
		}
		System.out.println("**************************************************************");
		
		
//		System.out.println(dtlist.size()); //error in loading

		
		

	}

}
