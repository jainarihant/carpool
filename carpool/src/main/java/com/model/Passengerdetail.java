package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the passengerdetails database table.
 * 
 */
@Entity
@Table(name="passengerdetails")
@NamedQuery(name="Passengerdetail.findAll", query="SELECT p FROM Passengerdetail p")
public class Passengerdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String passengerID;

	private String IDproof;

	@Column(name="`PAN/AADHAR NO`")
	private String pan_aadhar_no;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="passengerdetail")
	private List<Booking> bookings;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	public Passengerdetail() {
	}

	public String getPassengerID() {
		return this.passengerID;
	}

	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}

	public String getIDproof() {
		return this.IDproof;
	}

	public void setIDproof(String IDproof) {
		this.IDproof = IDproof;
	}

	public String getPan_aadhar_no() {
		return this.pan_aadhar_no;
	}

	public void setPan_aadhar_no(String pan_aadhar_no) {
		this.pan_aadhar_no = pan_aadhar_no;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setPassengerdetail(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setPassengerdetail(null);

		return booking;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}