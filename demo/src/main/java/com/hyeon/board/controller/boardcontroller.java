package com.hyeon.board.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hyeon.board.dto.*;
import com.hyeon.board.service.*;

@Controller
public class boardcontroller {
	
	@Autowired
	private boardservice boardService; 
	
	@RequestMapping("/board/openBoardList.do")
	
	public String openBoardList(Model model) throws Exception{
		System.out.println("Control call");
	
		
	
		
		return "board/openBoardList";
	}
	
	
	
}