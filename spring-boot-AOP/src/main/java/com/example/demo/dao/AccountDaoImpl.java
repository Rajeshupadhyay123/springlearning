package com.example.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Override
	public void addAccount(Account account, boolean flag) {
		System.out.println(getClass() + " :Done My work");
		
	}

}
