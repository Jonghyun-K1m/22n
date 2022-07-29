package hello.basic.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.basic.Appconfig;
import hello.basic.member.Grade;
import hello.basic.member.Member;
import hello.basic.member.MemberService;
import hello.basic.member.MemberServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
		
//		Appconfig Appconfigure = new Appconfig();
//		
//		MemberService ms= Appconfigure.memberService();
//		OrderService os= Appconfigure.orderService();

		ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
		MemberService ms = ac.getBean(MemberService.class);
		OrderService os= ac.getBean(OrderService.class);
		
		Member member = new Member(1L,"memberA",Grade.VIP);
		ms.join(member);
		/*
		 * Member findmember = ms.findMember(1L);
		 * 
		 * System.out.println(member.getName());
		 * System.out.println(findmember.getName());
		 */		
		Order order = os.createOrder(member.getId(), "itemA", 20000);
		System.out.println("order " + order);
	}
}
