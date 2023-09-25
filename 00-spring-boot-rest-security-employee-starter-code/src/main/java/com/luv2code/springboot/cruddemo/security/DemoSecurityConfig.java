package com.luv2code.springboot.cruddemo.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;


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
//				.username("rajesh")
//				.password("{noop}rajesh123")
//				.roles("EMPLOYEE")
//				.build();
//		
//		
//		UserDetails shalu = User.builder()
//				.username("shalu")
//				.password("{noop}shalu123")
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
	
	
	//Add support for JDBC ........
	//This is used for default
//	@Bean
//	public UserDetailsManager userDetailsManager(DataSourc dataSource) {
//		
//		return new JdbcUserDetailsManager(dataSource);
//	}
	
	
	//for custom table specific
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserDetailsManager= new JdbcUserDetailsManager(dataSource);
		
		//define query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"select user_id, pw, active from members where user_id=?"
				);
		
		//define query to retrieve the authorities/ roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select user_id, role from roles where user_id = ?"
				);
		
		return jdbcUserDetailsManager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer -> 
		configurer
		.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
		.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
		.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")	
		
		);
		
		//use HTTP Basic Authentication
		http.httpBasic(Customizer.withDefaults());
		
		//disable Cross Site Request Forgery (CSRF)
		//In general, not required for state-less REST APIs that use POST,PUT, DELETE or PATCH
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
		
	}
	
}

//https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html
