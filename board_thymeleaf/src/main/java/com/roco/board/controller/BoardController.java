package com.roco.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roco.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("boardList", boardService.boardList());
		return "board-list";
	}
	
	@GetMapping("/{id}")
	public String board(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("board", boardService.boardDetail(id));
		return "board";
	}

}
