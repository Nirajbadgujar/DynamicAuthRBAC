package com.DynamicAuthRBAC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.DynamicAuthRBAC.entity.User;
import com.DynamicAuthRBAC.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User createUser(User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return userRepository.save(user);
	}
}
