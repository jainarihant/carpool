package tests;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import DAO.RideDetailsDAO;
import model.*;
public class TestRideDetails {
	
	public static void main(String[] args) {
		
		User user = new User();
		user.setUserID("U4jitesh");
		user.setFirstname("jitesh");
		user.setLastname("abc");  
		user.setUsername("jtsh");
		user.setPassword("jtsh123");
		user.setEmail("jitesh@gmail.com");
		user.setPhoneNo("879338899");
		
		Driverdetail driver=new Driverdetail();
		driver.setDriverID("D"+user.getUserID());
		Date date1 = new Date("24/09/2017");
		Date date2 = new Date("27/09/2017");
		driver.setLic_expiryDate(date1);
		driver.setLic_expiryDate(date2);
		driver.setLicenceNO("jitesh2648");
		
		
		Car car=new Car();
		car.setAC_Non_AC((byte) 1);
		car.setColor("red");
		car.setPlateNO("3465");
		car.setType("mini");
		car.setCarID("C"+driver.getDriverID());
		
		
		
		Passengerdetail passenger=new Passengerdetail();
		passenger.setIDproof("AADHAR");
		passenger.setPan_aadhar_no("5466488y378");
		passenger.setPassengerID("P"+user.getUserID());
		
		
		
		
		Trip trip=new Trip();
		trip.setTripID("T"+passenger.getPassengerID());
		trip.setCarID(car.getCarID());
		trip.setStartPoint("london");
		trip.setDestPoint("newyork");
		Date date3 = new Date("24/09/2017");
		trip.setDateTime(date3);
		trip.setFrequency("2");
		
		
		
		Booking booking=new Booking();
		booking.setBookingID("B"+passenger.getPassengerID());
		booking.setBookingStatus("pending");
		booking.setPassengerdetail(passenger);
		booking.setTrip(trip);
		booking.setSpotsReserved(2);
		booking.setRatingForPassenger(2.5f);
		booking.setRatingForDriver(3.0f);
		Date date4= new Date("24/09/2017 00:00:00");
		booking.setDepartDateTime(date4);
		
		
		
		Ridedetail ride=new Ridedetail();
		ride.setRideID("R"+trip.getTripID());
		ride.setCheckInTime("12:00");
		ride.setDistTravelled(10.0f);
		ride.setPickUpSrc("street 22");
		ride.setDropDest("street 30");
		ride.setBooking(booking);
		
		
		RideDetailsDAO rideDAO= new RideDetailsDAO();
		
		List<Ridedetail> rlist=rideDAO.getAllRideDetails();
		Iterator i = rlist.iterator();
		Ridedetail r = new Ridedetail();
		while(i.hasNext()){
			
			
			r=(Ridedetail) i.next();
			System.out.println(r.getRideID());
		
		}
		System.out.println("Result::"+rlist);
		
		
		
		//********** method getRide Details using booking id***
		System.out.println("for particular booking id");
		rlist=rideDAO.getAllRideDetails("BPU4jitesh");
		Iterator itr = rlist.iterator();
		Ridedetail rd = new Ridedetail();
		itr = rlist.iterator();
		while(itr.hasNext()){
			
			
			rd=(Ridedetail) itr.next();
			System.out.println(rd.getRideID());
			
		}
		System.out.println("Result::"+rlist);
		
		
	}

}
