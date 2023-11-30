package com.findbydema.domain.boardFunc.comment.collection;

import com.findbydema.domain.boardFunc.comment.controller.dto.response.CommentResponse;
import com.findbydema.domain.boardFunc.comment.entity.Comment;
import com.findbydema.domain.user.service.UserFacade;

import java.util.List;

public class CommentCollection {

    private List<Comment> comments;
    private final UserFacade userFacade;

    public CommentCollection(List<Comment> comments, UserFacade userFacade) {
        this.comments = comments;
        this.userFacade = userFacade;
    }

    public List<CommentResponse> toResponse() {
        return comments.stream()
                .map((comment) -> new CommentResponse(
                        userFacade.sidToResponse(comment.getWriterSid()),
                        comment.getSubtitle(),
                        comment.getViewId(),
                        comment.getDate(),
                        comment.getModified()
                )).toList();
    }
}
