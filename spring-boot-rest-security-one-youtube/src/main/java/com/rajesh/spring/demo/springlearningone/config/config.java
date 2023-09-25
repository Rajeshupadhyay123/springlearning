package com.rajesh.spring.demo.springlearningone.config;


import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class config{
	
	
	
	/*
	 * This DataSource Bean is neccesary without  this we cannot create the automatic bean for
	 * the DataSource
	 * https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html
	 */
	
	@Bean
	DataSource dataSource() {
		
		DataSourceBuilder dataSourceBuilder = 
				DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/employee_directory");
		dataSourceBuilder.username("springstudent");
		dataSourceBuilder.password("springstudent");
		
		return dataSourceBuilder.build();
	}
	
	
	
	/*
	 * If we want to use the by-default spring security with JdbcUserDetailsManager(dataSource) then we must create 
	 * the user table with "users" name and authority table with "authorities"
	 * because when we check the JdbcUserDetailsManager implementation all the user and authorities are doing on
	 * above mention name. If somehow we change the name of table name then spring boot cannot handle the security automatically.
	 * https://www.youtube.com/watch?v=3Q2unvE-3Hg&list=PLciPu9FabM_5eWhd3sW8GKA2Um4qbmrcC&index=12&ab_channel=GenieAshwani
	 * 
	 * But there is a concept on which we can use our own custom table name and implementation that we will check later
	 */
	
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}
	

	/*
	 * SecurityFiltrChain is use to filter the web url request
	 * 
	 * .authenticated() is use to security check, if we add URL and add the authenticated() call
	 * on that then it will authenticate that URL with security check
	 * 
	 * .permitAll() is use for given access to the URL without security check
	 * 
	 * .denyAll() is use for revoke all the access on the URL
	 * 
	 * .anyRequest() this is use for taking all request without any URL check
	 * .requestMatchers is use for taking URL in a custom form either GET/POST/PUT/DELETE
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		//here whatever request will come the security check will added
//		http
//			.authorizeHttpRequests((request) -> request
//					.anyRequest().authenticated()
//					);
		
		http.authorizeHttpRequests((request)->
		request
		.requestMatchers(HttpMethod.GET,"/api/account").authenticated()
		.requestMatchers(HttpMethod.GET,"/api/balance").authenticated()
		.requestMatchers(HttpMethod.GET,"/api/update").permitAll()
		.requestMatchers(HttpMethod.GET,"/api/main").permitAll()
				);
				
		
		//If we want the request from html form request then this need to add
		http.formLogin();
		
		/*
		 * If we want the request with basic google link request then this need to add
		 */
		http.httpBasic(Customizer.withDefaults());
		
//		If we want to permit all the request without any validation check
//		http.authorizeHttpRequests((request)->
//		request.anyRequest().permitAll());
				
	
		//If we want to deny all the request without any validation check
//		http.authorizeHttpRequests((request)->
//		request.anyRequest().denyAll());
		
		return http.build();
		
	}
	
	
//	public UserDetailsService userDetailsService() {
//		
//		InMemoryUserDetailsManager inMemoryUserDetailsManager
//		= new InMemoryUserDetailsManager();
//		
//		UserDetails user = User.builder()
//				.username("rajesh")
//				.password("{noop}1235")
//				.roles("ADMIN")
//				.build();
//		
//		UserDetails admin = User.builder()
//				.username("admin")
//				.password("{noop}1235")
//				.roles("ADMIN","USER")
//				.build();
//		
//			inMemoryUserDetailsManager.createUser(user);
//			inMemoryUserDetailsManager.createUser(admin);
//		
//		return inMemoryUserDetailsManager;
//	}
	
	
	
	
	
}

//https://www.youtube.com/watch?v=Kt43scj3d48&list=PLciPu9FabM_5eWhd3sW8GKA2Um4qbmrcC&index=7

/*
 * The main components and their role are:

UserDetailsManager: This interface extends UserDetailsService interface. It is also responsible for user create, updates, or delete operations.
UserDetailsService: This interface defines a method that finds the user by username.
UserDetails: This interface describes the user.
GrantedAuthority: GrantedAuthority interface represents the authorities that a user can have.

https://asbnotebook.com/basics-of-spring-security-user-management/
https://www.youtube.com/watch?v=Kt43scj3d48&list=PLciPu9FabM_5eWhd3sW8GKA2Um4qbmrcC&index=7
https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html
 */
