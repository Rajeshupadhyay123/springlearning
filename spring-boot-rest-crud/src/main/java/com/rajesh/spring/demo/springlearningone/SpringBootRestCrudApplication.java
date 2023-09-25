package com.rajesh.spring.demo.springlearningone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringBootRestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestCrudApplication.class, args);
	}

}
