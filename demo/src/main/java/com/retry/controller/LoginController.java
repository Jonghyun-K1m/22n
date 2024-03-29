package com.retry.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.tags.Param;

import com.retry.entity.board;
import com.retry.entity.user;
import com.retry.service.BoardService;
import com.retry.service.loginService;

import lombok.extern.slf4j.Slf4j;

@Controller

public class LoginController {
	 private final loginService ls = null;
		
	 
 	  @RequestMapping(value="/local", method= RequestMethod.GET)
	    public String index() {
	        return "loginHome/loginPage2";
	    }

	    @RequestMapping(value="login/oauth2/code/naver", method=RequestMethod.GET)
	    public String loginPOSTNaver(HttpSession session) {
	    
	        return "loginHome/callback";
	    }

//	@GetMapping("main")
//	public String main() {
//		return "NewFile";
//    }

	 
	@GetMapping("login")
	public String indext(Model model) {
	
		
		 model.addAttribute("data", "1");
		 return "loginHome/loginPage";		
		
    }	
	
	@PostMapping("loginaction")
	public String login(user model) {
		//System.out.println(model.getContent()+model.getTitle()+model.getWriter());
		ls.loginaction(model);
		//${data}값을 thisisdatavalue로 설정
		return "redirect:/main";
    }
	    

	
	
	 
}