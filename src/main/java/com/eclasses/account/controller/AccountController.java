package com.eclasses.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AccountController {
	
	@GetMapping("/status/check")
	public String getUserStatus() {
		
		return "User Avilable";
	}

}
