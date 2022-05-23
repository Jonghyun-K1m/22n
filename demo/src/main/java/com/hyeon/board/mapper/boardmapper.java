package com.hyeon.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hyeon.board.dto.*;

@Mapper
public interface boardmapper {
	List<boardDTO> selectBoardList() throws Exception;
	
	int insertBoard(boardDTO board) throws Exception;

	boardDTO selectBoardDetail(int boardIdx) throws Exception;

	void updateHitCount(int boardIdx) throws Exception;
	
	void updateBoard(boardDTO board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;
}