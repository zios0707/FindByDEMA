package com.findbydema.domain.livechat.service;

import com.findbydema.domain.livechat.controller.dto.request.CreateRoomRequest;
import com.findbydema.domain.livechat.controller.dto.response.ChattingRoomRequest;
import com.findbydema.domain.livechat.entity.ChatRoom;
import com.findbydema.domain.livechat.repository.ChatRoomRepository;
import com.findbydema.global.helper.MakeIdHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateRoomService {

    private final MakeIdHelper helper;
    private final ChatRoomRepository chatRoomRepository;

    public ChattingRoomRequest execute(CreateRoomRequest createRoomRequest) {
        ChatRoom chatRoom = new ChatRoom(createRoomRequest.getRoomName(), helper.getChatRoomId());

        chatRoomRepository.save(chatRoom);
        return ChattingRoomRequest.builder()
                .roomId(chatRoom.getRoomId())
                .build();
    }
}
