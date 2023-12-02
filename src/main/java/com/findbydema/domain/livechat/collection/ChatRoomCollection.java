package com.findbydema.domain.livechat.collection;

import com.findbydema.domain.livechat.controller.dto.response.ChatRoomResponse;
import com.findbydema.domain.livechat.entity.ChatRoom;

import java.util.List;

public class ChatRoomCollection {
    private final List<ChatRoom> chatRooms;

    public ChatRoomCollection(List<ChatRoom> chatRooms) {
        this.chatRooms = chatRooms;
    }

    public List<ChatRoomResponse> toResponse() {
        return chatRooms.stream()
                .map(ChatRoomResponse::new)
                .toList();
    }
}
