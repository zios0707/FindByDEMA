package com.findbydema.domain.board.controller.dto.response;

import com.findbydema.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class GetBoardResponse {
    private String title;
    private String viewId;
    private String writerSid;
    private Date date;
    private Long comment;
    private Long views;
    private Long likes;
    private boolean modified;

    public GetBoardResponse(Board board) {
        this.title = board.getTitle();
        this.viewId = board.getViewId();
        this.writerSid = board.getWriterSid();
        this.date = board.getDate();
        this.comment = board.getComment();
        this.views = board.getViews();
        this.likes = board.getLikes();
        this.modified = board.getModified();
    }

}
