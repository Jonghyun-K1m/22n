package com.retry.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.tags.Param;

import com.retry.entity.board;
import com.retry.service.BoardService;

@Controller
public class BoardController {
	 private final BoardService bs;
	
	 public BoardController(BoardService bs) {
	 this.bs = bs;
	 }
	 
	 
//	@GetMapping("main")
//	public String main() {
//		return "NewFile";
//    }

	
	    
		@GetMapping("view/{no}")
		public String view(@PathVariable("no") Long id, Model model) {
			board board=bs.findById(id);
			model.addAttribute("Lists", board);	
			model.addAttribute("idvalue", board.getId());	
			
			return "viewpage";
	    }
		@GetMapping("edit/{no}")
		public String edit(@PathVariable("no") Long id, Model model) {
			board board=bs.findById(id);
			model.addAttribute("Lists", board);	
			return "editpage";
	    }
		 
		@GetMapping("index")
		public String index() {
			return "index";
	    }
		@GetMapping("indexgo")
		public String indexgo(Model model) {
			List<board> blist = bs.showLists();
			 model.addAttribute("Lists", blist);
			 return "index";		
	    }			
		@PostMapping("update")
		public String update(board model) {
			//System.out.println(model.getContent()+model.getTitle()+model.getWriter());
			bs.realUPDATE(model);
			//${data}값을 thisisdatavalue로 설정
			return "redirect:/main";
	    }
		
	 
		@PostMapping("delete")
		public String delete(Long id) {
			bs.realDELETE(id);
			return "redirect:/main";
	    }	    
		@PostMapping("post")
		public String post(board model) {
			//System.out.println(model.getContent()+model.getTitle()+model.getWriter());
			bs.realSAVE(model);
			//${data}값을 thisisdatavalue로 설정
			return "redirect:/main";
	    }
		@GetMapping("search")
		public String search(@RequestParam(value="keyword") String keyword,Model model) {
			//model.addAttribute("data", "maain");
			//${data}값을 thisisdatavalue로 설정
			
			List<board> blist =bs.findByTitle(keyword);
			model.addAttribute("Lists", blist);	
			return "NewFile";
	    }
		@GetMapping("searchname")
		public String searchname(@RequestParam(value="keyword") String keyword,Model model) {
			//model.addAttribute("data", "maain");
			//${data}값을 thisisdatavalue로 설정
			
			List<board> blist =bs.findByName(keyword);
			model.addAttribute("Lists", blist);	
			return "NewFile";
	    }		
	@GetMapping("main")
	public String main(Model model) {
		List<board> blist = bs.showLists();
		 model.addAttribute("Lists", blist);
		 return "NewFile";
	
    }
	 
	 
	@GetMapping("write")
	public String write() {
		//model.addAttribute("data", "maain");
		//${data}값을 thisisdatavalue로 설정
		return "write";
    }

	
	
//  post수정용	
//	@PostMapping("post")
//	public String post(board model) {
//		
//		model.builder().writer(model.getWriter())
//					   .title(model.getTitle())
//					   .content(model.getContent())
//					   ;
//		System.out.println(model.getWriter());
//		
//		bs.realSAVE(model);
//		//${data}값을 thisisdatavalue로 설정
//		return "redirect:/write";
//    }

		
	
	
	 
}