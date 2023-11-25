package com.roco.board.service;

import java.util.List;

import com.roco.board.dto.CreateBoardDto;
import com.roco.board.dto.UpdateBoardDto;
import com.roco.board.entity.Board;

import jakarta.transaction.Transactional;

@Transactional
public interface BoardService {
	Board createBoard(CreateBoardDto dto);
	
	List<Board> boardList();
	
	Board updateBoard(UpdateBoardDto dto);
	
	void deleteBoard(Long id);
	
}
