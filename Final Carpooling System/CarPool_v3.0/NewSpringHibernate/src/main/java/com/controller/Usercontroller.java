package main.java.com.controller;

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


import main.java.com.model.*;
import main.java.com.service.UserService;
import main.java.com.service.UserServiceImpl;

@Controller
public class Usercontroller {
	@Autowired
	private UserService userService = new UserServiceImpl();
	
	@RequestMapping(value="home")
	public ModelAndView showhomePage(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		return new ModelAndView("pratik");
	}
	
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView showUsers(@ModelAttribute("users")  User user,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users", userService.getAllUsers());
		return new ModelAndView("usersList", model);
	}
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("users")User user,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap<String, Object>();
		String email = request.getParameter("email");
		String otp = userService.confirmEmail(email);
		if(null!=otp){
			user.setEmail(email);
			if(user.getUserID()==null){
				String[] userID = user.getEmail().split("@");
				int size=userService.getAllUsers().size();size++;
				user.setUserID("U"+size);
			}
			user.setFirstname(request.getParameter("firstname")); user.setLastname(request.getParameter("lastname"));
			user.setUsername(user.getFirstname());
			user.setPassword(request.getParameter("password"));
			user.setPhoneNo(request.getParameter("phoneno"));
			session = request.getSession();
			 session.setAttribute("user", user);
			 session.setAttribute("verifyOTP", otp);
			 //User user1 = (User) session.getAttribute("user");
			//map.put("user", user);
			//map.put("otp", otp);
			return new ModelAndView("verifyOTP",map);
		}
		map.put("invalidEmail", "Invalid email");
		return new ModelAndView("loginPage",map);
	}
	
	@RequestMapping(value="profile",method=RequestMethod.GET)
	public ModelAndView getUser(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session = request.getSession();
		//User user = (User)session.getAttribute("user"); //String verifyOTP=(String)session.getAttribute("verifyOTP");
		//session.setAttribute("user", user);
		//session.setAttribute("verifyOTP", verifyOTP);
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value="/confirmOTP",method=RequestMethod.POST)
	public ModelAndView registerUser(HttpServletResponse response,HttpServletRequest request,HttpSession session){
		Map<String,Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String newOTP = request.getParameter("newOTP");
		//String verifyOTP = request.getParameter("verifyOTP");
		String sessionOTP = (String)session.getAttribute("verifyOTP"); 
		User user = new User();
		if(newOTP.equals(sessionOTP))
		{
			user = (User)session.getAttribute("user");
				 userService.registerUser(user);
			map.put("user",user);
			return new ModelAndView("profile",map);
		}
		map.put("invalidEmail", "Invalid email");
		return new ModelAndView("index",map);
	}
	
	@RequestMapping(value="loginPage")
	public ModelAndView showLoginPage(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		return new ModelAndView("loginPage");
	}
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String email = request.getParameter("username");
		String passwd = request.getParameter("password");
		User user = new User();
		user=userService.login(email, passwd);
		if(user!=null)
		{	
			session.setAttribute("user",user);
			map.put("user", user);
			return new ModelAndView("profile",map);
		}
		else
		{
			map.put("invalidEmail", "Sorry boss,Invalid Username or Password...");
			return new ModelAndView("index",map);	
		}
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpSession session,HttpServletRequest request){
		session = request.getSession();
		session.invalidate();
		return new ModelAndView("pratik");
	}
	
	@RequestMapping(value="/updateProfile",method=RequestMethod.POST)
	public ModelAndView updateProfile(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap<String, Object>();
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		String name = request.getParameter("name");
		String[] newName = name.split(" ");
		user.setFirstname(newName[0]);
		user.setLastname(newName[1]);
		user.setPhoneNo(request.getParameter("phoneNo"));
		userService.registerUser(user);
		map.put("update", "Profile Updated.. Reload the Page..");
		return new ModelAndView("profile",map);
	}
	
	@RequestMapping(value="tripsByMe")
	public ModelAndView getAllTrips(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<Trip> trips = userService.getTripDetails(user.getUserID());
		if(trips!=null)
		{
			map.put("myTrips", trips); 				
			return new ModelAndView("myTripsList", map);
		}
		map.put("noTrips","No Trips Available...");
		return new ModelAndView("profile",map);
	}
	
	@RequestMapping(value="bookingsByMe")
	public ModelAndView getAllBookings(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<Booking> bookings = userService.getBookingDetails(user.getUserID());
		if(bookings!=null)
		{
			map.put("bookings", bookings); 		//pass passenger		
			return new ModelAndView("bookingList", map);
		}
		map.put("noBookings","No Bookings Available...");
		return new ModelAndView("profile",map);
	}
	
	
	
}
