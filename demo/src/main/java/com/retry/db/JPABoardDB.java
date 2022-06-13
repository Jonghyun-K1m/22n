package com.retry.db;

import com.retry.*;
import com.retry.entity.board;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
public class JPABoardDB implements BoardDB {
	
	
	private final EntityManager em;
	public JPABoardDB(EntityManager em) {
		this.em = em;
	}
	public board save(board board) {
		em.persist(board);
		return board;
	}
	public void update(board board) {
		em.merge(board);
	//	return board;
	}
	
	public void delete(Long id) {
		board board = em.find(board.class, id);
		
		//em.detach(board);
		//em.merge(board);
		//em.flush();
		em.remove(board);
//	    String jpql="delete from Follow m where m.member_id=:memberid and m.follower_id=:followid";
//	    return em.createQuery(jpql).setParameter("memberid", memberid).setParameter("followid", followid);
//		em.createQuery("delete from board m where m.id = :value ", board.class)
//				 	  .setParameter("value", id);
//		
	}
	
//	public Optional<board> findById(Long id) {
//		board board = em.find(board.class, id);
//		return Optional.ofNullable(board);
//	}
	
	public board findById(Long id) {
		board board = em.find(board.class, id);
		return board;
	}
	public List<board> findAll() {
		return em.createQuery("select m from board m", board.class)
				.getResultList();
	}
	public List<board> findByName(String name) {
		List<board> result = em.createQuery("select m from board m where m.writer = :name", board.class)
				.setParameter("name", name)
				.getResultList();
		return result;
	}
	
	public List<board> findByTitle(String keyword) {
		
		List<board> result = em.createQuery(
			//	"select u from board u where u.title = :keyword", board.class)
				"SELECT u FROM board u WHERE u.title LIKE CONCAT('%',:keyword,'%')", board.class)
				.setParameter("keyword", keyword)
				.getResultList();
		return result;
	}

}