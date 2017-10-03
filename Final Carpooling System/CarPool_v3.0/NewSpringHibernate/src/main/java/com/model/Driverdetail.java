package main.java.com.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the driverdetails database table.
 * 
 */
@Entity
@Table(name="driverdetails")
@NamedQuery(name="Driverdetail.findAll", query="SELECT d FROM Driverdetail d")
public class Driverdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String driverID;

	@Temporal(TemporalType.DATE)
	private Date lic_expiryDate;

	@Temporal(TemporalType.DATE)
	private Date lic_issueDate;

	private String licenceNO;

	//bi-directional many-to-one association to Car
	@OneToMany(mappedBy="driverdetail")
	private List<Car> cars;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	//bi-directional many-to-one association to Trip
	@OneToMany(mappedBy="driverdetail")
	private List<Trip> trips;

	public Driverdetail() {
	}

	public String getDriverID() {
		return this.driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	public Date getLic_expiryDate() {
		return this.lic_expiryDate;
	}

	public void setLic_expiryDate(Date lic_expiryDate) {
		this.lic_expiryDate = lic_expiryDate;
	}

	public Date getLic_issueDate() {
		return this.lic_issueDate;
	}

	public void setLic_issueDate(Date lic_issueDate) {
		this.lic_issueDate = lic_issueDate;
	}

	public String getLicenceNO() {
		return this.licenceNO;
	}

	public void setLicenceNO(String licenceNO) {
		this.licenceNO = licenceNO;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Car addCar(Car car) {
		getCars().add(car);
		car.setDriverdetail(this);

		return car;
	}

	public Car removeCar(Car car) {
		getCars().remove(car);
		car.setDriverdetail(null);

		return car;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Trip> getTrips() {
		return this.trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public Trip addTrip(Trip trip) {
		getTrips().add(trip);
		trip.setDriverdetail(this);

		return trip;
	}

	public Trip removeTrip(Trip trip) {
		getTrips().remove(trip);
		trip.setDriverdetail(null);

		return trip;
	}

}