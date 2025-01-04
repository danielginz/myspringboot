package com.tour.model;

import java.util.Set;

import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Role extends AbstractPersistable<Long>{
	private static final long serialVersionUID = 2025_01_03_001L;
	
	private String name;

	@OneToMany(targetEntity = User.class, mappedBy = "role", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<User> users;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
