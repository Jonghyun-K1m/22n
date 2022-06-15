package com.retry.db;

import com.retry.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// 어느 DB에서도 동작을 보장하기위함
public interface BoardDB {
	board save(board board);
//	Optional<board> findById(Long id);
	board findById(Long id);
	
	List<board> findByName(String name);
	List<board> findByTitle(String title);
	List<board> findAll();
	void delete(Long id);
	void update(board board);
	List<board> findAllpa(Pageable pa);
	int poolSize();
	
}