package com.ambulatech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ambulatech.customException.ResourceNotFoundException;
import com.ambulatech.entity.UserLocation;

@Service
public interface UserLocationService {

	UserLocation createUser(UserLocation user);
	
	UserLocation getUser(long id)throws ResourceNotFoundException;
	
	List<UserLocation> getUsers(int n, UserLocation user);
	
	UserLocation updateUser(long id, UserLocation user) throws ResourceNotFoundException;
}
