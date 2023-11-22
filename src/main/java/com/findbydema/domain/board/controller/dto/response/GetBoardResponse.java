package com.findbydema.domain.board.controller.dto.response;

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

}
