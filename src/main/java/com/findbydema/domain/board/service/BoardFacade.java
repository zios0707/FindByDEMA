package com.findbydema.domain.board.service;

import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.board.exception.NotExistViewIdException;
import com.findbydema.domain.board.repository.BoardRepository;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardFacade {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public Board getBoardByViewId(String viewId) {
        return boardRepository.findByViewId(viewId)
                .orElseThrow(() -> NotExistViewIdException.EXCEPTION);
    }

    public boolean isOwn(Board board) {
        User ownUser = userFacade.getInfo();
        return board.getWriterSid().equals(ownUser.getSid());
    }
}
