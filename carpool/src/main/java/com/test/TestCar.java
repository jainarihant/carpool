package tests;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import DAO.CarDAO;
import model.Car;
import model.Driverdetail;
import model.User;

public class TestCar {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		User user = new User();
		user.setUserID("U4Apoorva");
		user.setFirstname("Apoorva");
		user.setLastname("Shendarkar");
		user.setUsername("apoo4");
		user.setPassword("apoo4");
		user.setEmail("apoorvashendarkar@gmail.com");
		user.setPhoneNo("9969070121");
		
		Driverdetail driver = new Driverdetail();
		driver.setUser(user);
		System.out.println(driver.getUser().getUserID());
		driver.setDriverID("D4U4Akshay");
		driver.setLicenceNO("MH0112345");
		Date expirydate = new Date("27/03/2017"); 
		Date issuedate= new Date("27/03/2017");
		driver.setLic_expiryDate(expirydate);
		driver.setLic_issueDate(issuedate);
		
		
		Car car=new Car();
		car.setCarID("C4D4U4Akshata");
		car.setDriverdetail(driver);
		car.setAC_Non_AC((byte)0);
		car.setColor("orange");
		car.setPlateNO("7227");
		car.setType("prime");


		CarDAO cardao=new CarDAO();
		//cardao.registerCar(car);
		cardao.deleteCar("D1U1charmi");	
		
		
		
		List<Car> clist=cardao.getAllCarDetails();
		Iterator i = clist.iterator();
		while(i.hasNext()){
			Car c = new Car();
			c=(Car) i.next();
			System.out.println(c.getCarID());
		}
		//System.out.println("Result::"+clist);
		
		
		
		System.out.println("Car for particular driver");
		clist=cardao.getAllCarDetails("D4U4Akshay");
		i = clist.iterator();
		while(i.hasNext()){
			
			Car c = new Car();
			c=(Car) i.next();
			System.out.println(c.getCarID());
			
		}
		System.out.println("Result::"+clist);
		

	}}
