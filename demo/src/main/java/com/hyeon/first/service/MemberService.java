package com.hyeon.first.service;

import java.util.List;

import com.hyeon.first.domain.Member;
import com.hyeon.first.repository.MemberRepository;
import com.hyeon.first.repository.MemoryMemberRepository;

public class MemberService {

	
	private final MemberRepository memberRepository;
	 public MemberService(MemberRepository memberRepository) {
	 this.memberRepository = memberRepository;
	 }

	public Long join(Member member)
	{
		existdMember(member);
		memberRepository.save(member);
		 return member.getId();
		
	}

	public List<Member> findMembers(){
		return memberRepository.findAll();	
	}

	private void existdMember(Member member) {
		memberRepository.findByName(member.getName())
		.ifPresent(m->
		{
			throw new IllegalStateException("exists");
		});
	}
}
