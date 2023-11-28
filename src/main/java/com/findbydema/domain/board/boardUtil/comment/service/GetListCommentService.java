package com.findbydema.domain.board.boardUtil.comment.service;

import com.findbydema.domain.board.boardUtil.comment.entity.Comment;
import com.findbydema.domain.board.boardUtil.comment.repository.CommentRepository;
import com.findbydema.domain.board.repository.BoardRepository;
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
