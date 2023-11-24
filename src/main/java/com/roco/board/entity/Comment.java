package com.roco.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	@Id
	private Long id;
	private String content;
	private String writer;
	private String password;
	private Long parentId;
	private Long childId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "boardId")
	private Board board;

}
