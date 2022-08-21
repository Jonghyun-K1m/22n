package com.retry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
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
	public void realUPDATE(board board) {
		boardRepository.update(board);		
	}
	@Transactional	
	public void realDELETE(Long board) {
		boardRepository.delete(board);		
	}
	@Transactional	
	public board findById(Long input) {
		return boardRepository.findById(input);	
	}

	
	@Transactional	
	public List<board> findByName(String str) {
		 try {
			
			 return boardRepository.findByName(str);
		 } finally {
	
		 }
	}	
	
	@Transactional	
	public List<board> findByTitle(String str) {
		 try {
			
			 return boardRepository.findByTitle(str);
		 } finally {
	
		 }
	}	
	

	@Transactional	
	public List<board> showLists() {
		
		 try {
			 return boardRepository.findAll();
		 } finally {
	
		 }
	 }

	public int poolSize() {
		// TODO Auto-generated method stub
		return boardRepository.poolSize();
		
	}


	

	
	
}
	