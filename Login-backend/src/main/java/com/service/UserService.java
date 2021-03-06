package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUser() {
		List<User> findAlluser = userRepository.findAll();
		return findAlluser;
	}
	
	public Optional<User> getUserById(String id) {
		Optional<User> finduserById = userRepository.findById(id);
		return finduserById;
	}
}
