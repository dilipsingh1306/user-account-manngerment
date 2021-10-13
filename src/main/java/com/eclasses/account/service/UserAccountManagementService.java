package com.eclasses.account.service;

import com.eclasses.account.model.response.UserDetailsObject;

public interface UserAccountManagementService {

	public UserDetailsObject getUserDetails(String emailId);
	
}
