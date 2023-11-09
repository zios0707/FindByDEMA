package com.findbydema.domain.livechat.entity;

import com.findbydema.domain.livechat.entity.connectionEntity.JoinedChatRooms;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatRoom_id")
    private String id;

    private String roomId;

    private String roomName;

    private String chatMentor;

    @OneToMany(mappedBy = "joinedChatRoom")
    private List<JoinedChatRooms> joinedChatRooms = new ArrayList<>();

}
