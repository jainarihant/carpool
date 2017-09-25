package tests;
import java.util.Date;
import java.util.List;

import DAO.TripDAO;
import DAO.UserDAO;
import model.*;
public class TestTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserID("U2siri");
		user.setFirstname("Siri");
		user.setLastname("Raj");
		user.setUsername("siri1");
		user.setPassword("f0282da007e6efecf0787ad0f6c9ea7f8f433b58");
		user.setEmail("siri@gmail.com");
		user.setPhoneNo("1234567890");
		
		Driverdetail driver = new Driverdetail();
		driver.setUser(user);
		System.out.println(driver.getUser().getUserID());
		driver.setDriverID("DUsiri");
		driver.setLicenceNO("helo12");
		Date date1 = new Date("24/09/2017"); 
		driver.setLic_expiryDate(date1);
		driver.setLic_issueDate(date1);
		
		Trip trip = new Trip();
		trip.setStartPoint("chennaiji");
		trip.setDestPoint("banagaloreji");
		trip.setMeetingPoints("hyderabad,panaji");
		trip.setDateTime(date1);
		//trip.setFrequency("2");
		trip.setEndDate(date1);
		trip.setSpotsAvailable(4);
		trip.setEndDate(null);
		trip.setTripID("T1DUsiri");
		trip.setDriverdetail(driver);
		TripDAO tripdao = new TripDAO();
		tripdao.updateTripDetail("T1DUsiri", trip);
		//int new2 = tripdao.seatsAvailable(1, "T1DUsiri");
		//System.out.println(new2);
		//System.out.println(tripdao.serachTripByType("regular"));
		System.out.println(tripdao.serachTripByDateTime((java.sql.Date) new Date("2018-12-09 00:00:00")));
		//tripdao.createTrip(trip, "DUsiri","2");
		//tripdao.cancelTrip("T1UDsome1");
//		List<Trip> arr=tripdao.serachTripByDestination("banagalore");
//		System.out.println(arr.size()); //error in loading
		
	}

}
