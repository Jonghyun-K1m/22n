package hello.basic;

import hello.basic.discount.FixDiscountPolicy;
import hello.basic.member.MemberService;
import hello.basic.member.MemberServiceImpl;
import hello.basic.member.MemoeyMemberRepository;
import hello.basic.order.OrderService;
import hello.basic.order.OrderServiceImpl;

public class Appconfig {
	
	
	public MemberService memberService() {
		return new MemberServiceImpl(new MemoeyMemberRepository());
	}

	public OrderService orderService() {
		return new OrderServiceImpl(
				new MemoeyMemberRepository(),
				new FixDiscountPolicy()
				);
	}
}
