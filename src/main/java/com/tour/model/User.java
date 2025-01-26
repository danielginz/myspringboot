package com.tour.model;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class User extends AbstractPersistable<Long>{
	//private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = 2024_12_19_001L;
	private transient Long id;
	private String userId;
	private String userName;
	private String password;
	
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	@OneToMany(targetEntity = Address.class, mappedBy = "user", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Address> addresses;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		System.out.println("AAA, setRole()");
		this.role = role;
	}
}
