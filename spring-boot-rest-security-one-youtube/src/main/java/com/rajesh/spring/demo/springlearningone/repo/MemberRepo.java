package com.rajesh.spring.demo.springlearningone.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rajesh.spring.demo.springlearningone.model.Member;

public interface MemberRepo extends CrudRepository<Member, String>{
	
	List<Member> findByUserId(String user_id);

}
