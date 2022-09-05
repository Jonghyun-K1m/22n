package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.db.MemberDB;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional

public class MemberTest {

	@Autowired
	MemberService mst;
	@Autowired
	MemberDB mdb;

	
	@Test
	@DisplayName("생성")
	// 객체를 호출시마다 생성
	void join1() {
		
		Member acc=new Member();
		acc.setName("ad");
		Long acfc=mst.join(acc);
		
		Assertions.assertThat(acc).isEqualTo(mdb.findOne(acfc));
		
	}
	
	
	@Test //(expected=IllegalStateException.class)
	
	@DisplayName("중복가입안되지???")
	// 객체를 호출시마다 생성
	void join2() {
		
		Member acc=new Member();
		acc.setName("adc");
		Member a0=new Member();
		a0.setName("adc");
		
		mst.join(a0);
		mst.join(acc);
		
		
		
		
	}
	
}
