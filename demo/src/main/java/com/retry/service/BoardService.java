package com.retry.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.retry.db.BoardDB;
import com.retry.entity.board;
@Transactional

public class BoardService {

	private final BoardDB boardRepository;
	
	public BoardService(BoardDB boardRepository) {
		 this.boardRepository = boardRepository;
		 }
	
	public String Write(board board) {
		
		boardRepository.save(board);
		return board.getWriter();
	}
}
