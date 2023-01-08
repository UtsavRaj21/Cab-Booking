package com.utsav.cab.service.Implementations;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.utsav.cab.entity.Location;
import com.utsav.cab.service.LocationService;
import org.springframework.stereotype.Service;

public class LocationServiceImpl implements LocationService {

	@Override
	public Location getLocation(String location) throws NumberFormatException {
		int xAxis = 0;
		int yAxis = 0;
		try {
			String loc = location.substring(1, location.length()-1);
			String[] arr = loc.split(",");
			xAxis = Integer.parseInt(arr[0]);
			yAxis = Integer.parseInt(arr[1]);
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
		}
		return new Location(xAxis, yAxis);
	}

}
