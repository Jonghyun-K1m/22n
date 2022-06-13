package com.retry.entity;

import lombok.AccessLevel;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Builder
//@NoArgsConstructor
//-> builder는 모든인자를 가지는 인스턴스 생성함
// -> JPA는 디폴트생성자가 필요함
// 	 @NoArgsConstructor 이거로 디폴트생성 하면오류남
//@AllArgsConstructor 
@NoArgsConstructor(access = AccessLevel.PROTECTED) 
public class board {
	 
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String title;
	 private String content;
	 private String writer;
	 private LocalDateTime createdTime;
	 private LocalDateTime updatedTime;
	 
	 @Builder
	 public board(Long id ,String title, String content, String writer)
	 {
		 this.id=id;
		 this.title=title;
		 this.content=content;
		 this.writer=writer;		
	 }
	 
}
