package com.ambulatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ambulatech.customException.ResourceNotFoundException;
import com.ambulatech.entity.UserLocation;
import com.ambulatech.service.UserLocationService;

@RestController
@RequestMapping("/user")
public class UserLocationController {
	
	@Autowired
	UserLocationService userLocationService;
	
	@PostMapping("/create_data")
	public ResponseEntity<UserLocation> createUser(@RequestBody UserLocation user){
		
		UserLocation savedUser = userLocationService.createUser(user);
		
		return new ResponseEntity<UserLocation>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("get_user/{id}")
	public ResponseEntity<UserLocation> getUser(@PathVariable long id){
		
		try {
			UserLocation foundUser = userLocationService.getUser(id);
			
			return new ResponseEntity<UserLocation>(foundUser, HttpStatus.FOUND);
		} catch (ResourceNotFoundException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<UserLocation>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("get_users/{n}")
	public ResponseEntity<List<UserLocation>> getNearByUsers(@PathVariable int n, @RequestBody UserLocation user){
		List<UserLocation> usersList = userLocationService.getUsers(n, user);
		return new ResponseEntity<List<UserLocation>>(usersList, HttpStatus.OK);
	}
	
	@PutMapping("update_data/{id}")
	public ResponseEntity<UserLocation> updateUser(@PathVariable long id, @RequestBody UserLocation user){
		try {
			UserLocation updatedUser = userLocationService.updateUser(id, user);
			return new ResponseEntity<UserLocation>(updatedUser, HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<UserLocation>(HttpStatus.NOT_FOUND);
		}
	}

}
