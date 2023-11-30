package com.findbydema.domain.board.repository;

import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, String> {

    Optional<Board> findByViewId(String viewId);

    List<Board> findAllByOrderByDateAsc();

    List<Board> findAllByLike_users(User user);

}
