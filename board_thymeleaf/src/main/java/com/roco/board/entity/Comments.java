package com.roco.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Comments extends BaseEntity{
	@Id
	private Long id;
	private String content;
	private String password;
	private Long parentId;
	private Long childId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	//eager : 부모 엔티티 조회시, 자식 엔티티도 즉시 로딩 
	@JoinColumn(name = "boardId")
	private Board board;
	//commit test

}
