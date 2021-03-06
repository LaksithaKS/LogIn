package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@CrossOrigin()
@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService uService;
	
	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUsers = uService.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
}
