package com.roco.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roco.board.dto.CreateBoardDto;
import com.roco.board.dto.UpdateBoardDto;
import com.roco.board.entity.Board;
import com.roco.board.service.BoardService;

import jakarta.servlet.http.HttpSession;
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
		if(!boardService.checkBoard(id)) return "redirect:/board";
		model.addAttribute("board", boardService.boardDetail(id));
		return "board";
	}
	
	@GetMapping("/new")
	public String createBoard() {
		return "board-create";
	}
	
	@PostMapping
	public String createBoardAction(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("createdBy") String createdBy, @RequestParam("password") String password) {
		CreateBoardDto dto = CreateBoardDto.builder().title(title).content(content).createdBy(createdBy).password(password).build();
		boardService.createBoard(dto);
		return "redirect:/board";
	}
	
	@GetMapping("/update/{id}")
	public String updateBoard(@PathVariable(name = "id") Long id, Model model, HttpSession session) {
		if((Long)session.getAttribute("updateId") != id) {
			return "redirect:/board";
		};
		model.addAttribute("board", boardService.boardDetail(id));
		return "board-update";
	}

	@PostMapping("/update")
	public String updateBoardAction(@RequestParam("id") Long id, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("password") String password) {
		UpdateBoardDto dto = UpdateBoardDto.builder().id(id).title(title).content(content).build();
		boardService.updateBoard(dto);
		return "redirect:/board/"+id;
	}
	
}
