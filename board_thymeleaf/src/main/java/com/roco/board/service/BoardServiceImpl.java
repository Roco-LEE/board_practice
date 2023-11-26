package com.roco.board.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.roco.board.dto.CreateBoardDto;
import com.roco.board.dto.UpdateBoardDto;
import com.roco.board.entity.Board;
import com.roco.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 초기화되지 않은 final 필드에 생성자 생성 (Autowired없이)
public class BoardServiceImpl implements BoardService {
	private final BoardRepository boardRepository;

	@Override
	public Board createBoard(CreateBoardDto dto) {
		Board board = Board.toEntity(dto);
		return boardRepository.save(board);
	}

	@Override
	public Board boardDetail(Long id) {
		Board board = boardRepository.findById(id).get();
		board.setReadCount(board.getReadCount()+1L);
		boardRepository.save(board);
		return board;
	}
	
	@Override
	public List<Board> boardList() {
		return boardRepository.findAll();
	}

	@Override
	public Board updateBoard(UpdateBoardDto dto) {
		Board board = boardRepository.findById(dto.getId()).get();
		board.setTitle(dto.getTitle());
		board.setContent(dto.getContent());
		board.setUpdatedAt(LocalDateTime.now());
		return boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Long id) {
		boardRepository.delete(boardRepository.findById(id).get());
	}

}
