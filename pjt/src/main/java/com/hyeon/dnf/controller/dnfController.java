package com.hyeon.dnf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hyeon.dnf.service.dnfService;



@Controller
public class dnfController {


	private static dnfService ds;
	

	public dnfController() {

	}
	@GetMapping("main1")
	public String indet(Model model) {
		
		 model.addAttribute("data", "mainpage");
		 return "NewFile";		
		
		 
   }	
	@GetMapping("1st")
	public String indexx(Model model) {
		JSONObject jObject=ds.serverSearch();
		
		model.addAttribute("data", jObject);
		return "dnf/1st";		
		
		 
   }	
	  
	@GetMapping("main")
	public String indext(Model model) {
		
		 model.addAttribute("data", "main");
		 return "dnf/main";		
		
   }	
	    
}
