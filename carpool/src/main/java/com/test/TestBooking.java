package tests;

import java.util.*;
import java.text.*;

import DAO.BookingDAO;
import model.*;

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
		
		BookingDAO bdao=new BookingDAO();
		//bdao.bookSeat(booking,p);					//working
		//bdao.updateBookingDetails(booking);
		//bdao.cancelBooking("B1P3U51");					//working				Delete booking using Booking ID
		//bdao.updateDriverRating("B2P3U51", "T2D3U52", "3.3");	//working			Passenger will give Rating to driver
		//bdao.updatePassengerRating("T2D3U52", "B2P3U51", "3.5");//working			Driver will give Rating to Passenger
		//System.out.println(bdao.approveBooking("B2P3U51","T2D3U52"));//working		Approve passenger	
		
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
		Iterator i2 = blist1.iterator();
		while(i2.hasNext()){
			
			Booking b1 = new Booking();
			b1=(Booking) i2.next();
			System.out.println(b1.getBookingID());
		}
		//System.out.println("Result 2::"+blist1);
		
	}

}
