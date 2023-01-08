package com.utsav.cab.service;

import org.springframework.stereotype.Service;

import com.utsav.cab.entity.Location;

@Service
public interface LocationService {
	Location getLocation(String location);
}
