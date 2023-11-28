package com.findbydema.domain.boardFunc.comment.service;

import com.findbydema.domain.board.exception.NotExistViewIdException;
import com.findbydema.domain.boardFunc.comment.entity.Comment;
import com.findbydema.domain.boardFunc.comment.repository.CommentRepository;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentFacade {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    public boolean isOwn(String viewId) {
        Comment comment = getByViewId(viewId);
        User ownUser = userFacade.getInfo();
        return comment.getWriterSid().equals(ownUser.getSid());
    }

    public Comment getByViewId(String viewId) {
        return commentRepository.findByViewId(viewId)
                .orElseThrow(() -> NotExistViewIdException.EXCEPTION);
    }
}