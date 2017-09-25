package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the car database table.
 * 
 */
@Entity
@NamedQuery(name="Car.findAll", query="SELECT c FROM Car c")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String carID;

	@Column(name="`AC/Non_AC`")
	private byte AC_Non_AC;

	private String color;

	private String plateNO;

	private String type;

	//bi-directional many-to-one association to Driverdetail
	@ManyToOne
	@JoinColumn(name="DriverID")
	private Driverdetail driverdetail;

	public Car() {
	}

	public String getCarID() {
		return this.carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public byte getAC_Non_AC() {
		return this.AC_Non_AC;
	}

	public void setAC_Non_AC(byte AC_Non_AC) {
		this.AC_Non_AC = AC_Non_AC;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlateNO() {
		return this.plateNO;
	}

	public void setPlateNO(String plateNO) {
		this.plateNO = plateNO;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Driverdetail getDriverdetail() {
		return this.driverdetail;
	}

	public void setDriverdetail(Driverdetail driverdetail) {
		this.driverdetail = driverdetail;
	}

	@Override
	public String toString() {
		return "Car [carID=" + carID + ", AC_Non_AC=" + AC_Non_AC + ", color=" + color + ", plateNO=" + plateNO
				+ ", type=" + type + ", driverdetail=" + driverdetail + "]";
	}
	

}