package hello.basic.member;

public class MemberApp {

	public static void main(String[] args) {
	
		MemberService ms= new MemberServiceImpl();
		
		Member member = new Member(1L,"memberA",Grade.VIP);
		ms.join(member);
		Member findmember = ms.findMember(1L);
		
		System.out.println(member.getName());
		System.out.println(findmember.getName());
		
	}
}
