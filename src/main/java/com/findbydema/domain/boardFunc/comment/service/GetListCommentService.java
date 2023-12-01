package com.findbydema.domain.boardFunc.comment.service;

import com.findbydema.domain.board.service.BoardFacade;
import com.findbydema.domain.boardFunc.comment.collection.CommentCollection;
import com.findbydema.domain.boardFunc.comment.controller.dto.response.CommentResponse;
import com.findbydema.domain.boardFunc.comment.entity.Comment;
import com.findbydema.domain.boardFunc.comment.repository.CommentRepository;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetListCommentService {

    private final CommentRepository commentRepository;
    private final BoardFacade boardFacade;
    private final UserFacade userFacade;

    public List<CommentResponse> execute(String viewId) {
        ArrayList<Comment> comments = (ArrayList<Comment>) commentRepository.findCommentsByCommentboardOrderByDateAsc(boardFacade.getBoardByViewId(viewId));
        CommentCollection commentCollection = new CommentCollection(comments, userFacade);
        return commentCollection.toResponse();
    }
}
