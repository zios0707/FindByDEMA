package com.findbydema.domain.board.controller.dto.response;

import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.user.controller.dto.response.UserResponse;
import com.findbydema.domain.user.service.UserFacade;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class GetBoardResponse {
    private final String title;
    private final String subtitle;
    private final String viewId;
    private final UserResponse writer;
    private final Date date;
    private final Long comment;
    private final Long views;
    private final Long likes;
    private final boolean modified;

    public GetBoardResponse(Board board, UserFacade userFacade) {
        this.title = board.getTitle();
        this.subtitle = board.getSubtitle();
        this.viewId = board.getViewId();
        this.writer = userFacade.sidToResponse(board.getWriterSid());
        this.date = board.getDate();
        this.comment = (long) board.getComments().size();
        this.views = board.getViews();
        this.likes = (long) board.getLike_users().size();
        this.modified = board.getModified();
    }

}
