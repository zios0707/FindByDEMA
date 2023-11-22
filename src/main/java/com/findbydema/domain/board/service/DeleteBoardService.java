package com.findbydema.domain.board.service;

import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.board.repository.BoardRepository;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteBoardService {

    private final UserFacade userFacade;
    private final BoardFacade boardFacade;
    private final BoardRepository boardRepository;

    public void execute(String viewId) {
        Board deleteBoard = boardFacade.getBoardByViewId(viewId);
        User ownUser = userFacade.getInfo();
        if(deleteBoard.getWriterSid().equals(ownUser.getSid())) throw new RuntimeException("권한 미달");

        boardRepository.delete(deleteBoard);
    }

}
