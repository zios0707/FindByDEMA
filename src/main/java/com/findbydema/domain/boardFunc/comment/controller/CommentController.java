package com.findbydema.domain.boardFunc.comment.controller;

import com.findbydema.domain.boardFunc.comment.controller.dto.request.CreateCommentRequest;
import com.findbydema.domain.boardFunc.comment.controller.dto.request.PatchCommentRequest;
import com.findbydema.domain.boardFunc.comment.controller.dto.response.CommentResponse;
import com.findbydema.domain.boardFunc.comment.service.CreateCommentService;
import com.findbydema.domain.boardFunc.comment.service.DeleteCommentService;
import com.findbydema.domain.boardFunc.comment.service.GetListCommentService;
import com.findbydema.domain.boardFunc.comment.service.PatchCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board/view/{viewId}")
public class CommentController {

    private final CreateCommentService createCommentService;
    private final GetListCommentService getListCommentService;
    private final PatchCommentService patchCommentService;
    private final DeleteCommentService deleteCommentService;

    @PostMapping("/post")
    public void PostComment(@PathVariable String viewId, @RequestBody CreateCommentRequest createCommentRequest) {
        createCommentService.execute(viewId, createCommentRequest);
    }

    @GetMapping("/comments")
    public List<CommentResponse> GetListComment(@PathVariable String viewId) {
        return getListCommentService.execute(viewId);
    }

    @PatchMapping("/{commentId}")
    public void PatchComment(@PathVariable String commentId, @RequestBody PatchCommentRequest patchCommentRequest) {
        patchCommentService.execute(commentId, patchCommentRequest);
    }

    @DeleteMapping("/{commentId}")
    public void DeleteComment(@PathVariable String commentId) {
        deleteCommentService.execute(commentId);
    }
}
