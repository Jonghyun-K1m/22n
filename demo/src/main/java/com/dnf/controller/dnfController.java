package com.dnf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dnf.service.dnfService;
import com.dnf.service.dnfServiceBeta;

@Controller
public class dnfController {

	

		private final dnfService ds;
		private final dnfServiceBeta dsb;
		
		public dnfController(dnfService ds, dnfServiceBeta dsb) {
			this.ds = ds;
			this.dsb = dsb;
			
		}
		 
		@GetMapping("/dnf")
		public String dnfHello(Model model) {
			model.addAttribute("h","hello");
			
			return "../dnf_templates/dnfHello";
		}
		@GetMapping("/gogo")
		public String dnfSearch(Model model) {
			model.addAttribute("h","H");
			//dsb.firstSearch();
			return "../dnf_templates/dnfHello";
		}

}
