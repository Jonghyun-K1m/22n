package com.retry;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.retry.db.BoardDB;
import com.retry.db.JPABoardDB;
import com.retry.service.BoardService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

	private final DataSource dataSource;
	private final EntityManager em;
	public SpringConfig(DataSource dataSource, EntityManager em) {
	 this.dataSource = dataSource;
	 this.em = em;
	}
	@Bean
	public BoardService boardService() {
		return new BoardService(boardRepository());
	}
	@Bean
	public BoardDB boardRepository() {
		// return new MemoryMemberRepository();
		// return new JdbcMemberRepository(dataSource);
		// return new JdbcTemplateMemberRepository(dataSource);
		return new JPABoardDB(em);
	}
}