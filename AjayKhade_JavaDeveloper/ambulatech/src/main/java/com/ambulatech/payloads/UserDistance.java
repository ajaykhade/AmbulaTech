package com.ambulatech.payloads;

import com.ambulatech.entity.UserLocation;

public class UserDistance {

	UserLocation user;
	double distance;
	
	
	
	public UserDistance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDistance(UserLocation user, double distance) {
		super();
		this.user = user;
		this.distance = distance;
	}

	public UserLocation getUser() {
		return user;
	}

	public void setUser(UserLocation user) {
		this.user = user;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}
