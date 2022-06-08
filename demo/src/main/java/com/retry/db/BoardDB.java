package com.retry.db;

import com.retry.entity.*;
import java.util.List;
import java.util.Optional;

public interface BoardDB {
 board save(board board);
 Optional<board> findById(Long id);
 Optional<board> findByName(String name);
 List<board> findAll();
 
}