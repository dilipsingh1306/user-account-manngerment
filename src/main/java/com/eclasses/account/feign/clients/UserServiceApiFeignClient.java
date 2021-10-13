package com.eclasses.account.feign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eclasses.account.model.response.UserDetailsObject;

@FeignClient(name="user-service")
public interface UserServiceApiFeignClient {
	
	@GetMapping("/user/{emailId}")
	public UserDetailsObject getUserDetails(@PathVariable String emailId);
	
	

}
