package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.Account;
import com.example.demo.dao.AccountDao;
import com.example.demo.dao.MembershipDao;

@SpringBootApplication
public class SpringBootAop2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAop2Application.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao) {
		
		return runner ->{
//			demoTheBeforeAdvice(accountDao, membershipDao);
			demoTheAfterReturningAdvice(accountDao);
		};
		
	}
	
	
private void demoTheAfterReturningAdvice(AccountDao accountDao) {
		//call methods to find the accounts
	List<Account> accounts = accountDao.findAccount();
	
	//display the accounts
	System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
	System.out.println("------------------------");
	System.out.println(accounts);
	System.out.println("\n");
		
	}


private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
		
		//call the bussiness method
		Account account = new Account();
		account.setName("Ram");
		account.setLevel("Gold");
//		accountDao.addAccount(account);
		accountDao.addAccount(account, true);
		
		
		accountDao.setName("Rajesh");
		accountDao.setServiceCode("silver");
		
		String name = accountDao.getName();
		String code = accountDao.getServiceCode();
		
		//call the membership business method
		membershipDao.addSilly();
		
//		
//		System.out.println("\n let's call it again! \n");
//		
//		accountDao.addAccount();
		
	}

}






























