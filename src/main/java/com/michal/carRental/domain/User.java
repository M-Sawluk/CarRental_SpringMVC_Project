package com.michal.carRental.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.michal.carRental.forms.ReCaptchaForm;
import com.michal.carRental.validator.PasswordRepetition;
import com.michal.carRental.validator.UserEmail;
import com.michal.carRental.validator.UserName;

@Entity
@PasswordRepetition
public class User extends ReCaptchaForm implements Serializable {

	private static final long serialVersionUID = -5991809008372848478L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USER_ID") 
	private long id;
	
	@Pattern(regexp = "[a-zA-Z ]{5,25}", message = "{pattern.user.username.validation}")
	@UserName
	private String username;

	@Pattern(regexp = "[a-zA-Z ]{3,25}", message = "{pattern.user.name.validation}")
	private String name;

	@Size(min = 5,message = "{pattern.user.password.validation}")
	private String password;
	
	@Size(min = 5, message = "{pattern.user.password.validation}")
	@Transient
	private String password1;

	@Email
	@UserEmail
	@NotNull
	private String email;
	
	private Date dateCreated;

	@Pattern(regexp = "[a-zA-Z0-9./ ]{4,60}", message = "{pattern.user.address.validation}")
	private String address;

	@Pattern(regexp = "[0-9-]{7,14}", message = "{pattern.user.tele.validation}")
	private String telephone;

	@Pattern(regexp = "[0-9-/]{8,10}", message = "{pattern.user.birth.validation}")
	private String birth;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "UsersAndRoles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	@OneToMany(mappedBy="user",orphanRemoval=true)
	private Set<Order> order = new HashSet<Order>();

	public User() {
		this.status= UserStatus.INACTIVE;
	}

	public User(String username, String password, List<Role> roles, UserStatus status, String email, String birth,
			String telephone, String address) {
		super();

		this.username = username;
		this.password = password;
		this.roles = roles;
		this.status = status;
		this.email = email;
		this.birth = birth;
		this.telephone = telephone;
		this.address = address;
	}

	
	
	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {

		this.roles = roles;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	
	
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password + ", email="
				+ email + ", address=" + address + ", telephone=" + telephone + ", birth=" + birth + "]";
	}

	
}
