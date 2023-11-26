package com.roco.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roco.board.dto.CreateBoardDto;
import com.roco.board.entity.Board;
import com.roco.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/boardr")
@RequiredArgsConstructor
public class BoardRestController {
	private final BoardService boardService;
	
	@PostMapping
	public ResponseEntity<Board> createBoard(@RequestBody CreateBoardDto dto) {
		Board board = boardService.createBoard(dto);
		return ResponseEntity.status(HttpStatus.OK).body(board);
	}
	
}
