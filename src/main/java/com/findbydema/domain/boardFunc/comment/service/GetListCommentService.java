package com.findbydema.domain.boardFunc.comment.service;

import com.findbydema.domain.boardFunc.comment.entity.Comment;
import com.findbydema.domain.boardFunc.comment.repository.CommentRepository;
import com.findbydema.domain.board.service.BoardFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetListCommentService {

    private final CommentRepository commentRepository;
    private final BoardFacade boardFacade;

    public Iterable<Comment> execute(String viewId) {
        return commentRepository.findAllByComment_boardOrderByDateAsc(boardFacade.getBoardByViewId(viewId));
    }
}
