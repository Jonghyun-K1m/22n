package com.retry.service;


import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.retry.db.BoardDB;
import com.retry.db.userDB;
import com.retry.entity.board;
import com.retry.entity.user;


public class loginService {

	
	private final userDB userRepository;
	
	public loginService(userDB userRepository) {
		 this.userRepository = userRepository;
		 }
	
	@Transactional	
	public List<user> showLists() {
		
		 try {
			 return userRepository.findAll();
		 } finally {
	
		 }
	 }

}
