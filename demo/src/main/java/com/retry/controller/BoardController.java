package com.retry.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.retry.entity.board;
import com.retry.service.BoardService;

@Controller
public class BoardController {
	 private final BoardService bs;
	
	 public BoardController(BoardService bs) {
	 this.bs = bs;
	 }
	 
	 
	@GetMapping("main")
	public String main() {
		//model.addAttribute("data", "maain");
		//${data}값을 thisisdatavalue로 설정
		return "NewFile";
    }

	@GetMapping("write")
	public String write() {
		//model.addAttribute("data", "maain");
		//${data}값을 thisisdatavalue로 설정
		return "write";
    }
	
	@PostMapping("post")
	public String post(board model) {
		model.builder().writer(model.getWriter()).title(model.getTitle());
		bs.Write(model);
		//${data}값을 thisisdatavalue로 설정
		return "NewFile";
    }
	
	
	
	
	 
}