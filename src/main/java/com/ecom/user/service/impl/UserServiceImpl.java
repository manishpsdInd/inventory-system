package com.ecom.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.user.dto.UserRequest;
import com.ecom.user.dto.UserResponse;
import com.ecom.user.entity.UserEntity;
import com.ecom.user.handler.InvalidUserException;
import com.ecom.user.handler.UserNotFoundException;
import com.ecom.user.repository.UserRepository;
import com.ecom.user.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService	{

	@Autowired
	private UserRepository repository;
	
	@Transactional
	@Override
	public UserResponse createUser(UserRequest request) {
		
		UserEntity entity = new UserEntity();

		UserEntity data = repository.getReferenceById(request.getUserId());
		if(data != null){
			throw new InvalidUserException("User data in invalid");
		}
		data = repository.save(entity);
		
		UserResponse response = new UserResponse();
		response.setUserName(data.getUserName());
		response.setUserType(data.getUserType());
		
		return response;
	}

	@Override
	public UserResponse getUserDetails(UserRequest request) {
		
		UserEntity data = repository.getReferenceById(request.getUserId());
		UserResponse response = new UserResponse();
		
		if(data == null){
			throw new UserNotFoundException("Invalid User Id Passed");
		} else {
			response.setUserName(data.getUserName());
			response.setUserType(data.getUserType());
		}
		
		return response;
	}

}