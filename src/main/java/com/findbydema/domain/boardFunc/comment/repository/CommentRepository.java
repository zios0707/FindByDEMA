package com.findbydema.domain.boardFunc.comment.repository;

import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.boardFunc.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
    Optional<Comment> findByViewId(String viewId);

    Iterable<Comment> findAllByComment_boardOrderByDateAsc(Board commentBoard);


}
