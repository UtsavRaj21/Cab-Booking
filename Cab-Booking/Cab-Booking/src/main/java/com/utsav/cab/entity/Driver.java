package com.utsav.cab.entity;

public class Driver {
	private Person person;
	private Vehicle vehicle;
	private Location location;
	private Boolean available;
	
	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(Person person, Vehicle vehicle, Location location) {
		super();
		this.person = person;
		this.vehicle = vehicle;
		this.location = location;
		this.available = true;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Driver [person=" + person + ", vehicle=" + vehicle + ", location=" + location + ", available="
				+ available + "]";
	}

	
	
	
}
