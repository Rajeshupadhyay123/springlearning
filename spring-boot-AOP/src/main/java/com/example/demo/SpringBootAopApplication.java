package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.Account;
import com.example.demo.dao.AccountDao;
import com.example.demo.dao.MembershipDao;

@SpringBootApplication
public class SpringBootAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopApplication.class, args);
	}
	
	/*
	 * Here AccountDao dependency will be auto injected because of @Bean annotation
	 */
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao) {
		
		return runner ->{
			demoTheBeforeAdvice(accountDao, membershipDao);
		};
	}

	private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
		
		//call the bussiness method
		Account account = new Account();
//		accountDao.addAccount(account);
		accountDao.addAccount(account, true);
		
		//call the membership business method
		membershipDao.addSilly();
		
//		
//		System.out.println("\n let's call it again! \n");
//		
//		accountDao.addAccount();
		
	}

}




















