package com.michal.carRental.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;

import com.michal.carRental.forms.ReCaptchaForm;

@Entity
public class Subscriber extends ReCaptchaForm implements Serializable {

	private static final long serialVersionUID = 6258140608472416332L;


	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min = 1, max = 40)
	private String firstName;
	
	@NotNull
	@Size(min = 1, max = 40)
	private String lastName;
	
	@NotNull
	@Size(min = 1, max = 80)
	@Email
	private String email;
	
	private boolean confirmed = false;
	private String ipAddress;
	private Date dateCreated;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("id", id)
			.append("firstName", firstName)
			.append("lastName", lastName)
			.append("email", email)
			.append("confirmed", confirmed)
			.append("ipAddress", ipAddress)
			.append("dateCreated", dateCreated)
		.toString();
	}
}
