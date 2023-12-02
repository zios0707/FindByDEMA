package com.findbydema.domain.livechat.service.room;

import com.findbydema.domain.livechat.controller.dto.request.CreateRoomRequest;
import com.findbydema.domain.livechat.controller.dto.response.ChatRoomIdResponse;
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

    public ChatRoomIdResponse execute(CreateRoomRequest createRoomRequest) {
        ChatRoom chatRoom = new ChatRoom(createRoomRequest.getRoomName(), helper.getChatRoomId());

        chatRoomRepository.save(chatRoom);
        return ChatRoomIdResponse.builder()
                .roomId(chatRoom.getRoomId())
                .build();
    }
}
