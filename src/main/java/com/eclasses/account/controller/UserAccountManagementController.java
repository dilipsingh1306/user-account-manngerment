package com.eclasses.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eclasses.account.model.response.UserDetailsObject;
import com.eclasses.account.service.UserAccountManagementService;

@RestController
@RequestMapping("/user")
public class UserAccountManagementController {
	
	private static final Logger log = LoggerFactory.getLogger(UserAccountManagementController.class);

	@Autowired
	UserAccountManagementService service;
	
	@Autowired
	private Environment env;

	@GetMapping("/{userId}")
	public ResponseEntity<UserDetailsObject> getUserStatus(@PathVariable String userId) {
		
		log.info("Fetching User Details :"+userId);

		UserDetailsObject userObject = service.getUserDetails(userId);
		
		return new ResponseEntity<UserDetailsObject>(userObject,HttpStatus.OK);
	}
	
	@GetMapping("/env/port")
	public String getConnectedPort() {
		
		log.info("Test properties from config server : api.gateway.token "+env.getProperty("api.gateway.token"));
		return "Port Connected is " + env.getProperty("local.server.port");
		
	}

}
