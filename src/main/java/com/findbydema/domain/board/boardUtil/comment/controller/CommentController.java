package com.findbydema.domain.board.boardUtil.comment.controller;

import com.findbydema.domain.board.boardUtil.comment.controller.dto.request.CreateCommentRequest;
import com.findbydema.domain.board.boardUtil.comment.entity.Comment;
import com.findbydema.domain.board.boardUtil.comment.service.CreateCommentService;
import com.findbydema.domain.board.boardUtil.comment.service.GetListCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/board/{viewId}")
public class CommentController {

    private final CreateCommentService createCommentService;

    private final GetListCommentService getListCommentService;

    @PostMapping("/post")
    public void PostComment(@PathVariable String viewId, @RequestBody CreateCommentRequest createCommentRequest) {
        createCommentService.execute(viewId, createCommentRequest);
    }

    @GetMapping("/comments")
    public Iterable<Comment> getListComment(@PathVariable String viewId) {
        return getListCommentService.execute(viewId);
    }
}
