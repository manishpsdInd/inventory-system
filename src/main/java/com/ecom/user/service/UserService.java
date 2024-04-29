package com.ecom.user.service;

import com.ecom.user.dto.UserRequest;
import com.ecom.user.dto.UserResponse;

public interface UserService {

	public UserResponse createUser(UserRequest request);
	public UserResponse getUserDetails(UserRequest request);
	
}
