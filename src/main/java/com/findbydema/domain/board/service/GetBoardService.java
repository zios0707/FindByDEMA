package com.findbydema.domain.board.service;

import com.findbydema.domain.board.controller.dto.response.GetBoardResponse;
import com.findbydema.domain.board.entity.Board;
import com.findbydema.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBoardService {

    private final BoardFacade boardFacade;
    private final BoardRepository boardRepository;

    public GetBoardResponse execute(String viewId, HttpServletResponse response, String cookieList) {
        Board board = boardFacade.getBoardByViewId(viewId);

        boolean youSawThisBoard = false;
        String path = board.getViewId();

        if(cookieList.isEmpty()) {
            createCookie(path, response);
        }else {
            if(!Arrays.asList(cookieList.split("-")).contains(viewId)) {
                List<String> list = new ArrayList<>(Arrays.stream(cookieList.split("-")).toList());
                list.add(viewId);
                createCookie(String.join("-", list), response);
            }else {
                youSawThisBoard = true;
            }
        }

        if(!youSawThisBoard) {
            board.setViews(board.getViews() + 1);
            boardRepository.save(board);
        }

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

    private void createCookie(String path, HttpServletResponse response) {
        // 쿠키 시간 설정 (오전 12시 정각)
        LocalDateTime now = LocalDateTime.now();
        Cookie viewCount = new Cookie("viewCount", path);
        viewCount.setMaxAge(60 * 60 * 24 - (60 * 60 * now.getHour()) - (60 * now.getMinute()) - (now.getSecond()));
        response.addCookie(viewCount);
    }

}
