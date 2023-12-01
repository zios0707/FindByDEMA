package com.findbydema.domain.board.controller.dto.request;

import lombok.Getter;

@Getter
public class GetListBoardRequest {
    private String query;
    private Boolean like;
}
