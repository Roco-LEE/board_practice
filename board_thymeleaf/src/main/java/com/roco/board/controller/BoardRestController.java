package com.roco.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Board> createBoard(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("createdBy") String createdBy, @RequestParam("password") String password) {
		CreateBoardDto dto = CreateBoardDto.builder().title(title).content(content).createdBy(createdBy).password(password).build();
		Board board = boardService.createBoard(dto);
		return ResponseEntity.status(HttpStatus.OK).body(board);
	}
	
}
