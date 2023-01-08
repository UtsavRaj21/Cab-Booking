package com.utsav.cab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.utsav.cab.controller.ApplicationController;
import com.utsav.cab.entity.Driver;
import com.utsav.cab.entity.Location;
import com.utsav.cab.entity.Person;
import com.utsav.cab.entity.User;
import com.utsav.cab.entity.Vehicle;

@SpringBootApplication
public class CabBookingApplication implements CommandLineRunner {
	@Autowired
	private ApplicationController applicationController;

	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//User
		User user1= applicationController.add_User("user1,M, 22");
		User user2= applicationController.add_User("user2,M, 26");
		User user3= applicationController.add_User("user3,F, 28");
		System.out.println("user1:-"+user1);
		System.out.println("user2:-"+user2);
		System.out.println("user3:-"+user3);
		
		//Driver
		Driver driver1 = applicationController.add_driver("Driver1,M,26", "car, k-der-sf","(10,1)");
		Driver driver2 = applicationController.add_driver("Driver2,M,26", "car, k-der-sf","(11,20)");
		Driver driver3 = applicationController.add_driver("Driver3,M,26", "car, k-der-sf","(5,3)");
		System.out.println("driver1:-"+driver1);
		System.out.println("driver2:-"+driver2);
		System.out.println("driver3:-"+driver3);

		//TestCases
		boolean flag = false;
		List<Driver> testcase1 = applicationController.find_ride("user1", "(0,0)", "(20,1)");
		applicationController.getAvailableDriver(testcase1);
		if(testcase1.size()>0) {
			for(Driver driver : testcase1) {
				if(driver.getAvailable()) {
					flag = true;
					driver.setAvailable(false);
					applicationController.choose_ride("user1",driver.getPerson().getName());
					break;
				}
			}
			if(!flag) {
				System.out.print("No ride found [");
				for(Driver driver : testcase1) {
					System.out.print(driver.getPerson().getName()+" is not available , ");
				}
				System.out.print("]");
			}
			flag = false;
		}
		
		List<Driver> testcase2 = applicationController.find_ride("user2", "(10,0)", "(15,3)");
		applicationController.getAvailableDriver(testcase2);
		if(testcase2.size()>0) {
			for(Driver driver : testcase2) {
				if(driver.getAvailable()) {
					flag = true;
					driver.setAvailable(false);
					applicationController.choose_ride("user1",driver.getPerson().getName());
					break;
				}
			}
			if(!flag) {
				System.out.print("No ride found [");
				for(Driver driver : testcase2) {
					System.out.print(driver.getPerson().getName()+" is not available , ");
				}
				System.out.print("]");
			}
			flag = false;
		}

		List<Driver> testcase3 = applicationController.find_ride("user3", "(10,1)", "(20,4)");
		applicationController.getAvailableDriver(testcase3);
		if(testcase3.size()>0) {
			for(Driver driver : testcase3) {
				if(driver.getAvailable()) {
					flag = true;
					driver.setAvailable(false);
					applicationController.choose_ride("user1",driver.getPerson().getName());
					break;
				}
			}
			if(!flag) {
				System.out.print("No ride found [");
				for(Driver driver : testcase3) {
					System.out.print(driver.getPerson().getName()+" is not available , ");
				}
				System.out.print("]");
			}
			flag = false;
		}
		
	}
}