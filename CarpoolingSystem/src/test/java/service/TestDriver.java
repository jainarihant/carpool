package service;

import java.util.*;

import com.model.Driverdetail;
import com.model.User;
import com.service.DriverdetailDAOImpl;
public class TestDriver {

	public static void main(String[] args) {
		
		User user= new User();
		user.setUserID("U4sowmya");
		user.setFirstname("sowmya");
		user.setLastname("mithun");
		user.setUsername("sowmya1");
		user.setPassword("sowmya1");
		user.setEmail("sowmya.abc@atos.net");
		user.setPhoneNo("1234556789");
		
        Driverdetail driver= new Driverdetail();
		driver.setDriverID("D3U3sowmya");
		driver.setUser(user);
		driver.setLicenceNO("TM01SM1987");
		Date lic_issueDate = new Date();
		Date lic_expiryDate = new Date();
		driver.setLic_issueDate(lic_issueDate);
		driver.setLic_expiryDate(lic_expiryDate);
		
		
		DriverdetailDAOImpl driverDAO= new DriverdetailDAOImpl();
		//driverDAO.registerDriver(driver);					//working Register driver
		
		List<Driverdetail> blist = driverDAO.getDriverDetails();			// working
		Iterator<Driverdetail> i=blist.iterator();
		while(i.hasNext())
		{
		Driverdetail p=new Driverdetail();
		p=(Driverdetail)i.next();
		System.out.println(p.getDriverID());
		}

		//System.out.println("Result::"+blist);
		
		blist = driverDAO.getDriverDetails("U2jitesh");						//working
		 i=blist.iterator();
		while(i.hasNext())
		{
		Driverdetail p=new Driverdetail();
		p=(Driverdetail)i.next();
		System.out.println(p.getDriverID());
		System.out.println(p.getLicenceNO());
		System.out.println(p.getLic_issueDate());
		System.out.println(p.getLic_expiryDate());
		}

	}

}
