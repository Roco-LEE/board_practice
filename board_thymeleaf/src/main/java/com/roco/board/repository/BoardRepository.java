package com.roco.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roco.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	boolean existsById(Long id);
	
}
