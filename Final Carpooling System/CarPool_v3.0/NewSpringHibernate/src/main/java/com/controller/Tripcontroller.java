	package main.java.com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import main.java.com.model.Car;
import main.java.com.model.Driverdetail;
import main.java.com.model.Passengerdetail;
import main.java.com.model.Trip;
import main.java.com.model.User;
import main.java.com.service.BookingService;
import main.java.com.service.CarService;
import main.java.com.service.PassengerService;
import main.java.com.service.TripService;
import main.java.com.service.UserService;

@Controller
public class Tripcontroller {
	
	@Autowired
	private TripService tripService;
	@Autowired
	private CarService carService;
	//search 
	@RequestMapping(value="/findRide",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("trips")Trip trip,
			HttpServletRequest request,HttpServletResponse response){
		
		String source=request.getParameter("from");
		String destination=request.getParameter("to");
		String type=request.getParameter("type");
		String type1=request.getParameter("type1");					
			
		Map<String, Object> model = new HashMap<String, Object>();
		if(type.equalsIgnoreCase("Search By Source"))
			model.put("trips", tripService.serachTripBySource(source,type1)); 		
		else if(type.equalsIgnoreCase("Search By Destination"))
			model.put("trips", tripService.serachTripByDestination(destination,type1)); 
		else 
			model.put("trips", tripService.serachTripBySource(source,type1)); 
		return new ModelAndView("Rides", model);
		
		
	}
	
	//book seat
	@RequestMapping(value="/trips",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("trips")Trip trip,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String, Object> model = new HashMap<String, Object>();
		session = request.getSession();
		String tripID = request.getParameter("submittype");
		trip=tripService.getTripById(tripID); 
		session.setAttribute("trip", trip);
		model.put("selectedTripId", request.getParameter("submittype")); 	
		model.put("remSpots",request.getParameter("remSpots"));
		model.put("trips", trip);
		return new ModelAndView("bookSeat2", model);
	}
	
	@RequestMapping(value="/createTrip",method=RequestMethod.POST)
	public ModelAndView createTrip(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session = request.getSession();
		Car car = new Car();
		String carID = request.getParameter("carID"); 
		car = carService.getCarDetail(carID); 
		if(car!=null)
		{	session.setAttribute("car", car);
			return new ModelAndView("createTrip");
		}
		else
			return new ModelAndView("showCars","car","car not available...");
		
	}
	
	@RequestMapping(value="/createNewTrip",method=RequestMethod.POST)
	public ModelAndView createNewTrip(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap();
		session = request.getSession();
		Driverdetail driver = (Driverdetail)session.getAttribute("driver");
		Car car = (Car)session.getAttribute("car"); 
		Trip trip = new Trip();
		int size = tripService.getAllTrips().size();
		size++;
		trip.setStartPoint(request.getParameter("startPoint"));
		trip.setDestPoint(request.getParameter("endPoint"));
		trip.setMeetingPoints(request.getParameter("meetingPoint"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		try {
			java.util.Date date=sdf.parse(request.getParameter("startDate"));
			java.util.Date date2=sdf.parse(request.getParameter("endDate"));
			trip.setDateTime(date);
			trip.setEndDate(date2);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String freq=request.getParameter("freq");
		if(freq.equalsIgnoreCase("OneTime"))
			trip.setTripID("T"+String.valueOf(size)+driver.getDriverID());
		else
			trip.setTripID("FT"+size+driver.getDriverID());
		
		trip.setSpotsAvailable(Integer.parseInt(request.getParameter("spotsAvailable")));
		trip.setPreferences(request.getParameter("preferences"));
		trip.setCarID(car.getCarID());
		trip.setDriverdetail(driver);
		tripService.createTrip(trip);
		map.put("trip", trip);
		return new ModelAndView("tripConfirm");
	}
		
}
