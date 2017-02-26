package com.michal.carRental.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.michal.carRental.validator.CarId;

@Entity

public class Car implements Serializable  {

	private static final long serialVersionUID = 1464566456L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAR_ID") 
	private long id;
	
	@Pattern(regexp = "C[0-9]+", message = "carId powinno siê sk³adac z C i cyfr")
	@CarId
	private String carId;
	
	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9 ]{3,25}", message = "Minimum 3 znaki")
	private String name;
	@NotNull
	@Pattern(regexp = "[a-zA-Z ]{3,25}", message = "Minimum 3 znaki")
	private String manufacturer;
	
	@Min(value=0, message="Wiecej niz 0")
	@Digits(integer=8, fraction=2, message="Nie wiecej niz 8 cyfr dlugosci")
	private int price;
	@Pattern(regexp = "[a-zA-Z ]{3,25}", message = "Minimum 3 znaki")
	private String type;
	@Pattern(regexp= "[a-zA-Z0-9./ ]{3,60}", message = "Minimum 3 znaki")
	private String description;
	
	@OneToMany(mappedBy="car" ,  fetch= FetchType.EAGER)	
	@JsonBackReference
	private Set<CarStorage> carStorage= new HashSet<CarStorage>();
	
	@Transient
	@JsonIgnore
	private MultipartFile productImage;
	
	@OneToMany(mappedBy="car",orphanRemoval=true,fetch=FetchType.EAGER)
	@JsonBackReference
	private Set<Order> order = new HashSet<Order>();

	public Set<CarStorage> getCarStorage() {
		return carStorage;
	}

	public void setCarStorage(Set<CarStorage> carStorage) {
		this.carStorage = carStorage;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	@Transient
	public MultipartFile getProductImage() {
		return productImage;
	}
	@Transient
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Car other = (Car) obj;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (id != other.id)
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carId=" + carId + ", name=" + name + ", manufacturer=" + manufacturer + "]";
	}


}
