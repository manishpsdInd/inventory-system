package com.ecom.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.user.dto.UserRequest;
import com.ecom.user.dto.UserResponse;
import com.ecom.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/create")
	public UserResponse createUser(@RequestBody UserRequest request)	{
		return service.createUser(request);
	}
	
	@PostMapping("/get")
	public UserResponse getUserDetails(@RequestBody UserRequest request)	{
		return service.getUserDetails(request);
	}
	
}
