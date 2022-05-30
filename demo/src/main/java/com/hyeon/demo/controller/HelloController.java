package com.hyeon.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("hello")
	//헬로로 매핑
	public String hello(Model model) {
		model.addAttribute("data", "thisisdatavalue");
		//${data}값을 thisisdatavalue로 설정
		return "hello";
		/* 
		 * 
		 *  localhost:8080/hello.html 로 가라
		 */
 }
	@GetMapping("hello-mvc")
	
	public String helloMVC(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		
		return "hello-temp";
	
 }
	 @GetMapping("hello-string")
	 @ResponseBody //html body에 직접 주입함
	 public String helloString(@RequestParam("name") String name) {
	   return "hello " + name;
	 }
	 
	 @GetMapping("hello-api")
	 @ResponseBody
	 public Hello helloApi(@RequestParam("name") String name) {
	 Hello hello = new Hello();
	 hello.setName(name);
	 return hello;
	 }
	 static class Hello {
	 private String name;
	 public String getName() {
	 return name;
	 }
	 public void setName(String name) {
	 this.name = name;
	 }
	 }
	 
	 
}