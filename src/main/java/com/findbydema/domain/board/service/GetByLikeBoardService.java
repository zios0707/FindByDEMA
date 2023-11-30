package com.findbydema.domain.board.service;

import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.board.repository.BoardRepository;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetByLikeBoardService {

    private final UserFacade userFacade;
    private final BoardRepository boardRepository;


    public List<Board> execute() {
        User user = userFacade.getInfo();
        return boardRepository.findAllByLike_users(user);
    }
}
