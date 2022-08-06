package hello.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.basic.discount.DiscountPolicy;
import hello.basic.discount.FixDiscountPolicy;
import hello.basic.discount.RateDiscountPolicy;
import hello.basic.member.MemberRepository;
import hello.basic.member.MemberService;
import hello.basic.member.MemberServiceImpl;
import hello.basic.member.MemoeyMemberRepository;
import hello.basic.order.OrderService;
import hello.basic.order.OrderServiceImpl;

@Configuration
@ComponentScan(

		excludeFilters= 
		@ComponentScan.Filter(type= FilterType.ANNOTATION,classes=Configuration.class)
)

public class AutoAppconfig {

	@Bean
	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}

	@Bean
	public MemberRepository mrespo() {
		return new MemoeyMemberRepository();
	}
	

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(mrespo());
	}


	@Bean	
	public OrderService orderService() {
		return new OrderServiceImpl(
				mrespo(),
				discountPolicy()
				);
	}
}
