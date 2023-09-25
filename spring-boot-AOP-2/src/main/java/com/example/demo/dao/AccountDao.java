package com.example.demo.dao;

import java.util.List;

public interface AccountDao {
	
	//add a new methods: findAccount()
	
	List<Account> findAccount();
	
	public String getName();


	public void setName(String name);


	public String getServiceCode();


	public void setServiceCode(String serviceCode);

	
	void addAccount(Account account, boolean flag);
}
