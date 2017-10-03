package main.java.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.model.Car;
import main.java.com.model.Driverdetail;
import main.java.com.service.CarService;
import main.java.com.service.CarServiceImpl;

@Controller
public class Carcontroller {
	@Autowired
	private CarService carService = new CarServiceImpl();
	@RequestMapping(value="/registerCar",method=RequestMethod.POST)
	public ModelAndView addCar(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		session = request.getSession();
		Driverdetail driver = (Driverdetail) session.getAttribute("driver");
		Car car = new Car();
		car.setDriverdetail(driver);
		List<Car> carList= carService.getAllCarDetails();
		int number = carList.size();
		number++;
		String carID = "C"+String.valueOf(number)+driver.getDriverID();
		car.setCarID(carID);
		String acNonac = request.getParameter("AC/nonAc");
		byte acType;
		if(acNonac.equals("1"))
		{
			acType=1;
		}
		else{
			acType=0;
		}
		car.setAC_Non_AC(acType);
		car.setColor(request.getParameter("carColor"));
		car.setType(request.getParameter("carType"));
		car.setPlateNO(request.getParameter("plateNo"));
		carService.registerCar(car);
		return new ModelAndView("showCars");	
	}
	
	@RequestMapping(value="/addCar")
	public ModelAndView showAddCar(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		session = request.getSession();
		Map<String,Object> map = new HashMap<String, Object>();
		Driverdetail driver=(Driverdetail)session.getAttribute("driver");
		map.put("driver", driver);
		return new ModelAndView("addCar");
	}
	
	@RequestMapping(value="showCars")
	public ModelAndView showCar(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		return new ModelAndView("showCars");
	}
	@RequestMapping(value="/checkCars")
	public ModelAndView checkCars(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		Map<String, Object> model = new HashMap<String, Object>();
		
		Driverdetail driver = (Driverdetail) session.getAttribute("driver");
		String driverID = driver.getDriverID();System.out.println("Cars for DriverID : "+driverID);
		List<Car> cars = carService.getAllCarDetails(driverID);
		if(cars!=null)
		{
			model.put("cars", cars);
			return new ModelAndView("showCars",model);
		}
		model.put("noCars", "No Cars available.. Plz Register one...");
		return new ModelAndView("showCars",model);
	}
	
}
