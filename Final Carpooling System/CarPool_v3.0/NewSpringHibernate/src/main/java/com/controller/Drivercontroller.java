package main.java.com.controller;

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

import main.java.com.model.Car;
import main.java.com.model.Driverdetail;
import main.java.com.model.User;
import main.java.com.service.CarService;
import main.java.com.service.CarServiceImpl;
import main.java.com.service.DriverDetailsService;
import main.java.com.service.DriverServiceImpl;
import main.java.com.service.UserService;
import javax.servlet.*;
@Controller
public class Drivercontroller {
	@Autowired
	private DriverDetailsService driverService=new DriverServiceImpl();
	private CarService carService = new CarServiceImpl();
	@RequestMapping(value="/addDDetails", method = RequestMethod.POST)
	public ModelAndView registerDriverDetails(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap();
				Driverdetail driver = new Driverdetail();
				User user = new User();
				session=request.getSession();
				user = (User) session.getAttribute("user");
				driver.setUser(user);
				int number = driverService.getDriverDetails().size();
				number++;
				String id = String.valueOf(number);
				driver.setDriverID("D"+id+user.getUserID());
				driver.setLicenceNO(request.getParameter("licenseNumber"));
				driver.setLic_issueDate(new Date(request.getParameter("licenseIssue")));
				driver.setLic_expiryDate(new Date(request.getParameter("licenseExpiry")));
				driverService.registerDriver(driver);
				session.setAttribute("driver", driver);
				map.put("driver", driver);
				return new ModelAndView("showCars");
	}
	
	
	
	
	@RequestMapping(value="checkDDetail",method=RequestMethod.POST)
	public ModelAndView checkDDetail(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		session = request.getSession();
		Map<String,Object> map = new HashMap<String, Object>();
		User user = new User();
		user = (User)session.getAttribute("user");
		System.out.println("user="+user.getUserID());
		String userID = user.getUserID();
		System.out.println("UserID ********** : "+userID);
		Driverdetail driver = new Driverdetail();
		driver = (Driverdetail)driverService.getDriverDetails(userID);
		if(driver!=null)
		{
			session.setAttribute("driver", driver);
			map.put("driver",driver);
			return new ModelAndView("showCars",map);
		}
		map.put("user", user);
		return new ModelAndView("ddetails");
	}
	
	
	@RequestMapping( value ="abc")
	public String getMyModal()
	{

	  return "myPageThatOpensAModalWindow";
	}
	
	
}
