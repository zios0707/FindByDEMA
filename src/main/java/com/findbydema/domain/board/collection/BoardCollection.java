package com.findbydema.domain.board.collection;

import com.findbydema.domain.board.controller.dto.response.GetBoardResponse;
import com.findbydema.domain.board.entity.Board;

import java.util.List;

public class BoardCollection {
    private final List<Board> boards;

    public BoardCollection(List<Board> boards) {
        this.boards = boards;
    }

    public List<GetBoardResponse> toResponse() {
        return boards.stream()
                .map(GetBoardResponse::new)
                .toList();
    }
}
