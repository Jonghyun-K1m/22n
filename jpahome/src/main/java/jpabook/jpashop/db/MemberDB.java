package jpabook.jpashop.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor //기능은 MemberService 주석참조
public class MemberDB {

//	@PersistenceContext
	private final EntityManager em;
	
	public void save(Member member) {
		em.persist(member);
	}
	//persist하면 em으로가고 transcation commit때 실db에 반영
	public Member findOne(Long id) {
		return em.find(Member.class,id);
	}
	
	public List<Member> findAll() {
		return em.createQuery("select m from Member m ",Member.class)
				.getResultList();
	}
	
	public List<Member> findByName(String name) {
		return em.createQuery("select m from Member m where m.name=:paramet",Member.class)
				.setParameter("paramet", name)
				.getResultList();
	}
	
	public List<Member> findBySocial(String params) {
		return em.createQuery("select m from Member m where m.salt=:paramet",Member.class)
				.setParameter("paramet", params)
				.getResultList();
	}

	public Member findwithSocial(String params) {
		return em.createQuery("select m from Member m where m.salt=:paramet",Member.class)
				.setParameter("paramet", params)
				.getSingleResult();
	}
		
}
