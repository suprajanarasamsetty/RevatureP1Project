package com.revature.spring.revshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.spring.revshop.dao.UserDAOImpl;
import com.revature.spring.revshop.dto.UserRequest;
import com.revature.spring.revshop.dto.UserResponse;

@Service
public class UserService {
	
	private UserDAOImpl userDao;
	
	@Autowired
	public UserService(UserDAOImpl userDao) {
		this.userDao = userDao;
	}
	
	
	
	public boolean createUser(UserRequest userRequest) {
		
		return userDao.createUser(userRequest);
		
		
	}
	
	public UserResponse getUserById(long id) {
		return userDao.getUserById(id);
	}
	
	public UserResponse updateUserById(UserRequest userRequest, long id) {
		return userDao.updateUserById( userRequest,  id);
	}
	public boolean deleteUserById(long id) {
		return userDao.deleteUserById(id);
	}
	
	public UserResponse login(String email, String password) {
		return userDao.login(email, password);
	}

}