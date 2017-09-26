package main.java.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import main.java.com.dao.*;
import main.java.com.model.*;

@Controller
public class LoginController {
		@Autowired
		UserDAO userService;
		@RequestMapping(value="/loginuser",method=RequestMethod.GET)
		public ModelAndView showLogin(HttpServletRequest request,HttpServletResponse response){
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("login",new User());
			return mav;
		}
		
		@RequestMapping(value= "/loginProcess", method = RequestMethod.POST)
		public ModelAndView loginProvcess(HttpServletRequest request,HttpServletResponse response, @ModelAttribute("user")User user){
			ModelAndView mav = null;
			boolean login = userService.login(user.getUsername(), user.getPassword());
			if(!login)
			{
				mav = new ModelAndView("login");
				mav.addObject("firstname", user.getFirstname());
			}
			else{
				mav = new ModelAndView("login");
				mav.addObject("You entered wrong Username or Password");
			}
			return mav;
		}
}
