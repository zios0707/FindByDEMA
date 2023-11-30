package com.findbydema.global.helper;

import com.findbydema.domain.board.repository.BoardRepository;
import com.findbydema.domain.boardFunc.comment.repository.CommentRepository;
import com.findbydema.domain.livechat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MakeIdHelper {

    private final ChatRoomRepository chatRoomRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public String getChatRoomId() {
        long r;

        do {
            r = (int) ((Math.random() * 100501001L) + 11111111L) % 100000000L;
        } while (chatRoomRepository.findByRoomId(Long.toString(r)).isPresent());
        return Long.toString(r);
    }

    public String getBoardId() {
        long r;

        do {
            r = (int) ((Math.random() * 100501001L) + 11111111L) % 100000000L;
        } while (boardRepository.findByViewId(Long.toString(r)).isPresent());
        return Long.toString(r);
    }

    public String getCommentId() {
        long r;

        do {
            r = (int) ((Math.random() * 100501001L) + 11111111L) % 100000000L;
        } while (commentRepository.findByViewId(Long.toString(r)).isPresent());
        return Long.toString(r);
    }

}
