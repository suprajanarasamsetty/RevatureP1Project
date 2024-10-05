package com.revature.spring.revshop.dao;

import com.revature.spring.revshop.dto.UserRequest;
import com.revature.spring.revshop.dto.UserResponse;

public interface UserDAO {
	boolean createUser(UserRequest userRequest);
	UserResponse getUserById(long id);
	UserResponse updateUserById(UserRequest userRequest, long id);
	boolean deleteUserById(long id);
	UserResponse login(String email, String password);

}