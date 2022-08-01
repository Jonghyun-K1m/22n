package hello.basic.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.basic.Appconfig;
import hello.basic.member.MemberService;
import hello.basic.member.MemberServiceImpl;

public class beanBasicFindTest {

	
	ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
	@Test
	@DisplayName("빈 이름 조회")
	void findbasicBean() {
		MemberService ms = ac.getBean(MemberService.class);
		
		System.out.println("ms = " + ms);
		System.out.println("ms = " + ms.getClass());
		Assertions.assertThat(ms).isInstanceOf(MemberServiceImpl.class);
	}
	@Test
	@DisplayName("구체타입")
	void findbasicBean2() {
		MemberService ms = ac.getBean(MemberServiceImpl.class);
		
		System.out.println("ms = " + ms);
		System.out.println("ms = " + ms.getClass());
		Assertions.assertThat(ms).isInstanceOf(MemberServiceImpl.class);
	}
	
	
	
	
}
