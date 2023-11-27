package com.findbydema.domain.board.service;

import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.board.exception.NotOwnerException;
import com.findbydema.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteBoardService {

    private final BoardFacade boardFacade;
    private final BoardRepository boardRepository;

    public void execute(String viewId) {
        Board deleteBoard = boardFacade.getBoardByViewId(viewId);
        if(boardFacade.isOwn(deleteBoard)) boardRepository.delete(deleteBoard);
        else throw NotOwnerException.EXCEPTION;
    }

}
