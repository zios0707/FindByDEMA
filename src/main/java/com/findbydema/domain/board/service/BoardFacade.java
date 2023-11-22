package com.findbydema.domain.board.service;

import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardFacade {

    private final BoardRepository boardRepository;

    public Board getBoardByViewId(String viewId) {
        return boardRepository.findByViewId(viewId)
                .orElseThrow(() -> new RuntimeException("보드 뷰아이디 버그"));
    }
}
