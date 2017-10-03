package main.java.com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.model.Passengerdetail;
import main.java.com.model.User;
import main.java.com.service.PassengerService;
import main.java.com.service.PassengerServiceImpl;


@Controller
public class Passengercontroller {

	@Autowired
	private PassengerService passengerService = new PassengerServiceImpl();
	
	
	@RequestMapping(value="/addPDetails", method = RequestMethod.POST)
	public ModelAndView registerPassengerDetails(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap<String, Object>();
				Passengerdetail passenger = new Passengerdetail();
				User user = new User();
				session=request.getSession();
				user = (User) session.getAttribute("user");
				passenger.setUser(user);
				int number = passengerService.getPassengerDetails().size();
				number++;
				String id = String.valueOf(number);
				passenger.setPassengerID("P"+id+user.getUserID());
				passenger.setIDproof(request.getParameter("idproof"));
				passenger.setPan_aadhar_no(request.getParameter("idproofno"));
				
				passengerService.registerPassenger(passenger);
				session.setAttribute("passenger", passenger);
				map.put("passenger", passenger);
				return new ModelAndView("searchTrips",map);
	}
	
	@RequestMapping(value="/searchTrips",method=RequestMethod.GET)
	public ModelAndView searchTrip(){
		return new ModelAndView("searchTrips");
	}
	
	
	@RequestMapping(value="checkPDetail",method=RequestMethod.POST)
	public ModelAndView checkPDetail(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session = request.getSession();
		Map<String,Object> map = new HashMap<String, Object>();
		User user = new User();
		user = (User)session.getAttribute("user");
		String userID = user.getUserID();
		Passengerdetail passenger = new Passengerdetail();
		passenger = (Passengerdetail)passengerService.getPassengerDetail(userID);
		if(passenger!=null)
		{
			session.setAttribute("passenger", passenger);
			map.put("passenger",passenger);
			return new ModelAndView("searchTrips",map);
		}
		map.put("user", user);
		return new ModelAndView("pdetails");
	}
	
}
