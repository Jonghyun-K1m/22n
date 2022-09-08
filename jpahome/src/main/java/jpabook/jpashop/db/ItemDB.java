package jpabook.jpashop.db;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor //기능은 MemberService 주석참조
public class ItemDB {

	
	private final EntityManager em;
	
	public void save(Item item) {
		//jpa저장하기전까지 id값이없음
		//persist해야 id값이 지정댐
		//있는놈은 db에 있는거라 update등과같은거임
		if(item.getId()==null) {
			em.persist(item);
		}else {
			em.merge(item);
		}
	}
	
	public Item findOne(Long id) {
		return em.find(Item.class,id);
	}
	
	public List<Item> findAll() {
		return em.createQuery("select i from Item i ",Item.class)
				.getResultList();
	}
	
}
