package com.findbydema.domain.board.repository;

import com.findbydema.domain.board.entity.Board;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, String> {

    Optional<Board> findByViewId(String viewId);

    List<Board> findAllByOrderByDateAsc();
}
