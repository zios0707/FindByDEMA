package com.findbydema.domain.board.service;

import com.findbydema.domain.board.controller.dto.request.CreateBoardRequest;
import com.findbydema.domain.board.controller.dto.response.BoardResponse;
import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.board.repository.BoardRepository;
import com.findbydema.domain.user.service.UserFacade;
import com.findbydema.global.helper.MakeIdHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateBoardService {

    private final BoardRepository boardRepository;
    private final MakeIdHelper helper;
    private final UserFacade userFacade;

    public BoardResponse execute(CreateBoardRequest createBoardRequest) {
        Board board = Board.builder()
                .date(new Date())
                .path(helper.getBoardId())
                .title(createBoardRequest.getTitle())
                .subtitle(createBoardRequest.getSubtitle())
                .writerSid(userFacade.getInfo().getSid())
                .build();

        boardRepository.save(board);

        return BoardResponse.builder()
                .viewId(board.getViewId())
                .build();

    }

}
