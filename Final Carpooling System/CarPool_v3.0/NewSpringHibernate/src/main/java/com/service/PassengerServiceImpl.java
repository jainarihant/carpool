package main.java.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.dao.PassengerDetailDAO;
import main.java.com.dao.PassengerdetailDAOImpl;
import main.java.com.model.Passengerdetail;
@Service("passengerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerDetailDAO passengerInter= new PassengerdetailDAOImpl();
	
	@Override
	public void registerPassenger(Passengerdetail passenger) {
		passengerInter.registerDriver(passenger);

	}

	@Override
	public Passengerdetail getPassengerDetail(String userID) {
		Passengerdetail passenger = (Passengerdetail)passengerInter.getPassengerDetail(userID);
		if(passenger!=null)
			return passenger;
		return null;
	}

	@Override
	public List<Passengerdetail> getPassengerDetails() {
		
		return passengerInter.getPassengerDetails();
	}

}
