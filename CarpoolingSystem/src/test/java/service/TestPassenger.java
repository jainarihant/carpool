package service;

import java.util.*;

import com.model.Passengerdetail;
import com.model.User;
import com.service.PassengerDAOImpl;
public class TestPassenger {

	public static void main(String[] args) {
		User user= new User();
		user.setUserID("U3mithun17");
		user.setFirstname("mithun");
		user.setLastname("Vasanth");
		user.setUsername("mithun1");
		user.setPassword("mithun1");
		user.setEmail("mithun.vasanth@gmail.com");
		user.setPhoneNo("0987654321");
		
		Passengerdetail passenger= new Passengerdetail();
		passenger.setPassengerID("P2U3mithun17");
		passenger.setUser(user);
		passenger.setIDproof("AADHAR");
		passenger.setPan_aadhar_no("4536113");
		
		PassengerDAOImpl passsengerDAO= new PassengerDAOImpl();
		//passsengerDAO.registerPassenger(passenger);							//working
		
		List<Passengerdetail> blist = passsengerDAO.getPassengerDetails();		//working
		Iterator<Passengerdetail> i=blist.iterator();
		while(i.hasNext())
		{
		Passengerdetail p=new Passengerdetail();
		p=(Passengerdetail)i.next();
		System.out.println(p.getPassengerID());
		System.out.println(p.getIDproof());
		System.out.println(p.getPan_aadhar_no());
		}
		System.out.println("**************************************************************");
		//System.out.println("Result::"+blist);
		
		 blist = passsengerDAO.getPassengerDetail("U2jitesh");						//working
		 i=blist.iterator();
		while(i.hasNext())
		{
		Passengerdetail p=new Passengerdetail();
		p=(Passengerdetail)i.next();
		System.out.println(p.getPassengerID());
		System.out.println(p.getIDproof());
		System.out.println(p.getPan_aadhar_no());
		}

	}

}
