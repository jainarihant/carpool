package service;

import java.util.*;

import com.model.Car;
import com.model.Driverdetail;
import com.model.User;
import com.service.CarDAOImpl;
public class TestCar {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		User user = new User();
		user.setUserID("U1charmi");
		user.setFirstname("Charmi");
		user.setLastname("Valecha");
		user.setUsername("charmi1");
		user.setPassword("charmi1");
		user.setEmail("charmi.valecha@gmail.com");
		user.setPhoneNo("8879075545");
		
		Driverdetail driver = new Driverdetail();
		driver.setUser(user);
		System.out.println(driver.getUser().getUserID());
		driver.setDriverID("D1U1charmi");
		driver.setLicenceNO("MH011234567");
		Date expirydate = new Date("14/03/2017"); 
		Date issuedate= new Date("03/03/2017");
		driver.setLic_expiryDate(expirydate);
		driver.setLic_issueDate(issuedate);
		
		
		Car car=new Car();
		car.setCarID("C1D1U1charmi");
		car.setDriverdetail(driver);
		car.setAC_Non_AC((byte)0);					//if AC then 1, if Non_AC then 0
		car.setColor("Red");
		car.setPlateNO("MH01AB0007");
		car.setType("Prime");
		
		CarDAOImpl cardao=new CarDAOImpl();
		//cardao.registerCar(car);					//working call registerCar function present in CarDAO class
		//cardao.deleteCar(car);	
		cardao.deleteCar("D1U1charmi");			// working delete car using driverID
		
		// getting list of all the Cars we have
		List<Car> clist=cardao.getAllCarDetails();		
		/*Iterator<Car> i = clist.iterator();			//working iterating through the list of cars
		while(i.hasNext()){
			
			Car c = new Car();
			c=(Car) i.next();
			System.out.println(c.getCarID());
			
		}*/
		System.out.println("List of all the Cars::"+clist);			// printing the list of all Cars
		System.out.println("*****************************************************************************");
		
		// getting the list of the Cars specific to Driver using DriverID
		clist=cardao.getAllCarDetails("D1U1charmi");
		Iterator<Car> i = clist.iterator();
		while(i.hasNext()){
			
			Car c = new Car();
			c=(Car) i.next();
			System.out.println(c.getCarID());
			
		}
		System.out.println("List of all the Cars specific to D1U1charmi::"+clist);
		System.out.println("******************************************************************************");
		
	}

}
