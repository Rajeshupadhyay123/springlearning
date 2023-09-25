package com.rajesh.spring.demo.springlearningone.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		
//		/*
//		 * For password passing we have the multiple option ini {id}encodedPassword
//		 * like:-
//		 * we are using {noop} -> no operation plain text password
//		 * we can also use "bcrypt" -> BCrypt encryption on password
//		 */
//		
//		UserDetails rajesh = User.builder()
//				.username("john")
//				.password("{noop}john123")
//				.roles("EMPLOYEE")
//				.build();
//		
//		
//		UserDetails shalu = User.builder()
//				.username("mary")
//				.password("{noop}mary123")
//				.roles("EMPLOYEE","MANAGER")
//				.build();
//		
//		
//		UserDetails suman = User.builder()
//				.username("suman")
//				.password("{noop}suman123")
//				.roles("EMPLOYEE","MANAGER","ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(rajesh,shalu,suman);
//	}
//	
	
	
	//Add support for JDBC...........
	//Here we are using by-default provided code for  users and authorities table from spring framework
//	@Bean
//	public UserDetailsManager  userDetailsManager(DataSource dataSource) {
//		
//		
//		return new JdbcUserDetailsManager(dataSource);
//	}
	
	//For Custom user and role table
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		//define query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id,pw,active from members where user_id=?"
				);
		
		//define query to retrieve the authorities/role by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id,role from roles where user_id=?"
				);
		
		return jdbcUserDetailsManager;
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		/*
		 * Here we need to create a controller for handling "showMyLoginPage" but 
		 * for "authenticateTheUser" no need to create any controller, Spring
		 * Automatically handle this but URL must be same.
		 * Note: while sending the action request for your login form, the action URL
		 * must be "authenticateTheUser".
		 * 
		 * exceptionHandling can check every exception that occur during security check
		 * so, here we are handling for access-denied. But the URL /access-denied
		 * can be anything according to our own.
		 */
		
		http.authorizeHttpRequests(configuration -> 
			configuration
					.requestMatchers("/").hasRole("EMPLOYEE")
					.requestMatchers("/leaders/**").hasRole("MANAGER")
					.requestMatchers("/systems/**").hasRole("ADMIN")
					.anyRequest().authenticated()
				)
					.formLogin(form ->
							form
								.loginPage("/showMyLoginPage")
								.loginProcessingUrl("/authenticateTheUser")
								.permitAll()
							)
					.logout(logout ->
						logout.permitAll()
							)
					.exceptionHandling(configuration ->
					configuration.accessDeniedPage("/access-denied"));
		
		return http.build();
		
	}
	
}






















