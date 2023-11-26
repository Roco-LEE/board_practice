package com.roco.board.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass // 공통의 상위 매핑 정보
public class BaseEntity {
	private String createdBy; // 작성자
	@CreationTimestamp
	@Column(updatable = false) // DB 변경요청이 들어와도 변경하지 않도록 설정
	@ToString.Exclude
	private LocalDateTime createdAt; // 최초 생성시각
	private LocalDateTime updatedAt; // 갱신 시각

}
