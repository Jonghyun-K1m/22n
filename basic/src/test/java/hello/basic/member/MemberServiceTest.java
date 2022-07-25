package hello.basic.member;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

	MemberService mst= new MemberServiceImpl();
	
	@Test
	void join() {
		
		Member member = new Member(1L,"memberA",Grade.VIP);
		mst.join(member);
		Member findmember = mst.findMember(1L);
		
		Assertions.assertThat(member).isEqualTo(findmember);
		
	}
}
