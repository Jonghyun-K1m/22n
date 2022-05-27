package com.hyeon.first.repository;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.hyeon.first.domain.*;

class MemoryMemberRepositoryTest {

	MemberRepository repository = new MemoryMemberRepository();
	@AfterEach
	public void afterEach()
	{
		
	}
	@Test
	public void save()
	{
		Member member =new Member();
		member.setName("spr");
		repository.save(member);
		Member result = repository.findById(member.getId()).get();
		Assertions.assertEquals(member, result);
		
		
	}
	
	@Test
	public void findByName() {
		Member member1 =new Member();
		member1.setName("spr1");
		repository.save(member1);
			
		Member member2 =new Member();
		member2.setName("spr24");
		repository.save(member2);
		
		Member result3 = repository.findByName("spr24").get();
		Assertions.assertEquals(member2, result3);		

	}
	
	@Test
	public void findAll() {
		Member member1 =new Member();
		member1.setName("spr1");
		repository.save(member1);
			
		Member member2 =new Member();
		member2.setName("spr2");
		repository.save(member2);
		
		List<Member> result1 = repository.findAll();
		Assertions.assertEquals(result1.size(), 3);		

	}	

}
