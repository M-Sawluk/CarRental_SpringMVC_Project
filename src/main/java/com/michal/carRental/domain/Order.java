package com.michal.carRental.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.michal.carRental.validator.FutureDate;
import com.michal.carRental.validator.RentingDateRange;

@Entity
@Table(name = "orders")
@RentingDateRange
public class Order implements Serializable{

	private static final long serialVersionUID = -6389653771904477133L;

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private long id;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy' 'HH:mm")
	@FutureDate
	@NotNull
	private Date rentStart;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy' 'HH:mm")
	@NotNull
	private Date rentEnd;
	
	@ManyToOne
    @JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "CAR_ID")
	@JsonManagedReference
	private Car car;
	
	@ManyToOne
    @JoinColumn(name = "RENTINGPLACE_ID")
	private RentingPlace rentingPlace;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
		

	private int price;

	//Helpers
	
	@Transient
	private List<Car> cars;
	
	@Transient
	private List<RentingPlace> places;
	
	@Transient
	@Pattern(regexp = "C[0-9]+", message = "carId powinno siê sk³adac z C i cyfr")
	private String selectedCar;
	
	@Transient
	@Digits(integer=3, fraction = 0, message="Please Select City")
	private String selectedPlace;
	
	//End of Helpers
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getRentStart() {
		return rentStart;
	}

	public void setRentStart(Date rentStart) {
		this.rentStart = rentStart;
	}

	public Date getRentEnd() {
		return rentEnd;
	}

	public void setRentEnd(Date rentEnd) {
		this.rentEnd = rentEnd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<RentingPlace> getPlaces() {
		return places;
	}

	public void setPlaces(List<RentingPlace> places) {
		this.places = places;
	}

	public String getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(String selectedCar) {
		this.selectedCar = selectedCar;
	}

	public String getSelectedPlace() {
		return selectedPlace;
	}

	public void setSelectedPlace(String selectedPlace) {
		this.selectedPlace = selectedPlace;
	}

	public int getPrice() {
		
		return (int)((rentEnd.getTime()-rentStart.getTime())/(1000*60*60*24))*car.getPrice();
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [rentStart=" + rentStart + ", rentEnd=" + rentEnd + ", user=" + user + ", car=" + car
				+ ", rentingPlace=" + rentingPlace + ", status=" + status + "]";
	}


	
}
