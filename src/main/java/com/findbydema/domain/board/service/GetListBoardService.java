package com.findbydema.domain.board.service;

import com.findbydema.domain.board.collection.BoardCollection;
import com.findbydema.domain.board.controller.dto.response.GetBoardResponse;
import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetListBoardService {

    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public List<GetBoardResponse> execute(Long offset) {
        List<Board> list = boardRepository.findAllByOrderByDateAsc();
        list = list.stream().skip(offset * 5)
                .limit(5).toList();

        BoardCollection boardCollection = new BoardCollection(list, userFacade);

        return boardCollection.toResponse();
    }
}
