package hello.basic.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.basic.Appconfig;

public class MemberApp {

	public static void main(String[] args) {
	
//		Appconfig Appconfig =new Appconfig();
//		MemberService ms= Appconfig.memberService();

		ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
		MemberService ms = ac.getBean(MemberService.class);
		
		//메서드 명으로 name생성댐
		Member member = new Member(1L,"memberA",Grade.VIP);
		ms.join(member);
		Member findmember = ms.findMember(1L);
		
		System.out.println(member.getName());
		System.out.println(findmember.getName());
		
	}
}
