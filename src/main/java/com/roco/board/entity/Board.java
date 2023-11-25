package com.roco.board.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	@Id
	private Long id;
	private String title;
	private String content;
	private Long readCount;
	private String writer;
	private String password;
	@ToString.Exclude
	@OneToMany(mappedBy = "board", cascade = {CascadeType.REMOVE,CascadeType.PERSIST}, orphanRemoval = true)
	@Builder.Default
	private List<Comments> comments = new ArrayList<>();
	
	

}
