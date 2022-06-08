package com.retry.db;

import com.retry.entity.*;
import java.util.List;
import java.util.Optional;
// 어느 DB에서도 동작을 보장하기위함
public interface BoardDB {
	board save(board board);
	Optional<board> findById(Long id);
	Optional<board> findByName(String name);
	List<board> findAll();
 
}