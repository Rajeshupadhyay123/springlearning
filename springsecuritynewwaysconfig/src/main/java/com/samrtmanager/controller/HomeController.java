package com.samrtmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samrtmanager.entity.UserInfo;
import com.samrtmanager.service.UserInfoUserDetailService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserInfoUserDetailService service;

	@PostMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}
	
	@GetMapping("/normal")
	@PreAuthorize("hasAuthority('ROLE_NORMAL')")
	public ResponseEntity<String> normalUser(){
		return new ResponseEntity<String>("yes, I am user",HttpStatus.OK);
	}
	
	
	@GetMapping("/public")
	public ResponseEntity<String> publicUser(){
		return new ResponseEntity<String>("yes, I am public",HttpStatus.OK);
	}
	
	/*
	 * With the  help of @PreAuthorize we can give the access based on methods for a roll based access
	 * to enable this annotation we need to use @EnableMethodSecurity in our security configuration class
	 */
	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> adminUser(){
		return new ResponseEntity<String>("yes, I am admin user",HttpStatus.OK);
	}
	
}
