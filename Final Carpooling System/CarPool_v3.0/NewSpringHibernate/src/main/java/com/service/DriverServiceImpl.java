package main.java.com.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.dao.DriverDetailDAO;
import main.java.com.dao.DriverdetailDAOImpl;
import main.java.com.model.Driverdetail;

@Service("driverService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class DriverServiceImpl implements DriverDetailsService{
	@Autowired
	private DriverDetailDAO driverInter= new DriverdetailDAOImpl();
		
	
	@Override
	public void registerDriver(Driverdetail driver) {
		driverInter.registerDriver(driver);
	}

	@Override
	public List<Driverdetail> getDriverDetails() {
		// TODO Auto-generated method stub
		return driverInter.getDriverDetails();
	}

	@Override
	public Driverdetail getDriverDetails(String userID) {
		Driverdetail driver = (Driverdetail)driverInter.getDriverDetails(userID);
		if(driver!=null)
			return driver;
		return null;
	}

}
