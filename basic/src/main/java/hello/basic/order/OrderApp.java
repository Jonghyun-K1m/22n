package hello.basic.order;

import hello.basic.Appconfig;
import hello.basic.member.Grade;
import hello.basic.member.Member;
import hello.basic.member.MemberService;
import hello.basic.member.MemberServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
		
		Appconfig Appconfigure = new Appconfig();
		
		MemberService ms= Appconfigure.memberService();
		OrderService os= Appconfigure.orderService();
		
		
		
		Member member = new Member(1L,"memberA",Grade.VIP);
		ms.join(member);
		/*
		 * Member findmember = ms.findMember(1L);
		 * 
		 * System.out.println(member.getName());
		 * System.out.println(findmember.getName());
		 */		
		Order order = os.createOrder(member.getId(), "itemA", 10000);
		System.out.println("order " + order);
	}
}
