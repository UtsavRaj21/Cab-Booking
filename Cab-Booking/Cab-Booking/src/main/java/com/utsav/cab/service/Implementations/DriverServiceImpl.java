package com.utsav.cab.service.Implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.utsav.cab.entity.Driver;
import com.utsav.cab.entity.Location;
import com.utsav.cab.entity.Person;
import com.utsav.cab.entity.Vehicle;
import com.utsav.cab.service.DriverService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class DriverServiceImpl implements DriverService {
	private final int maximumAllowedDistance;

	private final List<Driver> driverRepository;


	public DriverServiceImpl(){
		this(5);
	}

	public DriverServiceImpl(int maximumAllowedDistance) {
		this.maximumAllowedDistance = maximumAllowedDistance;
		this.driverRepository = new ArrayList<>();
	}

	@Override
	public List<Driver> getAllDriver() {
		return this.driverRepository;
	}

	@Override
	public Driver add_driver(Person person, Vehicle vehicle, Location location) {
		Driver driver = new Driver(person, vehicle, location);
		driverRepository.add(driver);
		return driver;
	}

	@Override
	public List<Driver> findRide(Location srcLocation) {
		return this.driverRepository
				.stream()
				.map(e -> new DriverDistancePair(e, distanceBetweenLocations(srcLocation, e.getLocation())))
				.filter(obj -> filterForDistance(obj))
				.sorted()
				.map(DriverDistancePair::getDriver)
				.collect(Collectors.toList());
	}

	private class DriverDistancePair implements Comparable<DriverDistancePair>{
		private final Driver driver;
		private final int distance;

		DriverDistancePair(Driver driver, int distance) {
			this.driver = driver;
			this.distance = distance;
		}

		@Override
		public int compareTo(DriverDistancePair o) {
			return this.distance - o.distance;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof DriverDistancePair)) return false;
			DriverDistancePair that = (DriverDistancePair) o;
			return distance == that.distance && getDriver().equals(that.getDriver());
		}

		@Override
		public int hashCode() {
			return Objects.hash(getDriver(), distance);
		}

		public Driver getDriver() {
			return driver;
		}
	}

	private int distanceBetweenLocations(Location userLocation, Location driverLocation){
		double xdis = Math.pow(userLocation.getxAxis() - driverLocation.getxAxis(), 2);
		double ydis = Math.pow(userLocation.getyAxis() - driverLocation.getyAxis(), 2);
		return  (int) Math.sqrt(xdis+ydis);
	}

	private boolean filterForDistance(DriverDistancePair driverDistancePair){
		return driverDistancePair.distance < maximumAllowedDistance;
	}

}
