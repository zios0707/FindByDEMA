package com.findbydema.domain.boardFunc.comment.service;

import com.findbydema.domain.board.exception.NotOwnerException;
import com.findbydema.domain.boardFunc.comment.entity.Comment;
import com.findbydema.domain.boardFunc.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCommentService {

    private final CommentFacade commentFacade;
    private final CommentRepository commentRepository;

    public void execute(String viewId) {
        Comment comment = commentFacade.getByViewId(viewId);
        if(commentFacade.isOwn(viewId)) {
            comment.Delete();
            commentRepository.save(comment);
        }else {
            throw NotOwnerException.EXCEPTION;
        }
    }
}
