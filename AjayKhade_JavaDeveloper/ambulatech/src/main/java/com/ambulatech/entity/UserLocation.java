package com.ambulatech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ambulatech.payloads.Role;

@Entity
@Table(name = "user_location")
public class UserLocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	private String name;
	private Role role;
	private double latitude;
	private double longitude;
	
	public UserLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLocation(String name, Role role, double latitude, double longitude) {
		super();
		this.name = name;
		this.role = role;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public long getUserId() {
		return userId;
	}
	
	
}
