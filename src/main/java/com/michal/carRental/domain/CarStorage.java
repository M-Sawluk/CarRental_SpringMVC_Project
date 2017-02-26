package com.michal.carRental.domain;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;




@Entity
public class CarStorage implements Serializable {

	private static final long serialVersionUID = -1881552477424451360L;

	@Id
	@GeneratedValue
	private long id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_ID")
    @JsonManagedReference
	private Car car;
	
	@ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "RENTINGPLACE_ID")
	@JsonBackReference
    private RentingPlace rentingPlace;
    
    private int units;
    
    @javax.persistence.Transient
    private String placeName;
	
    public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
   
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public RentingPlace getRentingPlace() {
		return rentingPlace;
	}

	public void setRentingPlace(RentingPlace rentingPlace) {
		this.rentingPlace = rentingPlace;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((rentingPlace == null) ? 0 : rentingPlace.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarStorage other = (CarStorage) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (rentingPlace == null) {
			if (other.rentingPlace != null)
				return false;
		} else if (!rentingPlace.equals(other.rentingPlace))
			return false;
		return true;
	}
	
	  @Override
		public String toString() {
			return "CarStorage [id=" + id + ", car=" + car + ", rentingPlace=" + rentingPlace + ", units=" + units
					+ ", placeName=" + placeName + "]";
		}
	
	
}
