package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	private String name;
	private String serviceCode;
	

	@Override
	public void addAccount(Account account, boolean flag) {
		System.out.println(getClass() + " :Done My work");
		
	}


	public String getName() {
		System.out.println(getClass() + " :is getName");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass() + " :is setName");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass() + " :is getServiceCode");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " :is setServiceCode");
		this.serviceCode = serviceCode;
	}


	@Override
	public List<Account> findAccount() {
		
		List<Account> myAccounts = new ArrayList<Account>();
		
		//create sample accounts
		Account account1 = new Account("Rajesh","Gold");
		Account account2 = new Account("Raj", "Silver");
		Account account3 = new Account("Rama","Platinum");
		
		//add them to our account list
		myAccounts.add(account1);
		myAccounts.add(account2);
		myAccounts.add(account3);
		
		return myAccounts;
	}

	
}




































