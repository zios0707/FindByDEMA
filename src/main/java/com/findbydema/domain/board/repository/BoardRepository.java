package com.findbydema.domain.board.repository;

import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BoardRepository extends JpaRepository<Board, String> {

    Optional<Board> findByViewId(String viewId);

    List<Board> findAllByTitleContainingOrderByDateAsc(String title);

}
