package hello.basic.beanfind;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.basic.Appconfig;
import hello.basic.discount.DiscountPolicy;
import hello.basic.discount.FixDiscountPolicy;
import hello.basic.discount.RateDiscountPolicy;
import hello.basic.member.MemberRepository;
import hello.basic.member.MemberService;
import hello.basic.member.MemberServiceImpl;
import hello.basic.member.MemoeyMemberRepository;

public class beanExtendsTest {

	
	
	ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
	@Test
	@DisplayName("부모 조회시 자식둘이상이면 중복오류")
	void findbasicBean() {
//		DiscountPolicy dp= ac.getBean(DiscountPolicy.class);
		assertThrows(NoUniqueBeanDefinitionException.class,
		() ->ac.getBean(DiscountPolicy.class));
//		System.out.println("ms = " + ms);
//		System.out.println("ms = " + ms.getClass());
//		Assertions.assertThat(ms).isInstanceOf(MemberServiceImpl.class);
	}
	@Test
	@DisplayName("부모 조회시 자식둘이상이면 빈이름 지정")
	void findbasicBean2() {
//		DiscountPolicy dp= ac.getBean(DiscountPolicy.class);
		assertThrows(NoUniqueBeanDefinitionException.class,
		() ->ac.getBean("RateDiscountPolicy" ,DiscountPolicy.class));
//		System.out.println("ms = " + ms);
//		System.out.println("ms = " + ms.getClass());
//		Assertions.assertThat(ms).isInstanceOf(MemberServiceImpl.class);
	}
	@Test
	@DisplayName("Personal test")
	void findbasicBean3() {
		DiscountPolicy dp= ac.getBean("ratedP", DiscountPolicy.class);
		System.out.println("ms = " + dp);
		System.out.println("ms = " + dp.getClass());
		
		DiscountPolicy dpp= ac.getBean("fixdP", DiscountPolicy.class);
		System.out.println("ms = " + dpp);
		System.out.println("ms = " + dpp.getClass());
		
		DiscountPolicy dps= ac.getBean("ratedP", RateDiscountPolicy.class);
		System.out.println("ms = " + dps);
		System.out.println("ms = " + dps.getClass());
		
		
//		Assertions.assertThat(ms).isInstanceOf(MemberServiceImpl.class);
	}
	

	@Configuration
	static class TestConfig{
		@Bean
		public DiscountPolicy ratedP() {
			return new RateDiscountPolicy();		
		}
		@Bean
		public DiscountPolicy fixdP() {
			return new FixDiscountPolicy();		
		}
		
	}
}
