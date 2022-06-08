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
	public Optional<board> findById(Long id) {
		board board = em.find(board.class, id);
		return Optional.ofNullable(board);
	}
	public List<board> findAll() {
		return em.createQuery("select m from board m", board.class)
				.getResultList();
	}
	public Optional<board> findByName(String name) {
		List<board> result = em.createQuery("select m from board m where m.name = :name", board.class)
				.setParameter("name", name)
				.getResultList();
		return result.stream().findAny();
	}

}