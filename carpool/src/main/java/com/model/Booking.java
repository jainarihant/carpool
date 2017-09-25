package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bookings database table.
 * 
 */
@Entity
@Table(name="bookings")
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String bookingID;

	private String bookingStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date departDateTime;

	private float ratingForDriver;

	private float ratingForPassenger;

	private int spotsReserved;

	//bi-directional many-to-one association to Passengerdetail
	@ManyToOne
	@JoinColumn(name="PassengerID")
	private Passengerdetail passengerdetail;

	//bi-directional many-to-one association to Trip
	@ManyToOne
	@JoinColumn(name="TripID")
	private Trip trip;

	//bi-directional many-to-one association to Ridedetail
	@OneToMany(mappedBy="booking")
	private List<Ridedetail> ridedetails;

	public Booking() {
	}

	public String getBookingID() {
		return this.bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public String getBookingStatus() {
		return this.bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Date getDepartDateTime() {
		return this.departDateTime;
	}

	public void setDepartDateTime(Date departDateTime) {
		this.departDateTime = departDateTime;
	}

	public float getRatingForDriver() {
		return this.ratingForDriver;
	}

	public void setRatingForDriver(float ratingForDriver) {
		this.ratingForDriver = ratingForDriver;
	}

	public float getRatingForPassenger() {
		return this.ratingForPassenger;
	}

	public void setRatingForPassenger(float ratingForPassenger) {
		this.ratingForPassenger = ratingForPassenger;
	}

	public int getSpotsReserved() {
		return this.spotsReserved;
	}

	public void setSpotsReserved(int spotsReserved) {
		this.spotsReserved = spotsReserved;
	}

	public Passengerdetail getPassengerdetail() {
		return this.passengerdetail;
	}

	public void setPassengerdetail(Passengerdetail passengerdetail) {
		this.passengerdetail = passengerdetail;
	}

	public Trip getTrip() {
		return this.trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public List<Ridedetail> getRidedetails() {
		return this.ridedetails;
	}

	public void setRidedetails(List<Ridedetail> ridedetails) {
		this.ridedetails = ridedetails;
	}

	public Ridedetail addRidedetail(Ridedetail ridedetail) {
		getRidedetails().add(ridedetail);
		ridedetail.setBooking(this);

		return ridedetail;
	}

	public Ridedetail removeRidedetail(Ridedetail ridedetail) {
		getRidedetails().remove(ridedetail);
		ridedetail.setBooking(null);

		return ridedetail;
	}

}