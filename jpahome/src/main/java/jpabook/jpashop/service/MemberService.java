package jpabook.jpashop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.db.MemberDB;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor//파이널생성자만해줌
public class MemberService {

	/*
	 * @Autowired //필드주입
	 */
	private final MemberDB mDB;
	
	//set주입-> 런타임동안바뀔가능성o
	//생성자주입, 생성자하나면 스부트가 알아서 autow함 ,required로 대체
	/*
	public MemberService(MemberDB mDB)
	{
		this.mDB=mDB;
	}
	*/
	//가입
	@Transactional
	public Long join(Member member)
	{
		//중복회원검증
		validateDuplidateMember(member);
		mDB.save(member);
		return member.getId();
	}
	private void validateDuplidateMember(Member member) {
		// TODO Auto-generated method stub
		List<Member> findMembers = mDB.findByName(member.getName());
		if(!findMembers.isEmpty()) {
			throw new IllegalStateException("EXISTS");
		}
		
	}
	
	//조회
	@Transactional(readOnly=true) //스부트 트랜잭션사용,성능개선위한 코드
	public List<Member> findMembers(){
		return mDB.findAll();
	}
	@Transactional(readOnly=true) //스부트 트랜잭션사용,성능개선위한 코드
	public Member findOne(Long memberId){
		return mDB.findOne(memberId);
	}
	@Transactional(readOnly=true) //스부트 트랜잭션사용,성능개선위한 코드
	public Member findOnebySalt(String saltValue){
		return mDB.findwithSocial(saltValue);
	}	


}
