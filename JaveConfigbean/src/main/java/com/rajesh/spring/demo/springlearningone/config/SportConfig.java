package com.rajesh.spring.demo.springlearningone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rajesh.spring.demo.springlearningone.common.Coach;
import com.rajesh.spring.demo.springlearningone.common.SwimCoach;

@Configuration
public class SportConfig {

//    @Bean
//    Coach swimCoach() {
//		return new SwimCoach();
//	}
	
	@Bean("aquartic")
    Coach swimCoach() {
		return new SwimCoach();
	}
}

/*
 * Why use of @Configuration and @Bean:-
 * So, sometime when we take the jar file of the third party code and want to inject in our project,
 * we cannot open the third-party code and make the available of Class bean while adding @Component of implemented class in source code,
 * so for such case with the help of @Configuration and @Bean we can make available of the class to Bean-Factory.
 * 
 * here example:-
 * we have the SwimCoach class which implement the Coach interface, and we didn't mention the @Component on the top of the class
 * defination but still in the DemoController, we can use the @Autowired for making the Bean of it.
 * 
 * Here there are 2 new concept- we can create the bean id if we want or simple use of @Bean
 * so, for the first approach, we define the bean id then while using @AutoWired we need to provide the bean_id on
 * @Qualifier annotation.
 */
