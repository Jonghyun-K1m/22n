package com.hyeon.demo;


import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;

import com.hyeon.board.dto.boardDTO;
import com.hyeon.board.mapper.boardmapper;

@SpringBootTest
class BoardApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Autowired
	private boardmapper boardMapper;


	@Test
	public void testByApplicationContext() {
		try {

			List<boardDTO> boardList = boardMapper.selectBoardList();
		
				for (boardDTO board : boardList) {
					System.out.println("=========================");
					System.out.println(board.getTitle());

					System.out.println("=========================");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}