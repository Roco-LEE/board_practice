package com.roco.board.service;

import java.util.List;

import com.roco.board.entity.Comments;

import jakarta.transaction.Transactional;

@Transactional
public interface CommentsService {
	Comments createComments();
	
	List<Comments> commentsList();
	
	Comments updateComments(Comments comments);
	
	void deleteComments(Long id);

}
