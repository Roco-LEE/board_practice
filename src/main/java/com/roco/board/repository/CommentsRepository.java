package com.roco.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roco.board.entity.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Long>{

}
