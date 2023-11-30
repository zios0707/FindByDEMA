package com.findbydema.domain.boardFunc.comment.service;

import com.findbydema.domain.board.service.BoardFacade;
import com.findbydema.domain.boardFunc.comment.controller.dto.request.CreateCommentRequest;
import com.findbydema.domain.boardFunc.comment.entity.Comment;
import com.findbydema.domain.boardFunc.comment.repository.CommentRepository;
import com.findbydema.domain.user.service.UserFacade;
import com.findbydema.global.helper.MakeIdHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateCommentService {

    private final CommentRepository commentRepository;
    private final BoardFacade boardFacade;
    private final UserFacade userFacade;
    private final MakeIdHelper helper;

    public void execute(String viewId, CreateCommentRequest createCommentRequest) {
        Comment comment = Comment.builder()
                .writerSid(userFacade.getInfo().getSid())
                .date(new Date())
                .subtitle(createCommentRequest.getSubtitle())
                .viewId(helper.getCommentId())
                .comment_board(boardFacade.getBoardByViewId(viewId))
                .build();

        commentRepository.save(comment);
    }
}
