package com.retry.dto;


import lombok.AccessLevel;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@Builder
//@NoArgsConstructor
//-> builder는 모든인자를 가지는 인스턴스 생성함
// -> JPA는 디폴트생성자가 필요함
// 	 @NoArgsConstructor 이거로 디폴트생성 하면오류남
//@AllArgsConstructor 
@NoArgsConstructor(access = AccessLevel.PROTECTED) 
public class userDTO {
	 
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String pwd;
	 private String etc;
	 private String tell;
	 
	 @Builder
	 public userDTO(Long id ,String pwd, String etc, String tell)
	 {
		 this.id=id;
		 this.pwd=pwd;
		 this.etc=etc;
		 this.tell=tell;		
	 }
	 
}
