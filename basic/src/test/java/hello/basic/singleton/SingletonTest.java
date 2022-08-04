package hello.basic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.basic.Appconfig;
import hello.basic.member.Grade;
import hello.basic.member.Member;
import hello.basic.member.MemberService;

public class SingletonTest {

	
	MemberService mst;
	@BeforeEach
	public void beforeEach() {
		Appconfig appc = new Appconfig();
		mst=appc.memberService();
	}
	
	@Test
	@DisplayName("스프링X")
	// 객체를 호출시마다 생성
	void join() {
		Appconfig appcc = new Appconfig();
		MemberService mst1 = appcc.memberService();
		MemberService mst2 = appcc.memberService();
		
		
		Assertions.assertThat(mst1).isEqualTo(mst2);
		
	}
	
	@Test
	@DisplayName("싱글톤 적용")
	// 객체를 호출시마다 생성
	// 스프링은 컨테이너가 자체로 싱글톤적용
	void join1() {
		SingletonService mst1=SingletonService.getInstance();
		SingletonService mst2=SingletonService.getInstance();
		
		Assertions.assertThat(mst1).isEqualTo(mst2);
		
	}
	
	@Test
	@DisplayName("스프링 컨테이너")
	// 객체를 호출시마다 생성
	void join3() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
		
		MemberService mst1 = ac.getBean(MemberService.class);
		MemberService mst2 = ac.getBean(MemberService.class);
		
		
		Assertions.assertThat(mst1).isEqualTo(mst2);
		
	}
	
}
