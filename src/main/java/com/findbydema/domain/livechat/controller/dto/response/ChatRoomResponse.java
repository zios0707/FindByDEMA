package com.findbydema.domain.livechat.controller.dto.response;

import com.findbydema.domain.livechat.entity.ChatRoom;
import lombok.Getter;

@Getter
public class ChatRoomResponse {

    public String roomName;
    public String roomId;
    public Integer numberOfUsers;

    public ChatRoomResponse(ChatRoom chatRoom) {
        this.roomName = chatRoom.getRoomName();
        this.roomId = chatRoom.getRoomId();
        this.numberOfUsers = chatRoom.getJoin_users().size();
    }


}
