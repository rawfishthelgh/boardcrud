package com.spring.boardcrud.domain.repository;

import com.spring.boardcrud.domain.entity.Board;
import com.spring.boardcrud.dto.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findByTitleContaining(String keyword);
}
