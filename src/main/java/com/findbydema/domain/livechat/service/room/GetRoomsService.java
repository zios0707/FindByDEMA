package com.findbydema.domain.livechat.service.room;

import com.findbydema.domain.livechat.collection.ChatRoomCollection;
import com.findbydema.domain.livechat.controller.dto.response.ChatRoomResponse;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetRoomsService {

    private final UserFacade userFacade;

    public List<ChatRoomResponse> execute() {
        User user = userFacade.getInfo();
        ChatRoomCollection collection = new ChatRoomCollection(user.getChatRooms());
        return collection.toResponse();
    }
}
