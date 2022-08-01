package hello.basic.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.basic.Appconfig;
import hello.basic.discount.DiscountPolicy;
import hello.basic.member.MemberRepository;
import hello.basic.member.MemberService;
import hello.basic.member.MemberServiceImpl;
import hello.basic.member.MemoeyMemberRepository;

public class beanDuplicateTest {

	
	ApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
	@Test
	@DisplayName("둘 이상의 같은 타입이 있으면 중복오류 발생")
	//-> 같은 타입으로 조회시 빈 이름을 지정하면 해결
	void findbasicBean() {
		MemberRepository bean = ac.getBean(MemberRepository.class);
		
	}

	@Configuration
	static class SameBeanConfig{
		@Bean
		public MemberRepository m1() {
			return new MemoeyMemberRepository();		
		}
		@Bean
		public MemberRepository m2() {
			return new MemoeyMemberRepository();		
		}
		
	}
}
