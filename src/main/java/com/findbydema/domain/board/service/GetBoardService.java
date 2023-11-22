package com.findbydema.domain.board.service;

import com.findbydema.domain.board.controller.dto.response.GetBoardResponse;
import com.findbydema.domain.board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetBoardService {

    private final BoardFacade boardFacade;

    public GetBoardResponse execute(String viewId) {
        Board board = boardFacade.getBoardByViewId(viewId);

        return GetBoardResponse.builder()
                .title(board.getTitle())
                .writerSid(board.getWriterSid())
                .viewId(board.getViewId())
                .views(board.getViews())
                .likes(board.getLikes())
                .comment(board.getComment())
                .date(board.getDate())
                .modified(board.getModified())
                .build();
    }

}
