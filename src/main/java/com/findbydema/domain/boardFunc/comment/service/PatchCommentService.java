package com.findbydema.domain.boardFunc.comment.service;

import com.findbydema.domain.boardFunc.comment.controller.dto.request.PatchCommentRequest;
import com.findbydema.domain.boardFunc.comment.entity.Comment;
import com.findbydema.domain.boardFunc.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatchCommentService {

    private final CommentFacade commentFacade;
    private final CommentRepository commentRepository;

    public void execute(String viewId, PatchCommentRequest patchCommentRequest) {
        Comment comment = commentFacade.getByViewId(viewId);
        comment.Modify(patchCommentRequest.getSubtitle());
        commentRepository.save(comment);
    }
}
