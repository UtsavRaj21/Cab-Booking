package com.utsav.cab.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.utsav.cab.entity.Driver;
import com.utsav.cab.entity.User;
import com.utsav.cab.entity.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;

import com.utsav.cab.entity.Location;
import com.utsav.cab.entity.Person;
import com.utsav.cab.service.DriverService;
import com.utsav.cab.service.LocationService;
import com.utsav.cab.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ApplicationController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DriverService driverService;
	
	@Autowired
	LocationService locationService;

	
	public List<Driver> find_ride(String name, String source, String destination){
		try {
			Location srcLocation = locationService.getLocation(source);
			return driverService.findRide(srcLocation);
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public void choose_ride(String userName, String driverName) {
		System.out.println("Hello "+userName+", Ride Booked , Driver Name :- "+driverName);
	}
	
	private String[] getSplitDetail(String detail) {
		String[] detailArr = detail.split(",");
		try {
			for(int i = 0 ; i < detailArr.length ;i++) {
				detailArr[i] = detailArr[i].trim();
			}
		} catch (Exception e) {
			
		}
		return detailArr;
	}

	public User add_User(String userDetail){
		User user = null;
		try {
			String[] userDetailArr = getSplitDetail(userDetail);
			user = userService.add_user(userDetailArr[0],userDetailArr[1].charAt(0), Integer.parseInt(userDetailArr[2]));
		} catch (Exception e) {
			
		}
		return user;
	}
	
	public Driver add_driver(String person, String vehicle, String location) {
		Driver driver = null;
		try {
			String[] personDetailArr = getSplitDetail(person);
			Person per = new Person(personDetailArr[0], personDetailArr[1].charAt(0), Integer.parseInt(personDetailArr[2]));
			String[] vehicleDetailArr = getSplitDetail(vehicle);
			Vehicle veh = new Vehicle(vehicleDetailArr[0], vehicleDetailArr[1]);
			Location loc = locationService.getLocation(location);
			driver = driverService.add_driver(per, veh, loc);
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
		}
		return driver;
		
	}
	
	public void getDriverAvailable(List<Driver> driverList) {
		for(Driver driver : driverList) {
			System.out.println(driver.getPerson().getName()+"["+driver.getAvailable()+"]");
		}
	}
	
	public void getAvailableDriver(List<Driver> driverList) {
		try {
			if(driverList.size()==0) {
				System.out.println("No ride found [Since all the driver are more than 5 units away from user]");
			}else {
				for(int i = 0 ; i < driverList.size() ;i++) {
					if(driverList.get(i).getAvailable()) {
						System.out.print(driverList.get(i).getPerson().getName()+" [Available]");
						if(i != driverList.size()-1) {
							System.out.print(" , ");
						}
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
		}
		
	}

}
