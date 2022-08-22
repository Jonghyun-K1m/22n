package com.retry.db;

import com.retry.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// 어느 DB에서도 동작을 보장하기위함
public interface userDB {
	user save(user board);
//	Optional<board> findById(Long id);
	user findById(Long id);
	
	
	List<user> findByName(String name);
	List<user> findByTitle(String title);
	List<user> findAll();
	void delete(Long id);
	void update(board board);
	List<user> findAllpa(Pageable pa);
	int poolSize();
	
}