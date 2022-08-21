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
		//AppCONFIG를 비롯한 Configuration 제외
		//BEAN등록대신 @COmponent 하면 등록
		//Appconfig 에서 직접 BEAN으로 의존관계주입하였으나
		//생성자에 @Autowired달아서 자동으로 ㄱㄱ
)




public class AutoAppconfig {

	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}

	
	public MemberRepository mrespo() {
		return new MemoeyMemberRepository();
	}
	

	public MemberService memberService() {
		return new MemberServiceImpl(mrespo());
	}


	public OrderService orderService() {
		return new OrderServiceImpl(
				mrespo(),
				discountPolicy()
				);
	}
}
