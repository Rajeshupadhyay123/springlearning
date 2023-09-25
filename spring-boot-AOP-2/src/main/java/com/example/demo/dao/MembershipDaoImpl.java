package com.example.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {

	@Override
	public void addSilly() {
		System.out.println(getClass() + " :Done My work on Membership Account");
		
	}

}
