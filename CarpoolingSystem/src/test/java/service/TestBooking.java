package service;

import java.util.*;

import com.model.Booking;
import com.model.Driverdetail;
import com.model.Passengerdetail;
import com.model.Trip;
import com.model.User;
import com.service.BookingDAOImpl;



public class TestBooking {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date=new Date("11/09/2017");
		
		User user = new User();
		user.setUserID("U51");
		user.setFirstname("u51");
		user.setLastname("u51");
		user.setUsername("u51");
		user.setPassword("u51");
		user.setEmail("u51@gmail.com");
		user.setPhoneNo("8793388988");
		
		User user1 = new User();
		user1.setUserID("U52");
		user1.setFirstname("u52");
		user1.setLastname("u52");
		user1.setUsername("u52");
		user1.setPassword("u52");
		user1.setEmail("u52@gmail.com");
		user1.setPhoneNo("8793388989");
		
		Passengerdetail p=new Passengerdetail();
		p.setPassengerID("P3U51");
		p.setPan_aadhar_no("1122334455");
		p.setIDproof("AADHAR");
		p.setUser(user);
		
		Driverdetail d=new Driverdetail();
		d.setDriverID("D3U52");
		d.setLic_expiryDate(date);
		d.setLic_issueDate(date);
		d.setLicenceNO("111555");
		d.setUser(user1);
		
		Trip t=new Trip();
		t.setTripID("T2D3U52");
		t.setDriverdetail(d);
		t.setCarID("C3D3U52");
		t.setStartPoint("a");
		t.setDestPoint("a");
		t.setMeetingPoints("a");
		t.setEndDate(date);
		t.setDateTime(date);
		t.setFrequency("one time");
		t.setSpotsAvailable(0);
		
		Booking booking=new Booking();
		booking.setBookingID("B2");
		booking.setBookingStatus("pending");
		booking.setDepartDateTime(date);
		booking.setSpotsReserved(3);
		booking.setPassengerdetail(p);
		booking.setTrip(t);
		
		BookingDAOImpl bdao=new BookingDAOImpl();
		//bdao.bookSeat(booking,p);					//working
		//bdao.updateBookingDetails(booking);
		
		
//		if(bdao.cancelBooking("B1P3U51"))					//working				Delete booking using Booking ID
//			System.out.println("Booking canceled.");
			
		//working			Passenger will give Rating to driver
//		if(bdao.updateDriverRating("B2P3U51", "T2D3U52", "3.3"))				
//			System.out.println("Driver Rating updated");
		
		//working			Driver will give Rating to Passenger
//		if(bdao.updatePassengerRating("T2D3U52", "B2P3U51", "3.5"))
//			System.out.println("Passenger Rating updated");
		
		//working		Approve passenger	
//		if(bdao.approveBooking("B2P3U51","T2D3U52"))
//			System.out.println("Approved");
		
		//working		Deny passenger
//		if(bdao.denyBooking("B1P1U2jitesh","T1D2U2jitesh"))
//			System.out.println("Denied");
		
		List<Booking> blist=bdao.getAllBookings();
		Iterator<Booking> i = blist.iterator();
		while(i.hasNext()){
			
			Booking b = new Booking();
			b=(Booking) i.next();
			System.out.println(b.getBookingID());
		}
		//System.out.println("List of the bookings::"+blist);
		System.out.println("**************************************************************************");
		
		List<Booking> blist1=bdao.getAllBookings("T1D2U2jitesh");
		Iterator<Booking> i2 = blist1.iterator();
		while(i2.hasNext()){
			
			Booking b1 = new Booking();
			b1=(Booking) i2.next();
			System.out.println(b1.getBookingID());
		}
		//System.out.println("Result 2::"+blist1);
		
	}

}
