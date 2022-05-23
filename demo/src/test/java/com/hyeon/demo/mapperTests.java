package com.hyeon.demo;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.hyeon.board.dto.*;
import com.hyeon.board.mapper.*;

@SpringBootTest
class mapperTests {

	@Autowired
	private boardmapper boardMapper;

	public void testSelectList() throws Exception {

			List<boardDTO> boardList = boardMapper.selectBoardList();
			if (CollectionUtils.isEmpty(boardList) == false) {
				for (boardDTO board : boardList) {
					System.out.println("=========================");
					System.out.println(board.getTitle());

					System.out.println("=========================");
				}
			
		}
	}

}