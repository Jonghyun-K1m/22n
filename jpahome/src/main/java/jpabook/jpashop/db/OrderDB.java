package jpabook.jpashop.db;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor //기능은 MemberService 주석참조
public class OrderDB {

	
	private final EntityManager em;
	
	public void save(Order order) {
			em.persist(order);
	
	}
	
	public Order findOne(Long id) {
		return em.find(Order.class,id);
	}
	
	//TO-BE querydsl
	public List<Order> findAll(OrderSearch osh) {
		
		
		
		
		
		
		return em.createQuery("select o from Order o join o.member m"+
						"where o.status=:status" +
						"and m.name like :name",
				 Order.class)
				.setParameter("status", osh.getOrderStatus())
				.setParameter("name", osh.getMemberName())
				.setMaxResults(100)
				.getResultList();
	}
	
}
