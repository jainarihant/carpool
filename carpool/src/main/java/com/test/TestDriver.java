package tests;

import java.util.*;

import DAO.DriverdetailDAO;
import model.*;
public class TestDriver {

	public static void main(String[] args) {
		User user= new User();
		user.setUserID("U3sowmya");
		
        Driverdetail driver= new Driverdetail();
		driver.setDriverID("D3U3sowmya");
		driver.setUser(user);
		Date lic_issueDate = new Date();
		Date lic_expiryDate = new Date();
		driver.setLic_issueDate(lic_issueDate);
		driver.setLic_expiryDate(lic_expiryDate);
		
		DriverdetailDAO driverDAO= new DriverdetailDAO();
		//passsengerDAO.registerPassenger(passenger);
		
		List<Driverdetail> blist = driverDAO.getDriverDetails();
		Iterator<Driverdetail> i=blist.iterator();
		while(i.hasNext())
		{
		Driverdetail p=new Driverdetail();
		p=(Driverdetail)i.next();
		System.out.println(p.getDriverID());
		}

		System.out.println("Result::"+blist);
		
		
	
	}
	
	
}