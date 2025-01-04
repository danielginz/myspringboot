package com.tour.model;

import java.util.Optional;

import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address extends AbstractPersistable<Long>{
	private static final long serialVersionUID = 2024_12_21_001L;
	
	private String city;
	private String state;
	private String country;
	//We will create one transient field for userId
	private transient Long userId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	//private Optional<User> user;
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public User getUser() {
	//public Optional<User> getUser() {
		//User aaa = user.get();
		return user;
	}
	//public void setUser(Optional<User> user) {
	public void setUser(User user) {	
		this.user = user;
	}
	
	
	
}
