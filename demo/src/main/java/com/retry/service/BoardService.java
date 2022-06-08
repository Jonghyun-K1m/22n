package com.retry.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.retry.db.BoardDB;
import com.retry.entity.board;

public class BoardService {

	private final BoardDB boardRepository;
	
	public BoardService(BoardDB boardRepository) {
		 this.boardRepository = boardRepository;
		 }
	@Transactional	
	public void realSAVE(board board) {
		boardRepository.save(board);		
	}

	@Transactional	
	public List<board> showLists() {
		
		 try {
			 return boardRepository.findAll();
		 } finally {
	
		 }
	 }

	

	
	
}
