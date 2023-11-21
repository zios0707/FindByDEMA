package com.findbydema.global.helper;

import com.findbydema.domain.livechat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MakeIdHelper {

    private final ChatRoomRepository chatRoomRepository;

    public String getChatRoomId() {
        long r;

        do {
            r = (int) ((Math.random() * 100501001L) + 11111111L) % 100000000L;
        } while (chatRoomRepository.findByRoomId(Long.toString(r)).isPresent());
        return Long.toString(r);
    }

}
