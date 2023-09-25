package com.rajesh.spring.demo.springlearningone.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	
	@GetMapping("/showMyLoginPage")
	public  String showMyLoginPage() {
		
		
		return "fancy-login";
	}
	
	
	
	//add request mapping for /access-denied
	@GetMapping("/access-denied")
	public  String showAccessDenied() {
		
		
		return "access-denied";
	}
	
	
	
	
	
	
	
	/*
	 * Here I give 3 ways to get the user details which was logged in into
	 * the controller.
	 */
	
	//With the help of Principal
	@GetMapping("/userdetails_first")
	public String getPrincipal(Principal principal, Model model) {
		
		String userName = principal.getName();
		
		
		model.addAttribute("UserName", userName);
	    return "usercheck"; 
	}
	
	//he simplest way to retrieve the currently authenticated principal is via a static call to the SecurityContextHolder:
	@GetMapping("/userdetails_second")
	public String getUserName(Model model) {
		String currentUserName = null;
		Collection<? extends GrantedAuthority> currentUserAuthorities = null;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			currentUserName = authentication.getName();
			currentUserAuthorities = authentication.getAuthorities();
		}
		model.addAttribute("UserName", currentUserName);
		model.addAttribute("UserRole", currentUserAuthorities);
		
		return "usercheck";
	}
	
	//Using SecurityContextHolder + UserDetails.getUsername()
	@GetMapping("/userdetails_third")
	public String getUserDetailsLogedIn(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		String userName = userDetails.getUsername();
		Collection<? extends GrantedAuthority> authority = userDetails.getAuthorities();
		
		//with the help of this method user can also get the password
		String password =  userDetails.getPassword();
		
		
		model.addAttribute("UserName", userName);
		model.addAttribute("UserRole", authority);
		
		System.out.println("Password is:  "+password);
		
		
		return "usercheck";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

//https://www.springcloud.io/post/2022-02/spring-security-get-current-user/#gsc.tab=0
//https://www.javaguides.net/2019/06/spring-security-get-current-logged-in-user-details.html
