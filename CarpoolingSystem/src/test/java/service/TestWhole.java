package service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.model.Booking;
import com.model.Car;
import com.model.Driverdetail;
import com.model.Passengerdetail;
import com.model.Ridedetail;
import com.model.Trip;
import com.model.User;
import com.service.BookingDAOImpl;
import com.service.CarDAOImpl;
import com.service.DriverdetailDAOImpl;
import com.service.PassengerDAOImpl;
import com.service.RideDetailsDAOImpl;
import com.service.TripDAOImpl;
import com.service.UserDAOImpl;


public class TestWhole {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//int cnt=11;
		Scanner sc = new Scanner(System.in);
		
		User user = new User();
		System.out.println("Enter userID starting with U upto 5 chars only :");
		user.setUserID(sc.next());
		System.out.println("Enter firstname :");
		user.setFirstname(sc.next());
		System.out.println("Enter lastname :");
		user.setLastname(sc.next());
		System.out.println("Enter Username :");
		user.setUsername(sc.next());
		System.out.println("Enter password :");
		user.setPassword(sc.next());
		System.out.println("Enter mailID :");
		user.setEmail(sc.next());
		System.out.println("Enter phoneno :");
		user.setPhoneNo(sc.next());
		
		UserDAOImpl userdao = new UserDAOImpl();
		//userdao.registerUser(user);										//register User
		System.out.println("User registered...");
		
		List<User> blist = userdao.getAllUsers();		//working				All the Users
		Iterator<User> i=blist.iterator();
		while(i.hasNext())
		{
		User u=new User();
		u=(User)i.next();
		System.out.println(u.getUserID());
		System.out.println(u.getFirstname());
		System.out.println(u.getLastname());
		}
		System.out.println("**************************************************************");
		
		List<Booking> blist1 = userdao.getBookingDetails("U52");		//working		All the bookings for particular User
		Iterator<Booking> i1=blist1.iterator();
		while(i1.hasNext())
		{
			Booking u=new Booking();
		u=(Booking)i1.next();
		System.out.println(u.getBookingID());
		System.out.println(u.getBookingStatus());
		System.out.println(u.getSpotsReserved());
		}
		System.out.println("**************************************************************");
		
		List<Trip> blist2 = userdao.getTripDetails("U6arihant");		//working		All the posted trips for particular Driver
		Iterator<Trip> i3=blist2.iterator();
		while(i3.hasNext())
		{
			Trip u=new Trip();
		u=(Trip)i3.next();
		System.out.println(u.getTripID());
		System.out.println(u.getCarID());
		System.out.println(u.getSpotsAvailable());
		}
		System.out.println("**************************************************************");
		
		
		System.out.println("Enter UserID which u want to update : ");
		User user1 = new User();
		String userID = sc.next();
		user1.setUserID(userID);
		System.out.println("Enter new firstname : ");
		user1.setFirstname(sc.next());
		System.out.println("Enter new middlename : ");
		user1.setMiddlename(sc.next());
		System.out.println("Enter new lastname : ");
		user1.setLastname(sc.next());
		System.out.println("Enter new unique username : ");
		user1.setUsername(sc.next());
		System.out.println("Enter new password : ");
		user1.setPassword(sc.next());
		System.out.println("Enter new unique email : ");
		user1.setEmail(sc.next());
		System.out.println("Enter new unique phoneno : ");
		user1.setPhoneNo(sc.next());
		
//		System.out.println(userdao.updateProfile(user1, userID));								//updating the user profile
		
		user.setUserID("U3mithun17");
		user.setFirstname("Mithun");
		user.setLastname("Vasanth");
		user.setUsername("mithun1");
		user.setPassword("mithin1");
		user.setEmail("mithun.vasanth@gamil.com");
		user.setPhoneNo("0987654321");
		//System.out.println("Enter new password : ");
		//System.out.println(userdao.changePasswd(user,sc.next()));
		
		
		
		Driverdetail driver= new Driverdetail();
		System.out.println("Enter driverID starting with D and followed by UserID:");
		driver.setDriverID(sc.next());
		driver.setUser(user);
		System.out.println("Enter licence No : ");
		driver.setLicenceNO(sc.next());
		
		System.out.println("Enter Licence_Expiary date :");			// in (dd/mm/yy or dd/mm/yyyy)format
		Date lic_issueDate = new Date(sc.next());
		driver.setLic_issueDate(lic_issueDate);
		
		System.out.println("Enter Licence_Issue date : ");
		Date lic_expiryDate = new Date(sc.next());
		driver.setLic_expiryDate(lic_expiryDate);
		
		
		DriverdetailDAOImpl driverDAO= new DriverdetailDAOImpl();
		//driverDAO.registerDriver(driver); 								// register as Driver
		System.out.println("Registred as a Driver...");
		
		Car car=new Car();
		System.out.println("Enter car ID starting with C followed by driverID : ");
		car.setCarID(sc.next());		
		car.setDriverdetail(driver);
		System.out.println("Enter 1(AC) or 0(Non_AC): ");
		car.setAC_Non_AC((byte)sc.nextInt());					//if AC then 1, if Non_AC then 0
		System.out.println("Enter color of car : ");
		car.setColor(sc.next());
		System.out.println("Enter car plate no : ");
		car.setPlateNO(sc.next());
		System.out.println("Enter car type (Mini,Sedan,Prime):");
		car.setType(sc.next());
		
		CarDAOImpl cardao=new CarDAOImpl();
		//cardao.registerCar(car);										//register Car
		//System.out.println("Car registered...");
		
		//cardao.deleteCar("D1U1charmi");								// working delete car using driverID
		
				// getting list of all the Cars we have
				List<Car> clist=cardao.getAllCarDetails();		
				Iterator<Car> i4 = clist.iterator();					//iterating through the list of cars
				while(i4.hasNext()){
					
					Car c = new Car();
					c=(Car) i4.next();
					System.out.println(c.getCarID());
					
				}
				//System.out.println("List of all the Cars::"+clist);			// printing the list of all Cars
				System.out.println("*****************************************************************************");
				
				// getting the list of the Cars specific to Driver using DriverID
				System.out.println("Enter DriverID for which u want Cars : ");
				String driverID = sc.next();
				clist=cardao.getAllCarDetails(driverID);
				Iterator<Car> i5 = clist.iterator();
				while(i5.hasNext()){
					
					Car c = new Car();
					c=(Car) i5.next();
					System.out.println(c.getCarID());
					
				}
				//System.out.println("List of all the Cars specific to "+driverID+"::"+clist);
				System.out.println("******************************************************************************");
		
		
		Passengerdetail passenger= new Passengerdetail();
		System.out.println("Enter passengerID start with P followed by userID : ");
		passenger.setPassengerID(sc.next());
		passenger.setUser(user);
		System.out.println("Enter IDproof type (AADHAR or PAN) : ");
		passenger.setIDproof(sc.next());
		System.out.println("Enter IDproof no : ");
		passenger.setPan_aadhar_no(sc.next());
		
		PassengerDAOImpl passengerDAO= new PassengerDAOImpl();
//		passengerDAO.registerPassenger(passenger);						//register as Passenger
																			
																			//List of all Users
			
		System.out.println("******************************************************");
		
		
		List<Driverdetail> dlist = driverDAO.getDriverDetails();			// List of all drivers
		Iterator<Driverdetail> i6=dlist.iterator();
		while(i6.hasNext())
		{
		Driverdetail p=new Driverdetail();
		p=(Driverdetail)i6.next();
		System.out.println(p.getDriverID());
		}
		System.out.println("*******************************************************");
		
		
		List<Passengerdetail> plist = passengerDAO.getPassengerDetails();		//List of all Passengers
		Iterator<Passengerdetail> i7=plist.iterator();
		while(i7.hasNext())
		{
		Passengerdetail p=new Passengerdetail();
		p=(Passengerdetail)i7.next();
		System.out.println(p.getPassengerID());
		System.out.println(p.getIDproof());
		System.out.println(p.getPan_aadhar_no());
		}
		System.out.println("**************************************************************");
		
		
		System.out.println("Enter trip date :");
		Date date1 = new Date(sc.next());
		System.out.println("Enter trip end date:");
		Date date2 = new Date(sc.next());
		Trip trip = new Trip();
		System.out.println("Enter start point : ");
		trip.setStartPoint(sc.next());
		System.out.println("Enter end point : ");
		trip.setDestPoint(sc.next());
		System.out.println("Enter meeting points seperated by commas :");
		trip.setMeetingPoints(sc.next());
		
		trip.setDateTime(date1);
		trip.setEndDate(date2);
		System.out.println("Enter frequency (Onetime/Daily/Monthly) : ");
		trip.setFrequency(sc.next());
		System.out.println("Enter spots available : ");
		trip.setSpotsAvailable(sc.nextInt());
		//trip.setEndDate(null);
		trip.setTripID("FT3"+driver.getDriverID());
		trip.setDriverdetail(driver);
		
		TripDAOImpl tripdao = new TripDAOImpl();
		//tripdao.createTrip(trip, "C4D4U6arihant");
		
		//tripdao.createTrip(trip, "C4D4U6arihant","Daily");
		
		//tripdao.updateTripDetail("T2"+driver.getDriverID(), trip);
		
		//System.out.println("Seats available : "+ tripdao.seatsAvailable(1, "T2"+driver.getDriverID()));
		
		List<Trip> tlist = tripdao.serachTripByType("frequent");		//search trips by Type (regular/frequent)
		Iterator<Trip> i8=tlist.iterator();
		while(i8.hasNext())
		{
			Trip p=new Trip();
		p=(Trip)i8.next();
		System.out.println(p.getTripID());
		System.out.println(p.getStartPoint());
		System.out.println(p.getDestPoint());
		}
		System.out.println("**************************************************************");
		
		List<Trip> stlist = tripdao.serachTripBySource("chennaiji");		// search trip by source
		Iterator<Trip> i9=stlist.iterator();
		while(i9.hasNext())
		{
			Trip p=new Trip();
		p=(Trip)i9.next();
		System.out.println(p.getTripID());
		System.out.println(p.getStartPoint());
		System.out.println(p.getDestPoint());
		}
		System.out.println("**************************************************************");
		
		
		List<Trip> dtlist = tripdao.serachTripByDestination("banagaloreji");		//search trip by destination
		Iterator<Trip> i10=dtlist.iterator();
		while(i10.hasNext())
		{
			Trip p=new Trip();
		p=(Trip)i10.next();
		System.out.println(p.getTripID());
		System.out.println(p.getStartPoint());
		System.out.println(p.getDestPoint());
		}
		System.out.println("**************************************************************");
		
		//System.out.println(tripdao.cancelTrip("T1D4U6arihant"));
		
		
		Booking booking=new Booking();
		booking.setBookingID("");
		booking.setBookingStatus("Pending");
		Date date = new Date("30/09/2017");
		booking.setDepartDateTime(date);
		booking.setSpotsReserved(3);
		booking.setPassengerdetail(passenger);
		//booking.setTrip(t);
		
		BookingDAOImpl bdao=new BookingDAOImpl();
//		bdao.bookSeat(booking, passenger);										// Book seat/s
		
		List<Booking> blist3=bdao.getAllBookings();								//display all the bookings
		Iterator<Booking> h = blist3.iterator();
		while(h.hasNext()){
			
			Booking b = new Booking();
			b=(Booking) h.next();
			System.out.println(b.getBookingID());
		}
		//System.out.println("List of the bookings::"+blist);
		System.out.println("**************************************************************************");
		
		List<Booking> blist4=bdao.getAllBookings("");				//display all bookings for particular Trip
		Iterator<Booking> h1 = blist4.iterator();
		while(h1.hasNext()){
			
			Booking b1 = new Booking();
			b1=(Booking) h1.next();
			System.out.println(b1.getBookingID());
		}
		//System.out.println("Result 2::"+blist1);
		System.out.println("**************************************************************************");
		
		
		//bdao.updateBookingDetails(booking);
		
		
//		if(bdao.cancelBooking(""))					//working				Delete booking using Booking ID
//			System.out.println("Booking canceled.");
			
		//working			Passenger will give Rating to driver
//		if(bdao.updateDriverRating("", "", ""))				
//			System.out.println("Driver Rating updated");
		
		//working			Driver will give Rating to Passenger
//		if(bdao.updatePassengerRating("", "", ""))
//			System.out.println("Passenger Rating updated");
		
		//working		Approve passenger	
//		if(bdao.approveBooking("",""))
//			System.out.println("Approved");
		
		//working		Deny passenger
//		if(bdao.denyBooking("",""))
//			System.out.println("Denied");
		
		
		Ridedetail ride=new Ridedetail();
		ride.setRideID("R1"+trip.getTripID());
		ride.setCheckInTime("12:00");
		ride.setDistTravelled(10);
		ride.setPickUpSrc("street 22");
		ride.setDropDest("street 30");
		ride.setBooking(booking);
		
		
		RideDetailsDAOImpl rideDAO= new RideDetailsDAOImpl();
		//rideDAO.generateRideDetails(ride);							//working
		
		
		List<Ridedetail> rlist=rideDAO.getAllRideDetails();
		Iterator<Ridedetail> h3 = rlist.iterator();
		Ridedetail r = new Ridedetail();
		while(h3.hasNext()){
			r=(Ridedetail) h3.next();
			System.out.println(r.getRideID());
		
		}
		//System.out.println("Result::"+rlist);
		System.out.println("***************************************************************************");
		
		rlist=rideDAO.getAllRideDetails("B1P1U2jitesh");
		Iterator<Ridedetail> h4 = rlist.iterator();
		Ridedetail rd = new Ridedetail();
		//h4 = rlist.iterator();
		while(h4.hasNext()){	
			rd=(Ridedetail) h4.next();
			System.out.println(rd.getDistTravelled());
			
		}
		//System.out.println("Result::"+rlist);
		sc.close();
	}

}
