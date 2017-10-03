package main.java.com.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userID;

	private String email;

	private String firstname;

	private String lastname;

	private String middlename;

	private String password;

	private String phoneNo;

	private String username;

	//bi-directional many-to-one association to Driverdetail
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Driverdetail> driverdetails;

	//bi-directional many-to-one association to Passengerdetail
	@OneToMany(mappedBy="user")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Passengerdetail> passengerdetails;

	public User() {
	}
	
	@PrePersist
	private void ensureId(){
	    this.setUserID(UUID.randomUUID().toString());
	}
	
	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Driverdetail> getDriverdetails() {
		return this.driverdetails;
	}

	public void setDriverdetails(List<Driverdetail> driverdetails) {
		this.driverdetails = driverdetails;
	}

	public Driverdetail addDriverdetail(Driverdetail driverdetail) {
		getDriverdetails().add(driverdetail);
		driverdetail.setUser(this);

		return driverdetail;
	}

	public Driverdetail removeDriverdetail(Driverdetail driverdetail) {
		getDriverdetails().remove(driverdetail);
		driverdetail.setUser(null);

		return driverdetail;
	}

	public List<Passengerdetail> getPassengerdetails() {
		return this.passengerdetails;
	}

	public void setPassengerdetails(List<Passengerdetail> passengerdetails) {
		this.passengerdetails = passengerdetails;
	}

	public Passengerdetail addPassengerdetail(Passengerdetail passengerdetail) {
		getPassengerdetails().add(passengerdetail);
		passengerdetail.setUser(this);

		return passengerdetail;
	}

	public Passengerdetail removePassengerdetail(Passengerdetail passengerdetail) {
		getPassengerdetails().remove(passengerdetail);
		passengerdetail.setUser(null);

		return passengerdetail;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", middlename=" + middlename + ", password=" + password + ", phoneNo=" + phoneNo + ", username="
				+ username + ", driverdetails=" + driverdetails + ", passengerdetails=" + passengerdetails + "]";
	}
	

}