package com.findbydema.domain.boardFunc.like.service;

import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.board.repository.BoardRepository;
import com.findbydema.domain.board.service.BoardFacade;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.repository.UserRepository;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeService {

    private final BoardFacade boardFacade;
    private final BoardRepository boardRepository;
    private final UserFacade userFacade;
    private final UserRepository userRepository;


    public void execute(String viewId) {
        User user = userFacade.getInfo();
        Board likeBoard = boardFacade.getBoardByViewId(viewId);

        if(user.getBoards().contains(likeBoard)) {
            user.getBoards().remove(likeBoard);
            likeBoard.getLike_users().remove(user);
            userRepository.save(user);
            boardRepository.save(likeBoard);
        }else {
            user.getBoards().add(likeBoard);
            likeBoard.getLike_users().add(user);
            userRepository.save(user);
            boardRepository.save(likeBoard);
        }
    }

}
