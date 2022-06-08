package com.retry.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;


@Entity
@Getter
public class board {
	 
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String title;
	 private String content;
	 private String writer;
	 
	 
	 @Builder
	 public board(Long id ,String title, String content, String writer)
	 {
		 this.id=id;
		 this.title=title;
		 this.content=content;
		 this.writer=writer;
		 
	 }
}
