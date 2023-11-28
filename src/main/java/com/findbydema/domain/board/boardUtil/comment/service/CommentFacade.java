package com.findbydema.domain.board.boardUtil.comment.service;

import com.findbydema.domain.board.boardUtil.comment.entity.Comment;
import com.findbydema.domain.board.boardUtil.comment.repository.CommentRepository;
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
        Comment comment = commentRepository.findByViewId(viewId)
                .orElseThrow(() -> new RuntimeException("없는 뷰아이디"));
        User ownUser = userFacade.getInfo();
        return comment.getWriterSid().equals(ownUser.getSid());
    }
}