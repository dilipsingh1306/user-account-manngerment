package com.eclasses.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.eclasses.account.feign.clients.UserServiceApiFeignClient;
import com.eclasses.account.model.response.UserDetailsObject;
import com.eclasses.account.service.UserAccountManagementService;

@Service
public class UserAccountManagementServiceImpl implements UserAccountManagementService{

	UserServiceApiFeignClient userClinet;
	Environment env;
	
	@Autowired
	public UserAccountManagementServiceImpl(UserServiceApiFeignClient userClinet,Environment env) {
		
		this.userClinet = userClinet;
		this.env = env;
		
	}
	
	@Override
	public UserDetailsObject getUserDetails(String emailId) {

		UserDetailsObject userObject = this.userClinet.getUserDetails(emailId);
		
		return userObject;
	}

}
