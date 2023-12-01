package com.findbydema.domain.board.collection;

import com.findbydema.domain.board.controller.dto.response.GetBoardResponse;
import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.user.service.UserFacade;

import java.util.List;

public class BoardCollection {
    private final List<Board> boards;
    private final UserFacade userFacade;

    public BoardCollection(List<Board> boards, UserFacade userFacade) {
        this.boards = boards;
        this.userFacade = userFacade;
    }

    public List<GetBoardResponse> toResponse() {
        return boards.stream()
                .map(board -> new GetBoardResponse(board, userFacade))
                .toList();
    }
}
