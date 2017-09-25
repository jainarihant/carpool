package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trip database table.
 * 
 */
@Entity
@NamedQuery(name="Trip.findAll", query="SELECT t FROM Trip t")
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tripID;

	private String carID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	private String destPoint;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private String frequency;

	private String meetingPoints;

	private String preferences;

	private int spotsAvailable;

	private String startPoint;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="trip")
	private List<Booking> bookings;

	//bi-directional many-to-one association to Driverdetail
	@ManyToOne
	@JoinColumn(name="DriverID")
	private Driverdetail driverdetail;

	public Trip() {
	}

	public String getTripID() {
		return this.tripID;
	}

	public void setTripID(String tripID) {
		this.tripID = tripID;
	}

	public String getCarID() {
		return this.carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getDestPoint() {
		return this.destPoint;
	}

	public void setDestPoint(String destPoint) {
		this.destPoint = destPoint;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFrequency() {
		return this.frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getMeetingPoints() {
		return this.meetingPoints;
	}

	public void setMeetingPoints(String meetingPoints) {
		this.meetingPoints = meetingPoints;
	}

	public String getPreferences() {
		return this.preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public int getSpotsAvailable() {
		return this.spotsAvailable;
	}

	public void setSpotsAvailable(int spotsAvailable) {
		this.spotsAvailable = spotsAvailable;
	}

	public String getStartPoint() {
		return this.startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setTrip(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setTrip(null);

		return booking;
	}

	public Driverdetail getDriverdetail() {
		return this.driverdetail;
	}

	public void setDriverdetail(Driverdetail driverdetail) {
		this.driverdetail = driverdetail;
	}

}