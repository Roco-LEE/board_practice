package com.roco.board.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.roco.board.dto.CreateBoardDto;
import com.roco.board.dto.UpdateBoardDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder // 상속받은 필드를 사용할 수 있도록 (부모객체에도 설정 要)
@Data
@EqualsAndHashCode(callSuper = true) // 상속받은 BaseEntity의 Equals, HashCode 재정의
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert // ColumDefault값 자동 insert
@SequenceGenerator(name = "BOARD_SEQ_GENERATOR", sequenceName = "BOARD_SEQ", initialValue = 1, allocationSize = 1)
public class Board extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR") 
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(length = 2000, nullable = false)
	private String content;
	@ColumnDefault(value = "0")
	private Long readCount;
	@ColumnDefault(value = "0")
	private Long likeCount;
	private String password;
	@ToString.Exclude
	@OneToMany(mappedBy = "board", orphanRemoval = true)
	// cascade : 부모 변경시 자식도 변경
	// orphanRemoval : 부모 삭제시 자식도 삭제
	@Builder.Default
	private List<Comments> comments = new ArrayList<>();

	public static Board toEntity(CreateBoardDto dto) {
		return Board.builder().title(dto.getTitle()).content(dto.getContent()).createdBy(dto.getCreatedBy())
				.password(dto.getPassword()).build();
	}
	public static Board toEntity(UpdateBoardDto dto) {
		return Board.builder().id(dto.getId()).title(dto.getTitle()).content(dto.getContent()).build();
	}

}
