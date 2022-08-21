package hello.basic.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;



@Component
public class MemoeyMemberRepository implements MemberRepository{

	private static Map<Long,Member> store = new HashMap<>();
	//TOBE hashmap to ConcurrentHashMap 
	@Override
	public void save(Member member) {
		store.put(member.getId(),member);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member findById(Long memberId) {
		// TODO Auto-generated method stub
		return store.get(memberId);
	}

	
	
}
