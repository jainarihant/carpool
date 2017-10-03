package main.java.com.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.model.Trip;



@Repository("tripInter")
@Transactional
public class TripDAO implements TripInterface{

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void createTrip(Trip trip) {
		try{
		sessionfactory.getCurrentSession().saveOrUpdate(trip);
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean updateTripDetail(String tripID, Trip trip) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelTrip(String tripID) {
		Query query=sessionfactory.getCurrentSession().createQuery("FROM Trip where tripID='"+tripID+"'");
		if(query.list().size()!=0)
		{
			Trip trip=(Trip) query.list();
			sessionfactory.getCurrentSession().delete(trip);
			return true;
		}
		else
		{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trip> serachTripByDestination(String destination,String type) {
		if(type.equalsIgnoreCase("regular"))
			return sessionfactory.getCurrentSession().createQuery("FROM Trip where tripID not like 'F%' and destPoint='"+destination+"' and spotsAvailable>0").list();
		else
			return sessionfactory.getCurrentSession().createQuery("FROM Trip where tripID like 'F%' and destPoint='"+destination+"' and spotsAvailable>0").list();
		
	}

	//not used 
	@SuppressWarnings("unchecked")
	public List<Trip> serachTripBySource(String source,Date date) {
		
		return sessionfactory.getCurrentSession().createCriteria(Trip.class).
				add(Restrictions.eq("dateTime", date)).
				add( Restrictions.eq("startPoint",source)).list();
		
	}

	@SuppressWarnings("unchecked")
	public List<Trip> serachTripBySource(String source,String type) {
		if(type.equalsIgnoreCase("regular"))
			return sessionfactory.getCurrentSession().createQuery("FROM Trip where tripID not like 'F%' and startPoint='"+source+"' and spotsAvailable>0").list();
		else
			return sessionfactory.getCurrentSession().createQuery("FROM Trip where tripID like 'F%' and startPoint='"+source+"' and spotsAvailable>0").list();
		
		
		
		//return sessionfactory.getCurrentSession().createCriteria(Trip.class).add( Restrictions.eq("startPoint",source)).list();
		
	}
	
	@Override
	public List<Trip> serachTripByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> serachTripByDateTime(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int seatsAvailable(int noOfSeats, String tripID) {
				
		Query query=sessionfactory.getCurrentSession().createQuery("from Trip where TripID='"+tripID+"'");
		Iterator<Trip> it = query.iterate();
		int availableSeats = 0;
		while(it.hasNext()){
			Trip p = it.next();
			if(p.getSpotsAvailable()>0 && noOfSeats <= p.getSpotsAvailable())
			{	availableSeats = p.getSpotsAvailable()-noOfSeats;
				p.setSpotsAvailable(availableSeats);
			}
			sessionfactory.getCurrentSession().saveOrUpdate(p);
		}
		return availableSeats;
					
	}

	@SuppressWarnings("unchecked")
	@Override
	public Trip getTripById(String selectedTripId) {
		List<Trip> t=sessionfactory.getCurrentSession().createCriteria(Trip.class).add( Restrictions.eq("tripID",selectedTripId)).list();		
		return t.get(0);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trip> getTripsCreatedByMe(String driverId) {
		/*Calendar calendar = Calendar.getInstance();
		java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		System.out.println("date"+ourJavaDateObject);*/
		return sessionfactory.getCurrentSession().createQuery("FROM Trip where driverID='"+driverId+"'" ).list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trip> getAllTrips() {
		List<Trip> trips;
		try{
			trips=sessionfactory.getCurrentSession().createQuery("FROM Trip").list();
			if(trips!=null)
				return trips;
			else
				return null;
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
}
