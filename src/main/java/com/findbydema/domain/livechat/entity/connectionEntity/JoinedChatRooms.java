package com.findbydema.domain.livechat.entity.connectionEntity;

import com.findbydema.domain.livechat.entity.ChatRoom;
import com.findbydema.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class JoinedChatRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "joined_chat_room_id")
    private ChatRoom joinedChatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User joinedUser;

}
