package com.ambulatech.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ambulatech.customException.ResourceNotFoundException;
import com.ambulatech.entity.UserLocation;
import com.ambulatech.payloads.UserDistance;
import com.ambulatech.repo.UserLocationRepo;
import com.ambulatech.service.UserLocationService;

@Service
@Transactional
public class UserLocationServiceImpl implements UserLocationService {
	
	@Autowired
	UserLocationRepo userLocationRepo;

	@Override
	public UserLocation createUser(UserLocation user) {
		UserLocation savedUser = userLocationRepo.save(user);
		return savedUser;
	}

	@Override
	public UserLocation getUser(long id) throws ResourceNotFoundException {
		UserLocation foundUser = userLocationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));;
		
		return foundUser;
	}

	@Override
	public List<UserLocation> getUsers(int n, UserLocation user) {
		double longitude = user.getLongitude();
		double latitude = user.getLatitude();
		
		List<UserLocation> allUsers = userLocationRepo.findAll();
		
		java.util.List<UserDistance> userDistances = allUsers.stream()
				.map(user1 -> new UserDistance(user1, calculateDistance(latitude, user1.getLatitude(),longitude, user1.getLongitude())))
				.collect(Collectors.toList());
		
		userDistances.sort(Comparator.comparingDouble(UserDistance::getDistance));
		
		List<UserLocation> nearestUsers = userDistances.stream()
				.limit(n)
				.map(UserDistance::getUser)
				.collect(Collectors.toList());
		return nearestUsers;
	}

	private double calculateDistance(double latitude, double latitude2, double longitude, double longitude2) {
		double latDiff = latitude2 - latitude;
		double longDiff = longitude2 - longitude;
		
		double distance = Math.sqrt(latDiff*latDiff + longDiff*longDiff);
		
		return distance;
	}

	@Override
	public UserLocation updateUser(long id, UserLocation user) throws ResourceNotFoundException {
		UserLocation foundUser = userLocationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));
		
		//role and id updating is not allowed
		foundUser.setName(user.getName());
		foundUser.setLatitude(user.getLatitude());
		foundUser.setLongitude(user.getLongitude());
		
		return foundUser;
	}

}
