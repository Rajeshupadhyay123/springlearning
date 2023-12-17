package com.samrtmanager.service;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.samrtmanager.config.UserInfoUserDetails;
import com.samrtmanager.entity.UserInfo;
import com.samrtmanager.exception.UserNotFoundException;
import com.samrtmanager.repository.UserInfoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserInfoUserDetailService implements UserDetailsService {

	@Autowired
	private UserInfoRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserInfo> userInfo = repository.findByName(username);
		
		userInfo.map(UserInfoUserDetails::new)
		.orElseThrow(()-> new UserNotFoundException("user not found "+username));
		
		return null;
	}
	
	
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		
		return "user added to System";
	}

}
