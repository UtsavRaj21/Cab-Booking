package com.utsav.cab.service.Implementations;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.utsav.cab.entity.User;
import com.utsav.cab.service.UserService;
import org.springframework.stereotype.Service;


public class UserServiceImpl implements UserService {
	
	ArrayList<User> userRepository = new ArrayList<>();

	@Override
	public ArrayList<User> getAllUser() {
		return userRepository;
	}

	@Override
	public User add_user(String name, Character gender, int age) {
		User user = null;
		try {
			user = new User(name, gender, age);
			userRepository.add(user);
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
		}
		
		return user;
	}

}
