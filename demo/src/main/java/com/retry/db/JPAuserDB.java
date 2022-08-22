package com.retry.db;

import com.retry.*;
import com.retry.entity.board;
import com.retry.entity.user;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Query;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;


import java.util.List;
import java.util.Optional;
public class JPAuserDB implements userDB {
	
	
	private final EntityManager em;
	public JPAuserDB(EntityManager em) {
		this.em = em;
	}
	
	
	public user save(user user) {
		em.persist(user);
		return user;
	}
	public void update(user user) {
		em.merge(user);
	//	return board;
	}
	public List<user> findAll() {
		return em.createQuery("select m from board m", user.class)
				.getResultList();
				
	}


	@Override
	public user findById(Long id) {
		user user = em.find(user.class, id);
		return user;
		
	}


	@Override
	public List<user> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<user> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(board board) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<user> findAllpa(Pageable pa) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int poolSize() {
		// TODO Auto-generated method stub
		return 0;
	}



}