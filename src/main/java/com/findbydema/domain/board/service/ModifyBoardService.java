package com.findbydema.domain.board.service;

import com.findbydema.domain.board.controller.dto.request.ModifyBoardRequest;
import com.findbydema.domain.board.controller.dto.response.BoardViewIdResponse;
import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.board.exception.NotOwnerException;
import com.findbydema.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ModifyBoardService {

    private final BoardRepository boardRepository;
    private final BoardFacade boardFacade;

    public BoardViewIdResponse execute(ModifyBoardRequest modifyBoardRequest, String viewId) {


        Board board = boardFacade.getBoardByViewId(viewId);

        if(boardFacade.isOwn(board)) {
            board.modify(
                    modifyBoardRequest.getTitle(),
                    modifyBoardRequest.getSubtitle()
            );

            boardRepository.save(board);

            return BoardViewIdResponse.builder()
                    .viewId(viewId)
                    .build();
        }else throw NotOwnerException.EXCEPTION;

    }



}
