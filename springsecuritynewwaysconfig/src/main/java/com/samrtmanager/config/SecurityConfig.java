package com.samrtmanager.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.samrtmanager.service.UserInfoUserDetailService;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	
//	@Bean
//	public InMemoryUserDetailsManager getUserDetail() {
//		
//		UserDetails user1 = User.builder()
//		.username("rajesh")
//		.password(passwordEncoder().encode("rajesh"))
//		.roles("ADMIN")
//		.build();
//		
//		UserDetails user2 = User.builder()
//				.username("rajesh1")
//				.password(passwordEncoder().encode(null))
//				.roles("NORMAL")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user1,user2);
//	}
	
	@Bean
	public UserDetailsService getUserDetailService() {
		
		return new UserInfoUserDetailService();
		
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		
	httpSecurity
	.authorizeHttpRequests(auth->{
		auth
		.requestMatchers("/home/new").permitAll()
		.requestMatchers("/home/public").permitAll()
		.requestMatchers("/home/admin").hasRole("ADMIN")
		.requestMatchers("/home/admin/*").hasRole("ADMIN")
		.requestMatchers("/home/normal").hasRole("NORMAL")
		.requestMatchers("/home/normal/*").hasRole("NORMAL")
		.anyRequest().authenticated();
	});
	
	httpSecurity.formLogin(form -> form
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll());
	
	httpSecurity.logout(logout -> logout.permitAll());
	
	return httpSecurity.build();
	
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
