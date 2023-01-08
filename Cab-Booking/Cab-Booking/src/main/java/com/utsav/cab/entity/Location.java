package com.utsav.cab.entity;

public class Location {
	private int xAxis;
	private int yAxis;
	public Location(int xAxis, int yAxis) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getxAxis() {
		return xAxis;
	}
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	@Override
	public String toString() {
		return "Location [xAxis=" + xAxis + ", yAxis=" + yAxis + "]";
	}
	
}
