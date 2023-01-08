package com.utsav.cab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.utsav.cab.entity.Driver;
import com.utsav.cab.entity.Location;
import com.utsav.cab.entity.Person;
import com.utsav.cab.entity.User;
import com.utsav.cab.entity.Vehicle;

@Service
public interface DriverService {
	List<Driver> getAllDriver();
	Driver add_driver(Person person,Vehicle vehicle,Location location);
	List<Driver> findRide(Location srcLocation);
}
