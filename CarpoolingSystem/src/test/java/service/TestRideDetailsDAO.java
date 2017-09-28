package service;

import java.util.*;

import com.model.Booking;
import com.model.Car;
import com.model.Driverdetail;
import com.model.Passengerdetail;
import com.model.Ridedetail;
import com.model.Trip;
import com.model.User;
import com.service.RideDetailsDAOImpl;
public class TestRideDetailsDAO {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		User user = new User();
		user.setUserID("U2jitesh");
		user.setFirstname("jitesh");
		user.setLastname("wadhwa");  
		user.setUsername("jtsh");
		user.setPassword("jtsh123");
		user.setEmail("jitesh@gmail.com");
		user.setPhoneNo("879338867");
		
		Driverdetail driver=new Driverdetail();
		driver.setDriverID("D2"+user.getUserID());
		Date date1 = new Date("24/09/2017");
		Date date2 = new Date("27/09/2017");
		driver.setLic_expiryDate(date1);
		driver.setLic_expiryDate(date2);
		driver.setLicenceNO("jitesh2648");
		
		
		Car car=new Car();
		car.setAC_Non_AC((byte) 1);
		car.setColor("red");
		car.setPlateNO("3465");
		car.setType("MINI");
		car.setCarID("C2"+driver.getDriverID());
		
		
		
		Passengerdetail passenger=new Passengerdetail();
		passenger.setIDproof("AADHAR");
		passenger.setPan_aadhar_no("5466488y378");
		passenger.setPassengerID("P1"+user.getUserID());
		
		
		
		
		Trip trip=new Trip();
		trip.setTripID("T1"+passenger.getPassengerID());
		trip.setCarID(car.getCarID());
		trip.setStartPoint("london");
		trip.setDestPoint("NYK");
		Date date3 = new Date("24/09/2017 00:00:00");
		trip.setDateTime(date3);
		trip.setFrequency("One Time");
		
		
		
		Booking booking=new Booking();
		booking.setBookingID("B1"+passenger.getPassengerID());
		booking.setBookingStatus("pending");
		booking.setPassengerdetail(passenger);
		booking.setTrip(trip);
		booking.setSpotsReserved(2);
		booking.setRatingForPassenger(2.5f);
		booking.setRatingForDriver(3.0f);
		Date date4= new Date("24/09/2017 00:00:00");
		booking.setDepartDateTime(date4);
		
		
		
		Ridedetail ride=new Ridedetail();
		ride.setRideID("R1"+trip.getTripID());
		ride.setCheckInTime("12:00");
		ride.setDistTravelled(10);
		ride.setPickUpSrc("street 22");
		ride.setDropDest("street 30");
		ride.setBooking(booking);
		
		
		RideDetailsDAOImpl rideDAO= new RideDetailsDAOImpl();
		//rideDAO.generateRideDetails(ride);							//working
		
		
		List<Ridedetail> rlist=rideDAO.getAllRideDetails();
		Iterator<Ridedetail> i = rlist.iterator();
		Ridedetail r = new Ridedetail();
		while(i.hasNext()){
			r=(Ridedetail) i.next();
			System.out.println(r.getRideID());
		
		}
		//System.out.println("Result::"+rlist);
		System.out.println("***************************************************************************");
		
		rlist=rideDAO.getAllRideDetails("B1P1U2jitesh");
		Iterator<Ridedetail> itr = rlist.iterator();
		Ridedetail rd = new Ridedetail();
		itr = rlist.iterator();
		while(itr.hasNext()){	
			rd=(Ridedetail) itr.next();
			System.out.println(rd.getDistTravelled());
			
		}
		//System.out.println("Result::"+rlist);
		
	}

}
