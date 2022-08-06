package hello.basic.order;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.basic.Appconfig;
import hello.basic.member.Grade;
import hello.basic.member.Member;
import hello.basic.member.MemberService;
import hello.basic.member.MemberServiceImpl;

public class OrderServiceSingletonTest {

	
		
	MemberService ms;
	OrderService os;
	
	@BeforeEach
	public void beforeEach() {
		Appconfig appc = new Appconfig();
		ms=appc.memberService();
		os=appc.orderService();
	}
	
	@Test
	void createOrder() {
		Long memberid = 1L;
		Member member = new Member(memberid, "memberA",Grade.VIP);
		ms.join(member);
		Order order = os.createOrder(memberid, "itemA", 10000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
		
		
	}
	
}
