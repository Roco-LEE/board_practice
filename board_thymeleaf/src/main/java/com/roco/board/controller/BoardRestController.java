package com.roco.board.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roco.board.dto.CreateBoardDto;
import com.roco.board.entity.Board;
import com.roco.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardRestController {
	private final BoardService boardService;
	
	@DeleteMapping("/board/{id}")
	public ResponseEntity<?> deleteBoard(@RequestBody Map<String, Object> request) {
		Long id = Long.parseLong(request.get("id").toString());
	    String password = request.get("password").toString();
		try {
			if(password.equals(boardService.boardDetail(id).getPassword())) {
				boardService.deleteBoard(id);
				return new ResponseEntity<>("Board Deleted Successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Board Deleted Successfully", HttpStatus.OK);
			}
		}catch (Exception e) {
			return new ResponseEntity<>("Error Deleting Board", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}
