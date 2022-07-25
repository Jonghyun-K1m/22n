package hello.basic.member;

public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository = new MemoeyMemberRepository(); 
	@Override
	public void join(Member member) {
		// TODO Auto-generated method stub
		memberRepository.save(member);
		
	}

	@Override
	public Member findMember(Long memberId) {
		// TODO Auto-generated method stub
		return memberRepository.findById(memberId);
	}

	
	
}
