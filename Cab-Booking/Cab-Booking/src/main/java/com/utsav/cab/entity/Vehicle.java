package com.utsav.cab.entity;

public class Vehicle {
	
	private String vehicleName;
	private String vehicleNumber;
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Vehicle(String vehicleName, String vehicleNumber) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "vehicle [vehicleName=" + vehicleName + ", vehicleNumber=" + vehicleNumber + "]";
	}
}
