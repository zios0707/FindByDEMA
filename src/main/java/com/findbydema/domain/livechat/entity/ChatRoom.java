package com.findbydema.domain.livechat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.findbydema.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    private String id;

    private String roomId;

    private String roomName;

    @JsonIgnore
    @ManyToMany
    private List<User> users;

    public ChatRoom(String roomName, String roomId) {
        this.roomName = roomName;
        this.roomId = roomId;
    }

}
