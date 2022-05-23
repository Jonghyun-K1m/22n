package com.hyeon.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyeon.board.dto.boardDTO;
import com.hyeon.board.mapper.*;

@Service
public class boardservice{
	
	@Autowired
	private boardmapper boardMapper;
	
	//@Override
	public List<boardDTO> selectBoardList() throws Exception {
		System.out.println("Control call");
		
		return boardMapper.selectBoardList();
	}
	

}