package hello.basic.member;

import hello.basic.Appconfig;

public class MemberApp {

	public static void main(String[] args) {
	
		Appconfig Appconfig =new Appconfig();
		
		MemberService ms= Appconfig.memberService();
		
		Member member = new Member(1L,"memberA",Grade.VIP);
		ms.join(member);
		Member findmember = ms.findMember(1L);
		
		System.out.println(member.getName());
		System.out.println(findmember.getName());
		
	}
}
