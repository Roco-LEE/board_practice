package com.roco.board.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.roco.board.dto.CreateBoardDto;
import com.roco.board.dto.UpdateBoardDto;
import com.roco.board.entity.Board;

@SpringBootTest
class BoardServiceImplTest {
	@Autowired
	private BoardService boardService;
	
	@Test
	@Disabled
	void testCreateBoard() {
		CreateBoardDto dto = CreateBoardDto.builder().title("게시글 테스트").content("내용입니다.").createdBy("작성자에요").password("pass").build();
		boardService.createBoard(dto);
	}
	
	@Test
	@Disabled
	void testList() {
		System.out.println(boardService.boardList());
	}
	
	@Test
	void testUpdateBoard() {
		UpdateBoardDto dto = UpdateBoardDto.builder().id(2L).title("수정이요").content("최수정이요ㅋㅋㅋ").build();
		boardService.updateBoard(dto);
	}
	
	@Test
	@Disabled
	void testDeleteBoard() {
		boardService.deleteBoard(1L);
	}

}
