package tests;

import java.util.*;

import DAO.PassengerdetailDAO;
import model.*;
public class TestPassenger {

	public static void main(String[] args) {
		User user= new User();
		user.setUserID("U1mithun17");
		
		Passengerdetail passenger= new Passengerdetail();
		passenger.setPassengerID("P1mithun17");
		passenger.setUser(user);
		passenger.setIDproof("AADHAR");
		passenger.setPan_aadhar_no("4536113");
		
		PassengerdetailDAO passsengerDAO= new PassengerdetailDAO();
		//passsengerDAO.registerPassenger(passenger);
		
		List<Passengerdetail> blist = passsengerDAO.getPassengerDetails();
		Iterator<Passengerdetail> i=blist.iterator();
		while(i.hasNext())
		{
		Passengerdetail p=new Passengerdetail();
		p=(Passengerdetail)i.next();
		System.out.println(p.getPassengerID());
		}

		System.out.println("Result::"+blist);
		
		blist=passsengerDAO.getPassengerDetail("U1mithun17");
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
