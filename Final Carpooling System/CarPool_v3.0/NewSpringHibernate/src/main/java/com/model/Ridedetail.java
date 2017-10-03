package main.java.com.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ridedetails database table.
 * 
 */
@Entity
@Table(name="ridedetails")
@NamedQuery(name="Ridedetail.findAll", query="SELECT r FROM Ridedetail r")
public class Ridedetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String rideID;

	private String checkInTime;

	private float distTravelled;

	private String dropDest;

	private String pickUpSrc;

	//bi-directional many-to-one association to Booking
	@ManyToOne
	@JoinColumn(name="BookingId")
	private Booking booking;

	public Ridedetail() {
	}

	public String getRideID() {
		return this.rideID;
	}

	public void setRideID(String rideID) {
		this.rideID = rideID;
	}

	public String getCheckInTime() {
		return this.checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public float getDistTravelled() {
		return this.distTravelled;
	}

	public void setDistTravelled(float distTravelled) {
		this.distTravelled = distTravelled;
	}

	public String getDropDest() {
		return this.dropDest;
	}

	public void setDropDest(String dropDest) {
		this.dropDest = dropDest;
	}

	public String getPickUpSrc() {
		return this.pickUpSrc;
	}

	public void setPickUpSrc(String pickUpSrc) {
		this.pickUpSrc = pickUpSrc;
	}

	public Booking getBooking() {
		return this.booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

}