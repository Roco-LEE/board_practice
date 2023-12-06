package com.roco.board.controller;

import java.net.URI;
import java.util.Map;

import org.springframework.http.HttpHeaders;
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

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardRestController {
	private final BoardService boardService;
	
	@PostMapping("/board/{id}")
	public ResponseEntity<?> pwCheck(@RequestBody Map<String, Object> request, HttpSession session) {
		Long id = Long.parseLong(request.get("id").toString());
	    String password = request.get("password").toString();
	    String reqType = request.get("reqType").toString();
		try {
			if(password.equals(boardService.boardDetail(id).getPassword())) {
				if(reqType.equals("delete")) {
					boardService.deleteBoard(id);
					return new ResponseEntity<>("Board Deleted Successfully", HttpStatus.OK);
				} else if(reqType.equals("update")) {
					session.setAttribute("updateId", id);
					return new ResponseEntity<>("Board Updated Successfully", HttpStatus.ACCEPTED);
				}
			} else {
				return new ResponseEntity<>("Password Incorrect", HttpStatus.SERVICE_UNAVAILABLE);
			}
		}catch (Exception e) {
			return new ResponseEntity<>("Error Deleting Board", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	
	
	
	
}
