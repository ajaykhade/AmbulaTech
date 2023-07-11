package com.ambulatech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ambulatech.entity.UserLocation;

@Repository
public interface UserLocationRepo extends JpaRepository<UserLocation, Long> {

}
