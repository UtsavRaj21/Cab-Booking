package com.utsav.cab.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.utsav.cab.entity.User;

@Service
public interface UserService {
	ArrayList<User> getAllUser();
	User add_user(String name, Character gender, int age);
}
