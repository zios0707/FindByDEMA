package com.findbydema.domain.livechat.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomDTO {

    private String roomId;
    private String name;

    private Set<WebSocketSession> sessions = new HashSet<>();

    public static ChatRoomDTO create(String name) {
        ChatRoomDTO room = new ChatRoomDTO();

        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}
