package main.java.com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.model.Booking;
import main.java.com.model.Driverdetail;
import main.java.com.model.Passengerdetail;
import main.java.com.model.Trip;
import main.java.com.model.User;
import main.java.com.service.BookingService;
import main.java.com.service.PassengerService;
import main.java.com.service.TripService;
import main.java.com.service.UserService;

@Controller
public class Bookingcontroller {
	String selectedTripId;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private TripService tripService;
	@Autowired
	private PassengerService passengerService;
	

	@RequestMapping(value="/bookSeat",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("booking")Booking booking,
			HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session = request.getSession();
		Passengerdetail passenger = (Passengerdetail) session.getAttribute("passenger");
		
		Trip trip1 = (Trip) session.getAttribute("trip");
		
		int temp=bookingService.getAllBookings().size()+1;
		booking.setBookingID("B"+temp+passenger.getPassengerID());
		int spotsToBeReserved=Integer.parseInt(request.getParameter("spots"));
		
		if(spotsToBeReserved <= trip1.getSpotsAvailable() && trip1.getSpotsAvailable()>0){
			booking.setSpotsReserved(spotsToBeReserved);	
			booking.setDepartDateTime(trip1.getDateTime());
			booking.setBookingStatus("pending");
			booking.setRatingForDriver(0);
			booking.setRatingForPassenger(0);
			booking.setPassengerdetail(passenger);	
			int tempSeats = tripService.seatsAvailable(spotsToBeReserved,trip1.getTripID());  	
			booking.setTrip(trip1);
			if(tempSeats >= 0)
			{	bookingService.bookSeat(booking, passenger);
				return new ModelAndView("profile");
			}
			else
			{
				return new ModelAndView("bookSeat2","seats","Enter Correct no. of Seats");
			}
		}
		else
		{
			return new ModelAndView("bookSeat2","seats","Enter Correct no. of Seats");
		}
	}
	
	//list bookings by passenger
	@RequestMapping(value = "/listBookings", method = RequestMethod.POST)
	public ModelAndView showUsers(@ModelAttribute("bookings")  Booking booking,
			BindingResult result,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		session = request.getSession();
		
		Passengerdetail passenger = (Passengerdetail)session.getAttribute("passenger");	
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bookings", bookingService.getAllBookings(passenger)); 		//pass passenger		
		return new ModelAndView("bookingList", model);
	}	

	//list trips created by driver
	@RequestMapping(value = "/listTrips", method = RequestMethod.POST)
	public ModelAndView showMyTrips(@ModelAttribute("myTrips")  Trip trip,
			BindingResult result,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		session = request.getSession();
		Driverdetail driver= (Driverdetail) session.getAttribute("driver");
		Map<String, Object> model = new HashMap<String, Object>();
		List<Trip> tripsByMe = tripService.getTripsCreatedByMe(driver.getDriverID());
		model.put("myTrips",tripsByMe); 		
		return new ModelAndView("myTripsList", model);
	}
	
	
	@RequestMapping(value="/rate",method=RequestMethod.POST)
	public ModelAndView getPassengers(@ModelAttribute("bookings")Booking booking,
			HttpServletRequest request,HttpServletResponse response){
		
		String tripId1=request.getParameter("submittype");
	
		Trip t=tripService.getTripById(tripId1);
		List<Booking> p=bookingService.getAllBookings(t);

		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tid",tripId1);
		model.put("bookings", p); 
		return new ModelAndView("RateBooking", model);
				
	}
	
	@RequestMapping(value="/rateThisBooking",method=RequestMethod.POST)
	public ModelAndView rateThisBooking(@ModelAttribute("bookings")Booking booking,
			HttpServletRequest request,HttpServletResponse response){
		
		String bookingId=request.getParameter("bid");
		String tripId=request.getParameter("tid");
		String rating=request.getParameter("rating");
		System.out.println(""+bookingId+""+tripId+""+rating+"");
		bookingService.updatePassengerRating(tripId, bookingId, rating);

		return new ModelAndView("profile");
		
				
	}
	
}
